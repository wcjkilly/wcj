import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

/**
 * ��ʼ����
 * @author wcj
 *
 */
public class Start {
	private int x;//��X����
	  private int y;//��y����
	  private GameStart gs;//������Ϸ����̨
	  
	  public static Toolkit tk=Toolkit.getDefaultToolkit();
	  
	  private Image img=GameStart.tk.getImage(GameStart.class.getResource("imgs/a.jpg"));
	  
	  public Start(int x, int y, GameStart gs) {
		super();
		this.x = x;
		this.y = y;
		this.gs = gs;
	}
	  //���Լ�
	  public void drawMe(Graphics g){
		  g.drawImage(img, x, y, gs);
		  
	  }
	  public void mouseControl(MouseEvent e){
		 //�ı���Ϸ״̬
		  gs.gameState=1;
		  
	  }
}
