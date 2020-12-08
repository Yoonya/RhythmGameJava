package dynamic_beat_13;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Game extends Thread{ //게임이 실행했을 때에 대하여
	
	 //게임화면 디자인
	 private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
				.getImage();//판정라인
	 private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
				.getImage();//노트경로라인	
	 private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
				.getImage();//게임정보
	 private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
	 private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트경로
		
	private String titleName; //곡제목
	private String difficulty; //난이도
	private String musicTitle; //음악제목
	private Music gameMusic; // 게임음악
	
	ArrayList<Note> noteList = new ArrayList<Note>(); //노트를 담을 배열
	
	public Game(String titleName, String difficulty, String musicTitle) { //게임생성자 실행시
		this.titleName = titleName; //제목 받아오고
		this.difficulty = difficulty; //난이도 받아오고
		this.musicTitle = musicTitle; // 음악제목받아오고
		gameMusic = new Music(this.musicTitle, false); //음악 적용시켜주고
		gameMusic.start(); //음악실행시켜
		dropNotes(titleName);//제목을 받아와서 노트를 떨어뜨림
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteAImage, 360, 30, null);
		g.drawImage(noteRouteSImage, 516, 30, null);
		g.drawImage(noteRouteDImage, 672, 30, null);
		g.drawImage(noteRouteSpace1Image, 828, 30, null);
		g.drawImage(noteRouteSpace2Image, 978, 30, null);
		g.drawImage(noteRouteJImage, 1134, 30, null);
		g.drawImage(noteRouteKImage, 1290, 30, null);
		g.drawImage(noteRouteLImage, 1446, 30, null);
		g.drawImage(noteRouteLineImage, 354, 30, null);
		g.drawImage(noteRouteLineImage, 510, 30, null);
		g.drawImage(noteRouteLineImage, 666, 30, null);
		g.drawImage(noteRouteLineImage, 822, 30, null);
		g.drawImage(noteRouteLineImage, 1128, 30, null);
		g.drawImage(noteRouteLineImage, 1284, 30, null);
		g.drawImage(noteRouteLineImage, 1440, 30, null);
		g.drawImage(noteRouteLineImage, 1596, 30, null);
		g.drawImage(gameInfoImage, 0, 990, null);
		g.drawImage(judgementLineImage, 0, 870, null);  
		for(int i = 0; i< noteList.size(); i++) {//노트배열에서 출력
			Note note = noteList.get(i);
			note.screenDraw(g);
		}//tip:뒷부분에 둘수록 그래픽상 앞에옴
		g.setColor(Color.white); //색깔설정
		//폰트가 화질이 안좋기 때문에 안티에일러싱 추가
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Ariel", Font.BOLD, 45)); //폰트설정
		g.drawString(titleName, 30, 1053); //게임정보문장
		g.drawString(difficulty, 1670, 1053); //난이도문장
		g.setColor(Color.DARK_GRAY); //색깔설정
		g.setFont(new Font("Ariel", Font.PLAIN, 39)); //폰트설정
		g.drawString("A", 420, 913); //점수문장
		g.drawString("S", 576, 913); //점수문장
		g.drawString("D", 732, 913); //점수문장
		g.drawString("Space Bar", 883, 913); //점수문장
		g.drawString("J", 1199, 913); //점수문장
		g.drawString("K", 1355, 913); //점수문장
		g.drawString("L", 1511, 913); //점수문장
		g.setColor(Color.LIGHT_GRAY); //색깔설정
		g.setFont(new Font("Elephant", Font.BOLD, 45)); //폰트설정
		g.drawString("000000", 880, 1053); //점수문장
		
	}
	
	public void pressA() { //A를 눌렀을때
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseA() { //A를 땠을때
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressS() { //S를 눌렀을때
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseS() { //S를 땠을때
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressD() { //D를 눌렀을때
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseD() { //D를 땠을때
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressSpace() { //Space를 눌렀을때
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseSpace() { //S를 땠을때
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressJ() { //J를 눌렀을때
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseJ() { //J를 땠을때
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressK() { //K를 눌렀을때
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseK() { //K를 땠을때
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressL() { //L를 눌렀을때
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseL() { //L를 땠을때
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	
	@Override
	public void run() { //Thread는 이런식으로 인자를 넘겨줘야한다. run을 채우면 start로 시작함 //music클래스처럼
		
	}
	
	public void close() { //게임을 닫았을때
		gameMusic.close(); //게임소리끄고
		this.interrupt(); //쓰레드 종료
	}

	public void dropNotes(String titleName) { //떨어지는 노트
		Note note = new Note(360, "short");
		note.start();
		noteList.add(note);
		/*noteList.add(new Note(360, 30, "short")); //노트를 배열에 추가
		noteList.add(new Note(516, 500, "short"));
		noteList.add(new Note(672, 90, "short"));
		noteList.add(new Note(828, 710, "long"));
		noteList.add(new Note(1134, 420, "short"));
		noteList.add(new Note(1290, 620, "short"));
		noteList.add(new Note(1446, 820, "short"));	*/
	}
}
