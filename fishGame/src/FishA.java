import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * ������С��
 * @author wcj
 *
 */
public class FishA {
	 private int x;//��X����
	  private int y;//��y����
	  private boolean live=true;//FishA����
	  private GameStart gs;//������Ϸ����̨
	  
	  public static Toolkit tk=Toolkit.getDefaultToolkit();
	  
	  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/image55.png"));
	  private int width=24;
	  private int height=24;
	  
	  public FishA(int x, int y, GameStart gs) {
			this.x = x;
			this.y = y;
			this.gs = gs;
		}
	  //���Լ�
	  public void drawMe(Graphics g){
		  if(live == false){
			  //System.out.println("123");
			  return;
		  }
		  g.drawImage(img, x, y,width,height, gs);
		  move();
	  }
	  //С���ƶ�
	  public void move(){
		  x++;
	  }
	  //��ȡFishA�ķ�װ����
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
