import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

/**
 * 开始界面
 * @author wcj
 *
 */
public class Start {
	private int x;//鱼X坐标
	  private int y;//鱼y坐标
	  private GameStart gs;//关联游戏控制台
	  
	  public static Toolkit tk=Toolkit.getDefaultToolkit();
	  
	  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/a.jpg"));
	  
	  public Start(int x, int y, GameStart gs) {
		super();
		this.x = x;
		this.y = y;
		this.gs = gs;
	}
	  //画自己
	  public void drawMe(Graphics g){
		  g.drawImage(img, x, y, gs);
		  
	  }
	  public void mouseControl(MouseEvent e){
		 //改变游戏状态
		  gs.gameState=1;
		  
	  }
}
