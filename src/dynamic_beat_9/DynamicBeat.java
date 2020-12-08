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

	private Image screenImage; // 더블 버퍼 기법을 사용하기 위함(이미지를 버퍼에 두고 계속 호출하는 기법)
	private Graphics screenGraphic; // 이것도 포함해서
	
	
	// 배경화면 이미지 변수생성, 초기화
	private Image background = new ImageIcon(Main.class.getResource("../images/IntroBackground(Title).jpg"))
			.getImage();
	
	// 메뉴바 넣기
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// 종료버튼 넣기
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	//메뉴버튼 넣기, 시작하기 종료하기 
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../../../LadyBug/src/images/game_start_button.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	//메뉴버튼 넣기, 왼쪽 오른쪽 
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	//메뉴버튼 넣기, 이지모드 하드모드
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	//메뉴버튼 넣기, 이전으로 돌아가기
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	//버튼 활성화
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY; //마우스의 좌표처리
	
	private boolean isMainScreen = false; //메인화면 비활성화
	
	ArrayList<Track> trackList = new ArrayList<Track>(); //트랙 배열 선언 자료구조
		
	private Image titleImage; //메뉴에서 선택된 이미지의 제목	
	private Image selectedImage; //메뉴에서 선택된 이미지
	private Music selectedMusic; //메뉴에서 선택 음악 
	private int nowSelected = 0;
	private Music introMusic = new Music("introMusic.mp3", true);//음악시작
	
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
		
		introMusic.start();
		//트랙추가 위에서부터 0번
		trackList.add(new Track("Soulworker Title Image.png", "Soulworker Start Image.jpg", 
				"Soulworker Game Image.jpg", "Soulworker Selected.mp3", "Soulworker.mp3"));
		trackList.add(new Track("Philia Title Image.png", "Philia Start Image.png", 
				"Philia Game Image.jpg", "Philia Selected.mp3", "Philia.mp3"));
		trackList.add(new Track("Fallin Title Image.png", "Fallin Start Image.jpg", 
				"Fallin Game Image.jpg", "Fallin Selected.mp3", "Fallin.mp3"));
		
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
				exitButton.setIcon(exitButtonBasicImage); //그림을 바꿔라
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
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
		
		
		startButton.setBounds(40, 650, 400, 162); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				startButton.setIcon(startButtonEnteredImage); //그림을 바꿔라
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				startButton.setIcon(startButtonBasicImage); //그림을 바꿔라
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
			    enterMain();//게임시작이벤트
			}
		});
		
		add(startButton); 
		
		
		quitButton.setBounds(40, 850, 400, 162); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				quitButton.setIcon(quitButtonEnteredImage); //그림을 바꿔라
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				quitButton.setIcon(quitButtonBasicImage); //그림을 바꿔라
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
				try { //위와 같이만 두면 버튼을 클릭하고 음악시작과 동시에 프로그램이 종료된다.
					Thread.sleep(1000); // 그래서 1초 정도의 시간을 둔 후에 종료시킨다.
				}
				catch(InterruptedException ex) {//Thread.sleep과 try catch세트
					ex.printStackTrace();
				}
				System.exit(0); //종료
			}
		});
		
		add(quitButton); 
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 500, 90, 90); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				leftButton.setIcon(leftButtonEnteredImage); //그림을 바꿔라
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				leftButton.setIcon(leftButtonBasicImage); //그림을 바꿔라
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
				selectLeft();//왼쪽 버튼 이벤트
			}
		});
		
		add(leftButton); 
		
		rightButton.setVisible(false);
		rightButton.setBounds(1700, 500, 90, 90); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				rightButton.setIcon(rightButtonEnteredImage); //그림을 바꿔라
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				rightButton.setIcon(rightButtonBasicImage); //그림을 바꿔라
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
				selectRight();//오른쪽버튼이벤트
			}
		});
		
		add(rightButton); 
		
		easyButton.setVisible(false);
		easyButton.setBounds(550, 810, 375, 173); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				easyButton.setIcon(easyButtonEnteredImage); //그림을 바꿔라
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				easyButton.setIcon(easyButtonBasicImage); //그림을 바꿔라
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
				gameStart(nowSelected, "easy");//난이도쉬움 이벤트
			}
		});
		
		add(easyButton); 
		
		hardButton.setVisible(false);
		hardButton.setBounds(1000, 810, 375, 173); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				hardButton.setIcon(hardButtonEnteredImage); //그림을 바꿔라
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				hardButton.setIcon(hardButtonBasicImage); //그림을 바꿔라
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
				gameStart(nowSelected, "hard");//난이도어려움 이벤트
			}
		});
		
		add(hardButton); 
		
		backButton.setVisible(false);
		backButton.setBounds(30, 75, 60, 60); //같은 방법으로 종료버튼 
		//기본적으로 JButton은 기본 모양 템플릿이 있어서 바꿔줘야한다.
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {//마우스가 해당 버튼 위에 올라왔을 때 이벤트 처리
				backButton.setIcon(backButtonEnteredImage); //그림을 바꿔라
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//마우스가 손가락 모양으로
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작 , wav는 안된다..?
			}
			@Override
			public void mouseExited(MouseEvent e) {//마우스가 해당 버튼 위에 나갔을 때 이벤트 처리
				backButton.setIcon(backButtonBasicImage); //그림을 바꿔라
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스를 원래모양으로
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스가 해당 버튼을 눌렀을 때 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //버튼을 클릭했을 때 음악 1번만 실행
				buttonEnteredMusic.start();//음악시작
				backMain();//메인화면으로 돌아가기 이벤트
			}
		});
		
		add(backButton); 
		
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
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 이 크기의 이미지를 만들어 초기화
		screenGraphic = screenImage.getGraphics(); // 위 이미지를 이용해서 그래픽객체생성
		screenDraw(screenGraphic); // 스크린 그래픽에 그림을 그려라
		g.drawImage(screenImage, 0, 0, null); // 그런데 위치를 스크린 이미지를 0, 0 위치에 그려
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // 위 그림을 이 위치에 그려라
		if(isMainScreen) { //메인화면이 true가 됬을때
			g.drawImage(selectedImage, 510, 130, null);
			g.drawImage(titleImage, 510, 40 ,null);
		}
		paintComponents(g); // drawImage처럼 새로 그리는게 아니라, 이미 그려져있는것을 그릴때 호출 (메뉴바같은),
		// 그리고 역동적으로 움직이지 않고 항상고정되어 있는(메뉴바같은)데에서 쓰인다한다. add로 된것들
		this.repaint(); // paint메소드를 다시 불러와 -> 게임이 종료될때까지 계속해서 이미지를 호출하는것
	}
	
	public void selectTrack(int nowSelected) { //현재 선택된 번호를 알려줘서 현재 트랙을 알 수 있게
		if(selectedMusic != null) //현재 노래가 재생되고 있다면
			selectedMusic.close(); //닫기
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();                                         //트랙리스트 배열의 nowSelected번째의 노래의 타이틀이미지에 제목
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
			
	}
	
	public void selectLeft() {
		if(nowSelected == 0) //가장 왼쪽을때
			nowSelected = trackList.size() -1; // 가장 오른쪽으로 변경
		else
			nowSelected--; // 아니면 그냥 한칸 빼기
		selectTrack(nowSelected); // 트랙재설정
	}
	public void selectRight() {
		if(nowSelected == trackList.size() -1) //가장 오른쪽일때
			nowSelected = 0; // 가장 왼쪽으로 변경
		else
			nowSelected++; // 아니면 그냥 한칸 추가
		selectTrack(nowSelected); // 트랙재설정
	}
	
	public void gameStart(int nowSelected, String difficulty) { //게임시작
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false; //메인화면 종료
		leftButton.setVisible(false); //버튼들 안보이게
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(true);//백버튼이 보이게
		background = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getGameImage()))
				.getImage(); //게임이미지로 변환
		
	}
	public void backMain() {//메인돌아가기
		isMainScreen = true; //메인화면 다시 시작
		leftButton.setVisible(true); //버튼들 보이게
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		backButton.setVisible(false);//백버튼이 안보이게
		selectTrack(nowSelected);
	}
	public void enterMain() {//메인들어가기
		selectTrack(0); //1번째트랙으로 설정
		//게임시작 이벤트
		startButton.setVisible(false);//시작버튼이 안보이게
		quitButton.setVisible(false);//종료버튼이 안보이게
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); //화면변경
		leftButton.setVisible(true);//왼쪽버튼이 보이게
		rightButton.setVisible(true);//오른쪽버튼이 보이게
		easyButton.setVisible(true);//이지버튼이 보이게
		hardButton.setVisible(true);//하드버튼이 보이게
		
		isMainScreen = true; //메인화면 활성화
		introMusic.close();
	}
	
}
