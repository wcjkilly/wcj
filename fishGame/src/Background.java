import java.awt.Graphics;
import java.awt.Image;


public class Background {
	  private int x;//��X����
	  private int y;//��y����
	  private GameStart gs;//������Ϸ����̨
	  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/image297.jpg"));
	  
	public Background(int x, int y, GameStart gs) {
		this.x = x;
		this.y = y;
		this.gs = gs;
	}
	//���Լ�
	  public void drawMe(Graphics g){
		  g.drawImage(img, x, y, gs);
	  }
	  
	  
}
