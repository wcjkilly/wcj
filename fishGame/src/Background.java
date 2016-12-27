import java.awt.Graphics;
import java.awt.Image;


public class Background {
	  private int x;//鱼X坐标
	  private int y;//鱼y坐标
	  private GameStart gs;//关联游戏控制台
	  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/image297.jpg"));
	  
	public Background(int x, int y, GameStart gs) {
		this.x = x;
		this.y = y;
		this.gs = gs;
	}
	//画自己
	  public void drawMe(Graphics g){
		  g.drawImage(img, x, y, gs);
	  }
	  
	  
}
