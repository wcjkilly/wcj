import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * 
 * 鱼类
 * @author wcj
 *
 */
public class Fish {
  private int x;//鱼X坐标
  private int y;//鱼y坐标
  private boolean live=true;//玩家生命
  private GameStart gs;//关联游戏控制台
  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/imagem2.png"));
  private int width=42;
  private int height=34;
  private int speed=5;
  
  //给鱼加上一个方向
  private int dir=Direct.stop;
  
  //设置缓冲变量
  private boolean u,d,l,r,stop;
  
  public Fish(int x, int y, GameStart gs) {
	this.x = x;
	this.y = y;
	this.gs = gs;
  }
  
  
  //画自己
  public void drawMe(Graphics g){
	  g.drawImage(img, x, y, width,height,gs);
	  move();
  }
  
  //确定按下按键
 
	  public void keyPressed(KeyEvent e) {
			int index=e.getKeyCode();
			switch(index){
			case KeyEvent.VK_W:
				u=true;
				break;
			case KeyEvent.VK_S:
				d=true;
				break;
			case KeyEvent.VK_A:
				l=true;
				break;
			case KeyEvent.VK_D:
				r=true;
				break;
			default:
				break;
			}
		}
	  
	  //确定弹起键
	  
	  public void releseControl(KeyEvent e) {
			int index=e.getKeyCode();
			switch(index){
			case KeyEvent.VK_W:
				u=false;
				break;
			case KeyEvent.VK_S:
				d=false;
				break;
			case KeyEvent.VK_A:
				l=false;
				break;
			case KeyEvent.VK_D:
				r=false;
				break;
			case KeyEvent.VK_K:
			fire();
			default:
				break;
			}
		}
		//根据bool来定向
	  public void locate(){
		  if(u && !d && !l && !r){
			  //表示按上
			  dir =Direct.U;
		  }
		  if(!u && d && !l && !r){
			  //表示按下
			  dir =Direct.D;
		  }
		  
		
		if(!u && !d && l && !r){
			  //表示按左
			  dir =Direct.L;
			  
			//img=tk.getImage(GameStart.class.getResource("imgs/imagem1.png"));
		  }
		  if(!u && !d && !l && r){
			  //表示按右
			  dir =Direct.R;
			  //img=tk.getImage(GameStart.class.getResource("imgs/imagem2.png"));
		  }
		  if(!u && !d && !l && !r){
			  //表示什么都不按
			  dir =Direct.stop;
		  }
	  }
	  //移动
	  public void move(){
		  locate();
		  switch(dir){
		  case 1:
			  y-=speed;
			  break;
		  case 2:
			  y+=speed;
			  break;
		  case 3:
			  x-=speed;
			  break;
		  case 4:
			  x+=speed;
			  break;
		  default:
			  break;
		  }
	  }
	  //获取玩家的封装矩形
	  public Rectangle getRectangle(){
		  return new Rectangle(x,y,width,height);
	  }
	  //吃小鱼
	  public boolean eat(List<FishA> listFishA){
		  for(int i=0;i<listFishA.size();i++){
			  FishA fishA=listFishA.get(i);
			  if(this.live && fishA.isLive() && this.getRectangle().intersects(fishA.getRectangle())){
				  System.out.println("吃到鱼了");
				  //小鱼消失
				  fishA.setLive(false);
				  return true;
			  }
		  }
		  return false;
	  }
	  //发射子弹
	  public void fire(){
		  //弹夹装子弹
		  gs.bulletList.add(new Bullet(x,y,gs));
	  }
  }
  
  

