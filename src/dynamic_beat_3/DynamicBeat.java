package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage; //더블 버퍼 기법을 사용하기 위함(이미지를 버퍼에 두고 계속 호출하는 기법)
	private Graphics screenGraphic; //이것도 포함해서
	
	private Image introBackground; //이미지 변수생성
	
	public DynamicBeat() {
		setTitle("Dynamic Beat"); //게임제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //사이즈 선언
		setResizable(false); //사이즈를 임의로 못 바꾸게한다.
		setLocationRelativeTo(null); //실행시킬 때, 화면 정중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임을 종료하면 종료가 되게(안넣으면 종료가 안됨)
		setVisible(true); // 눈에 보이도록 함
		
		introBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground(Title).jpg")).getImage();
	    //이미지 변수 초기화
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //이 크기의 이미지를 만들어 초기화
		screenGraphic = screenImage.getGraphics(); //위 이미지를 이용해서 그래픽객체생성
		screenDraw(screenGraphic); //스크린 그래픽에 그림을 그려라
		g.drawImage(screenImage, 0, 0, null); //그런데 위치를 스크린 이미지를 0, 0 위치에 그려
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); //위 그림을 이 위치에 그려라
		this.repaint(); //paint메소드를 다시 불러와 -> 게임이 종료될때까지 계속해서 이미지를 호출하는것
	}
}
