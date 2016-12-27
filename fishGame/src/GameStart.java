
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
 * ��Ϸ����
 */
public class GameStart extends Frame{
	private int x=100;
	private int y=100;
	//���ʱ�����
	private int time;
	
	//�ػ�����
	private boolean flag=true;
	
	//�����ࣨ���ڻ�ȡ��Ļ��Ⱥ�ͼƬ�ȣ�
	
	public static Toolkit tk=Toolkit.getDefaultToolkit();
	
	//����һ����
	public Fish fish =new Fish(100,200,this);
	
	//��������
	public Background background=new Background(0,0,this);
	
	//��������С��ļ���
	List<FishA> listFishA =new ArrayList<FishA>();
	
	//����һ������
	public List<Bullet> bulletList =new ArrayList<Bullet>();
	
	//������ʼ����
	public Start start=new Start(0,0,this);
	
	//�������
	public Random random=new Random();
	
	//��Ϸ״̬
	public int gameState=0;//0��ʾ����Ϸ��1��ʾ��Ϸ��ʼ��2��ʾ��Ϸ����
	
	//��������
	public Image bgImage;
	
//���췽����������
	public GameStart(){
		//���ô��ڴ�С
		this.setSize(800,600);
		
		//����С������
		this.setTitle("123");
		//�����������
		this.addMouseListener(new MouseControl());
		
		//����
		this.setLocation((tk.getScreenSize().width-800)/2,(tk.getScreenSize().height-600)/2);
		
		//�����ڼ�һ��������
		this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
        	  //�ô���ر�
					System.exit(0);
				}
		});
		//װ��������
		addFishA();
		
		//�����߳̽����ػ� ������run����
		new TestThread().start();
		
		//��ֹ�����϶�
		this.setResizable(false);
		
		//�ڴ���������Ӽ�����
		this.addKeyListener(new KeyControl());
		
		//���ô�����ʾ
		this.setVisible(true);
	}
	//ϵͳ�Ļ滭�ķ���
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
		//�����ӵ�
		for(int i=0;i<bulletList.size();i++){
			Bullet bullet=bulletList.get(i);
			bullet.drawMe(g);
		}
		break;
		default:
			break;
	    }
		
	}
	
	//�м䷽��
	public void update(Graphics g){
		//��������
		if(bgImage==null){
			bgImage=this.createImage(800,600);//��� �߶�		
		}
		//�õ��ڻ����ϻ����ı�
		Graphics bgG=bgImage.getGraphics();
		
		//����
		bgG.setColor(Color.WHITE);
		bgG.fillRect(0, 0, 800, 600);
		
		//����paint����
		paint(bgG);
		
		//�ٰѻ���һ���Ի�����Ļ����
		g.drawImage(bgImage, 0, 0, this);
	}
	
	
	//�ڲ��� �����߳� �ػ�
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
				//����װ������
				addFishA();
			}
		}	
	}
	//��Ӽ��̵ļ�����
	private class KeyControl extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			fish.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			fish.releseControl(e);
		}		
	}
	
	//������
	private class MouseControl extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			start.mouseControl(e);
		}
		
	}
	
	//װ10β��
	public void addFishA(){
		if(time%100==0){
			FishA fishA =new FishA(0,random.nextInt(600),this);
			listFishA.add(fishA);
		}		
	}
	
	//������ڷ���
	public static void main(String[] args){
		new GameStart();
		
	}
	
	
}
