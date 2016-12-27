
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 游戏界面
 */
public class GameStart extends Frame{
	private int x=100;
	private int y=100;
	//添加时间控制
	private int time;
	
	//重画开关
	private boolean flag=true;
	
	//工具类（用于获取屏幕宽度和图片等）
	
	public static Toolkit tk=Toolkit.getDefaultToolkit();
	
	//创建一条鱼
	public Fish fish =new Fish(100,200,this);
	
	//创建背景
	public Background background=new Background(0,0,this);
	
	//创建多条小鱼的集合
	List<FishA> listFishA =new ArrayList<FishA>();
	
	//创建一个弹夹
	public List<Bullet> bulletList =new ArrayList<Bullet>();
	
	//创建开始对象
	public Start start=new Start(0,0,this);
	
	//随机对象
	public Random random=new Random();
	
	//游戏状态
	public int gameState=0;//0表示打开游戏，1表示游戏开始，2表示游戏结束
	
	//创建画布
	public Image bgImage;
	
//构造方法创建窗口
	public GameStart(){
		//设置窗口大小
		this.setSize(800,600);
		
		//设置小组名称
		this.setTitle("123");
		//添加鼠标监听器
		this.addMouseListener(new MouseControl());
		
		//居中
		this.setLocation((tk.getScreenSize().width-800)/2,(tk.getScreenSize().height-600)/2);
		
		//给窗口加一个监听器
		this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
        	  //让窗体关闭
					System.exit(0);
				}
		});
		//装其他的鱼
		addFishA();
		
		//开辟线程进行重画 且启动run方法
		new TestThread().start();
		
		//禁止窗口拖动
		this.setResizable(false);
		
		//在窗口上面添加监听器
		this.addKeyListener(new KeyControl());
		
		//设置窗口显示
		this.setVisible(true);
	}
	//系统的绘画的方法
	public void paint(Graphics g) {
		switch(gameState){
		case 0:
			start.drawMe(g);
			break;
	   case 1:
		background.drawMe(g);
		fish.drawMe(g);
		fish.eat(listFishA);
		for(int i=0;i<listFishA.size();i++){
			FishA fishA=listFishA.get(i);
			fishA.drawMe(g);
		}
		//画出子弹
		for(int i=0;i<bulletList.size();i++){
			Bullet bullet=bulletList.get(i);
			bullet.drawMe(g);
		}
		break;
		default:
			break;
	    }
		
	}
	
	//中间方法
	public void update(Graphics g){
		//创建画布
		if(bgImage==null){
			bgImage=this.createImage(800,600);//宽度 高度		
		}
		//得到在画布上画画的笔
		Graphics bgG=bgImage.getGraphics();
		
		//清屏
		bgG.setColor(Color.WHITE);
		bgG.fillRect(0, 0, 800, 600);
		
		//调用paint方法
		paint(bgG);
		
		//再把画布一次性画在屏幕上面
		g.drawImage(bgImage, 0, 0, this);
	}
	
	
	//内部类 开辟线程 重画
	private class TestThread extends Thread{
		public void run() {
			while(flag){
				try {
					this.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				time++;
				//把鱼装进集合
				addFishA();
			}
		}	
	}
	//添加键盘的监听器
	private class KeyControl extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			fish.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			fish.releseControl(e);
		}		
	}
	
	//鼠标控制
	private class MouseControl extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			start.mouseControl(e);
		}
		
	}
	
	//装10尾鱼
	public void addFishA(){
		if(time%100==0){
			FishA fishA =new FishA(0,random.nextInt(600),this);
			listFishA.add(fishA);
		}		
	}
	
	//程序入口方法
	public static void main(String[] args){
		new GameStart();
		
	}
	
	
}
