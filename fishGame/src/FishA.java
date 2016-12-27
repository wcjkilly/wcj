import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * 其他的小鱼
 * @author wcj
 *
 */
public class FishA {
	 private int x;//鱼X坐标
	  private int y;//鱼y坐标
	  private boolean live=true;//FishA生命
	  private GameStart gs;//关联游戏控制台
	  
	  public static Toolkit tk=Toolkit.getDefaultToolkit();
	  
	  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/image55.png"));
	  private int width=24;
	  private int height=24;
	  
	  public FishA(int x, int y, GameStart gs) {
			this.x = x;
			this.y = y;
			this.gs = gs;
		}
	  //画自己
	  public void drawMe(Graphics g){
		  if(live == false){
			  //System.out.println("123");
			  return;
		  }
		  g.drawImage(img, x, y,width,height, gs);
		  move();
	  }
	  //小鱼移动
	  public void move(){
		  x++;
	  }
	  //获取FishA的封装矩形
	  public Rectangle getRectangle(){
		  return new Rectangle(x,y,width,height);
	  }
	  
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	  
	  
}
