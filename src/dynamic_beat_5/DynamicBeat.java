package dynamic_beat_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage; // ���� ���� ����� ����ϱ� ����(�̹����� ���ۿ� �ΰ� ��� ȣ���ϴ� ���)
	private Graphics screenGraphic; // �̰͵� �����ؼ�
	// ���ȭ�� �̹��� ��������, �ʱ�ȭ
	private Image background = new ImageIcon(Main.class.getResource("../images/IntroBackground(Title).jpg"))
			.getImage();
	
	// �޴��� �ֱ�
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// �����ư �ֱ�
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	//�޴���ư �ֱ�
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private int mouseX, mouseY; //���콺�� ��ǥó��
	public DynamicBeat() {
		setUndecorated(true);//���� �޴��� ����
		setTitle("Dynamic Beat"); //��������
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //������ ����
		setResizable(false); //����� ���Ƿ� �� �ٲٰ��Ѵ�.
		setLocationRelativeTo(null); //�����ų ��, ȭ�� ���߾�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ �����ϸ� ���ᰡ �ǰ�(�ȳ����� ���ᰡ �ȵ�)
		setVisible(true); // ���� ���̵��� ��
		setBackground(new Color(0, 0, 0, 0));//paintComponent�� ���� �� �Ͼ������
		setLayout(null);//��ư�̳� jLabel�� �־����� �� ��ġ�� ���� �� �ֵ���
		
		exitButton.setBounds(1885, 0, 30, 30); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				exitButton.setIcon(exitButtonEnteredImage); //�׸��� �ٲ��
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				exitButton.setIcon(exitButtonBasicImage); //�׸��� �ٲ��
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttoEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttoEnteredMusic.start();//���ǽ���
				try { //���� ���̸� �θ� ��ư�� Ŭ���ϰ� ���ǽ��۰� ���ÿ� ���α׷��� ����ȴ�.
					Thread.sleep(1000); // �׷��� 1�� ������ �ð��� �� �Ŀ� �����Ų��.
				}
				catch(InterruptedException ex) {//Thread.sleep�� try catch��Ʈ
					ex.printStackTrace();
				}
				System.exit(0); //����
			}
		});
		
		add(exitButton); 
		
		
		startButton.setBounds(40, 650, 400, 162); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				startButton.setIcon(startButtonEnteredImage); //�׸��� �ٲ��
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				startButton.setIcon(startButtonBasicImage); //�׸��� �ٲ��
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttoEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttoEnteredMusic.start();//���ǽ���
			    //���ӽ��� �̺�Ʈ
				startButton.setVisible(false);//���۹�ư�� �Ⱥ��̰�
				quitButton.setVisible(false);//�����ư�� �Ⱥ��̰�
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); //ȭ�麯��
			}
		});
		
		add(startButton); 
		
		
		quitButton.setBounds(40, 850, 400, 162); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				quitButton.setIcon(quitButtonEnteredImage); //�׸��� �ٲ��
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				quitButton.setIcon(quitButtonBasicImage); //�׸��� �ٲ��
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttoEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttoEnteredMusic.start();//���ǽ���
				try { //���� ���̸� �θ� ��ư�� Ŭ���ϰ� ���ǽ��۰� ���ÿ� ���α׷��� ����ȴ�.
					Thread.sleep(1000); // �׷��� 1�� ������ �ð��� �� �Ŀ� �����Ų��.
				}
				catch(InterruptedException ex) {//Thread.sleep�� try catch��Ʈ
					ex.printStackTrace();
				}
				System.exit(0); //����
			}
		});
		
		add(quitButton); 
		
		menuBar.setBounds(0,0,1920,30);//�޴��� ��ġ�� ũ�⸦ ������
		menuBar.addMouseListener(new MouseAdapter() {//���콺 �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) { //���콺 �������� �̺�Ʈ ó��
				mouseX = e.getX(); //x��ǥ �޾ƿ���
				mouseY = e.getY(); //y��ǥ �޾ƿ���
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {//���콺�� �巡�������� �̺�Ʈ ó��
				int x = e.getXOnScreen(); //ȭ�� ���� ��ǥ �޾ƿ���
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); //JFrame ������ ���콺�� �����϶����� �޾ƿ�����ǥ�� �������� �̵�
			}
			
		});
		add(menuBar);//�߰�;
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // �� ũ���� �̹����� ����� �ʱ�ȭ
		screenGraphic = screenImage.getGraphics(); // �� �̹����� �̿��ؼ� �׷��Ȱ�ü����
		screenDraw(screenGraphic); // ��ũ�� �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null); // �׷��� ��ġ�� ��ũ�� �̹����� 0, 0 ��ġ�� �׷�
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // �� �׸��� �� ��ġ�� �׷���
		paintComponents(g); // drawimageó�� ���� �׸��°� �ƴ϶�, �̹� �׷����ִ°��� �׸��� ȣ�� (�޴��ٰ���),
		// �׸��� ���������� �������� �ʰ� �׻�����Ǿ� �ִ�(�޴��ٰ���)������ ���δ��Ѵ�.
		this.repaint(); // paint�޼ҵ带 �ٽ� �ҷ��� -> ������ ����ɶ����� ����ؼ� �̹����� ȣ���ϴ°�
	}
}
