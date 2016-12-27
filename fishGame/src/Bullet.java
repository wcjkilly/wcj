import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * ×Óµ¯
 * @author wcj
 *
 */
public class Bullet {
  private int x;
  private int y;
  private GameStart gs;
  private int width=12;
  private int height=12;
  
  /*public static Toolkit tk=Toolkit.getDefaultToolkit();
  
  private Image imgBullet=GameStart.tk.getImage(GameStart.class.getResource("imgs/imagem2.png"));*/
  
public Bullet(int x, int y, GameStart gs) {
	super();
	this.x = x;
	this.y = y;
	this.gs = gs;
};
  public void drawMe(Graphics g){
	  //g.drawImage(imgBullet,x, y, width, height, gs);
	  g.fillOval(x,y,width,height);
	  g.setColor(Color.RED);
	  move();
  }
  //×Óµ¯ÒÆ¶¯
  public void move(){
	  x++;
  }
  
}
