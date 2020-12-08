package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage; //���� ���� ����� ����ϱ� ����(�̹����� ���ۿ� �ΰ� ��� ȣ���ϴ� ���)
	private Graphics screenGraphic; //�̰͵� �����ؼ�
	
	private Image introBackground; //�̹��� ��������
	
	public DynamicBeat() {
		setTitle("Dynamic Beat"); //��������
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //������ ����
		setResizable(false); //����� ���Ƿ� �� �ٲٰ��Ѵ�.
		setLocationRelativeTo(null); //�����ų ��, ȭ�� ���߾�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ �����ϸ� ���ᰡ �ǰ�(�ȳ����� ���ᰡ �ȵ�)
		setVisible(true); // ���� ���̵��� ��
		
		introBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground(Title).jpg")).getImage();
	    //�̹��� ���� �ʱ�ȭ
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //�� ũ���� �̹����� ����� �ʱ�ȭ
		screenGraphic = screenImage.getGraphics(); //�� �̹����� �̿��ؼ� �׷��Ȱ�ü����
		screenDraw(screenGraphic); //��ũ�� �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null); //�׷��� ��ġ�� ��ũ�� �̹����� 0, 0 ��ġ�� �׷�
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); //�� �׸��� �� ��ġ�� �׷���
		this.repaint(); //paint�޼ҵ带 �ٽ� �ҷ��� -> ������ ����ɶ����� ����ؼ� �̹����� ȣ���ϴ°�
	}
}
