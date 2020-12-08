package dynamic_beat_9;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	//�޴���ư �ֱ�, �����ϱ� �����ϱ� 
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../../../LadyBug/src/images/game_start_button.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	//�޴���ư �ֱ�, ���� ������ 
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	//�޴���ư �ֱ�, ������� �ϵ���
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	//�޴���ư �ֱ�, �������� ���ư���
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	//��ư Ȱ��ȭ
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY; //���콺�� ��ǥó��
	
	private boolean isMainScreen = false; //����ȭ�� ��Ȱ��ȭ
	
	ArrayList<Track> trackList = new ArrayList<Track>(); //Ʈ�� �迭 ���� �ڷᱸ��
		
	private Image titleImage; //�޴����� ���õ� �̹����� ����	
	private Image selectedImage; //�޴����� ���õ� �̹���
	private Music selectedMusic; //�޴����� ���� ���� 
	private int nowSelected = 0;
	private Music introMusic = new Music("introMusic.mp3", true);//���ǽ���
	
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
		
		introMusic.start();
		//Ʈ���߰� ���������� 0��
		trackList.add(new Track("Soulworker Title Image.png", "Soulworker Start Image.jpg", 
				"Soulworker Game Image.jpg", "Soulworker Selected.mp3", "Soulworker.mp3"));
		trackList.add(new Track("Philia Title Image.png", "Philia Start Image.png", 
				"Philia Game Image.jpg", "Philia Selected.mp3", "Philia.mp3"));
		trackList.add(new Track("Fallin Title Image.png", "Fallin Start Image.jpg", 
				"Fallin Game Image.jpg", "Fallin Selected.mp3", "Fallin.mp3"));
		
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
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
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
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
			    enterMain();//���ӽ����̺�Ʈ
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
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
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
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 500, 90, 90); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				leftButton.setIcon(leftButtonEnteredImage); //�׸��� �ٲ��
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				leftButton.setIcon(leftButtonBasicImage); //�׸��� �ٲ��
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
				selectLeft();//���� ��ư �̺�Ʈ
			}
		});
		
		add(leftButton); 
		
		rightButton.setVisible(false);
		rightButton.setBounds(1700, 500, 90, 90); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				rightButton.setIcon(rightButtonEnteredImage); //�׸��� �ٲ��
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				rightButton.setIcon(rightButtonBasicImage); //�׸��� �ٲ��
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
				selectRight();//�����ʹ�ư�̺�Ʈ
			}
		});
		
		add(rightButton); 
		
		easyButton.setVisible(false);
		easyButton.setBounds(550, 810, 375, 173); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				easyButton.setIcon(easyButtonEnteredImage); //�׸��� �ٲ��
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				easyButton.setIcon(easyButtonBasicImage); //�׸��� �ٲ��
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
				gameStart(nowSelected, "easy");//���̵����� �̺�Ʈ
			}
		});
		
		add(easyButton); 
		
		hardButton.setVisible(false);
		hardButton.setBounds(1000, 810, 375, 173); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				hardButton.setIcon(hardButtonEnteredImage); //�׸��� �ٲ��
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				hardButton.setIcon(hardButtonBasicImage); //�׸��� �ٲ��
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
				gameStart(nowSelected, "hard");//���̵������ �̺�Ʈ
			}
		});
		
		add(hardButton); 
		
		backButton.setVisible(false);
		backButton.setBounds(30, 75, 60, 60); //���� ������� �����ư 
		//�⺻������ JButton�� �⺻ ��� ���ø��� �־ �ٲ�����Ѵ�.
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() { //���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {//���콺�� �ش� ��ư ���� �ö���� �� �̺�Ʈ ó��
				backButton.setIcon(backButtonEnteredImage); //�׸��� �ٲ��
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �հ��� �������
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ��� , wav�� �ȵȴ�..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//���콺�� �ش� ��ư ���� ������ �� �̺�Ʈ ó��
				backButton.setIcon(backButtonBasicImage); //�׸��� �ٲ��
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺�� �����������
			}
			@Override
			public void mousePressed(MouseEvent e) {//���콺�� �ش� ��ư�� ������ �� �̺�Ʈ ó��
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //��ư�� Ŭ������ �� ���� 1���� ����
				buttonEnteredMusic.start();//���ǽ���
				backMain();//����ȭ������ ���ư��� �̺�Ʈ
			}
		});
		
		add(backButton); 
		
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
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // �� ũ���� �̹����� ����� �ʱ�ȭ
		screenGraphic = screenImage.getGraphics(); // �� �̹����� �̿��ؼ� �׷��Ȱ�ü����
		screenDraw(screenGraphic); // ��ũ�� �׷��ȿ� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null); // �׷��� ��ġ�� ��ũ�� �̹����� 0, 0 ��ġ�� �׷�
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // �� �׸��� �� ��ġ�� �׷���
		if(isMainScreen) { //����ȭ���� true�� ������
			g.drawImage(selectedImage, 510, 130, null);
			g.drawImage(titleImage, 510, 40 ,null);
		}
		paintComponents(g); // drawImageó�� ���� �׸��°� �ƴ϶�, �̹� �׷����ִ°��� �׸��� ȣ�� (�޴��ٰ���),
		// �׸��� ���������� �������� �ʰ� �׻�����Ǿ� �ִ�(�޴��ٰ���)������ ���δ��Ѵ�. add�� �Ȱ͵�
		this.repaint(); // paint�޼ҵ带 �ٽ� �ҷ��� -> ������ ����ɶ����� ����ؼ� �̹����� ȣ���ϴ°�
	}
	
	public void selectTrack(int nowSelected) { //���� ���õ� ��ȣ�� �˷��༭ ���� Ʈ���� �� �� �ְ�
		if(selectedMusic != null) //���� �뷡�� ����ǰ� �ִٸ�
			selectedMusic.close(); //�ݱ�
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();                                         //Ʈ������Ʈ �迭�� nowSelected��°�� �뷡�� Ÿ��Ʋ�̹����� ����
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
			
	}
	
	public void selectLeft() {
		if(nowSelected == 0) //���� ��������
			nowSelected = trackList.size() -1; // ���� ���������� ����
		else
			nowSelected--; // �ƴϸ� �׳� ��ĭ ����
		selectTrack(nowSelected); // Ʈ���缳��
	}
	public void selectRight() {
		if(nowSelected == trackList.size() -1) //���� �������϶�
			nowSelected = 0; // ���� �������� ����
		else
			nowSelected++; // �ƴϸ� �׳� ��ĭ �߰�
		selectTrack(nowSelected); // Ʈ���缳��
	}
	
	public void gameStart(int nowSelected, String difficulty) { //���ӽ���
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false; //����ȭ�� ����
		leftButton.setVisible(false); //��ư�� �Ⱥ��̰�
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(true);//���ư�� ���̰�
		background = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getGameImage()))
				.getImage(); //�����̹����� ��ȯ
		
	}
	public void backMain() {//���ε��ư���
		isMainScreen = true; //����ȭ�� �ٽ� ����
		leftButton.setVisible(true); //��ư�� ���̰�
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		backButton.setVisible(false);//���ư�� �Ⱥ��̰�
		selectTrack(nowSelected);
	}
	public void enterMain() {//���ε���
		selectTrack(0); //1��°Ʈ������ ����
		//���ӽ��� �̺�Ʈ
		startButton.setVisible(false);//���۹�ư�� �Ⱥ��̰�
		quitButton.setVisible(false);//�����ư�� �Ⱥ��̰�
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); //ȭ�麯��
		leftButton.setVisible(true);//���ʹ�ư�� ���̰�
		rightButton.setVisible(true);//�����ʹ�ư�� ���̰�
		easyButton.setVisible(true);//������ư�� ���̰�
		hardButton.setVisible(true);//�ϵ��ư�� ���̰�
		
		isMainScreen = true; //����ȭ�� Ȱ��ȭ
		introMusic.close();
	}
	
}
