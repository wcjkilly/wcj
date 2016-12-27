import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * 
 * ����
 * @author wcj
 *
 */
public class Fish {
  private int x;//��X����
  private int y;//��y����
  private boolean live=true;//�������
  private GameStart gs;//������Ϸ����̨
  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/imagem2.png"));
  private int width=42;
  private int height=34;
  private int speed=5;
  
  //�������һ������
  private int dir=Direct.stop;
  
  //���û������
  private boolean u,d,l,r,stop;
  
  public Fish(int x, int y, GameStart gs) {
	this.x = x;
	this.y = y;
	this.gs = gs;
  }
  
  
  //���Լ�
  public void drawMe(Graphics g){
	  g.drawImage(img, x, y, width,height,gs);
	  move();
  }
  
  //ȷ�����°���
 
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
	  
	  //ȷ�������
	  
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
		//����bool������
	  public void locate(){
		  if(u && !d && !l && !r){
			  //��ʾ����
			  dir =Direct.U;
		  }
		  if(!u && d && !l && !r){
			  //��ʾ����
			  dir =Direct.D;
		  }
		  
		
		if(!u && !d && l && !r){
			  //��ʾ����
			  dir =Direct.L;
			  
			//img=tk.getImage(GameStart.class.getResource("imgs/imagem1.png"));
		  }
		  if(!u && !d && !l && r){
			  //��ʾ����
			  dir =Direct.R;
			  //img=tk.getImage(GameStart.class.getResource("imgs/imagem2.png"));
		  }
		  if(!u && !d && !l && !r){
			  //��ʾʲô������
			  dir =Direct.stop;
		  }
	  }
	  //�ƶ�
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
	  //��ȡ��ҵķ�װ����
	  public Rectangle getRectangle(){
		  return new Rectangle(x,y,width,height);
	  }
	  //��С��
	  public boolean eat(List<FishA> listFishA){
		  for(int i=0;i<listFishA.size();i++){
			  FishA fishA=listFishA.get(i);
			  if(this.live && fishA.isLive() && this.getRectangle().intersects(fishA.getRectangle())){
				  System.out.println("�Ե�����");
				  //С����ʧ
				  fishA.setLive(false);
				  return true;
			  }
		  }
		  return false;
	  }
	  //�����ӵ�
	  public void fire(){
		  //����װ�ӵ�
		  gs.bulletList.add(new Bullet(x,y,gs));
	  }
  }
  
  

