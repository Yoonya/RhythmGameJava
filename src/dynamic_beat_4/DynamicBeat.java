package dynamic_beat_4;

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

	private Image screenImage; // 더블 버퍼 기법을 사용하기 위함(이미지를 버퍼에 두고 계속 호출하는 기법)
	private Graphics screenGraphic; // 이것도 포함해서

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground(Title).jpg"))
			.getImage();
	// 배경화면 이미지 변수생성, 초기화
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// 메뉴바 넣기
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBagicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBagicImage);
	// 종료버튼 넣기
	private int mouseX, mouseY; //마우스의 좌표처리
	public DynamicBeat() {
		setUndecorated(true);//기존 메뉴바 삭제
		setTitle("Dynamic Beat"); //게임제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //사이즈 선언
		setResizable(false); //사이즈를 임의로 못 바꾸게한다.
		setLocationRelativeTo(null); //실행시킬 때, 화면 정중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임을 종료하면 종료가 되게(안넣으면 종료가 안됨)
		setVisible(true); // 눈에 보이도록 함
		setBackground(new Color(0, 0, 0, 0));//paintComponent를 했을 때 하얀색으로
		setLayout(null);//버튼이나 jLabel을 넣었을때 그 위치에 있을 수 있도록
		
		exitButton.setBounds(1885, 0, 30, 30); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				exitButton.setIcon(exitButtonEnteredImage); //그림을 바꿔라
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				exitButton.setIcon(exitButtonBagicImage); //그림을 바꿔라
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttoEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttoEnteredMusic.start();//음악시작
				try { //위와 같이만 두면 버튼을 클릭하고 음악시작과 동시에 프로그램이 종료된다.
					Thread.sleep(1000); // 그래서 1초 정도의 시간을 둔 후에 종료시킨다.
				}
				catch(InterruptedException ex) {//Thread.sleep과 try catch세트
					ex.printStackTrace();
				}
				System.exit(0); //종료
			}
		});
		
		add(exitButton); 
		
		menuBar.setBounds(0,0,1920,30);//메뉴바 위치와 크기를 정해줌
		menuBar.addMouseListener(new MouseAdapter() {//마우스 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) { //마우스 눌렀을때 이벤트 처리
				mouseX = e.getX(); //x좌표 받아오기
				mouseY = e.getY(); //y좌표 받아오기
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {//마우스를 드래그했을때 이벤트 처리
				int x = e.getXOnScreen(); //화면 위의 좌표 받아오기
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); //JFrame 위에서 마우스를 움직일때마다 받아오는좌표로 프레임을 이동
			}
			
		});
		add(menuBar);//추가;
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 이 크기의 이미지를 만들어 초기화
		screenGraphic = screenImage.getGraphics(); // 위 이미지를 이용해서 그래픽객체생성
		screenDraw(screenGraphic); // 스크린 그래픽에 그림을 그려라
		g.drawImage(screenImage, 0, 0, null); // 그런데 위치를 스크린 이미지를 0, 0 위치에 그려
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // 위 그림을 이 위치에 그려라
		paintComponents(g); // drawimage처럼 새로 그리는게 아니라, 이미 그려져있는것을 그릴때 호출 (메뉴바같은),
		// 그리고 역동적으로 움직이지 않고 항상고정되어 있는(메뉴바같은)데에서 쓰인다한다.
		this.repaint(); // paint메소드를 다시 불러와 -> 게임이 종료될때까지 계속해서 이미지를 호출하는것
	}
}
