package dynamic_beat_15;

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
		g.drawImage(judgementLineImage, 0, 870, null);  
		for(int i = 0; i< noteList.size(); i++) {//노트배열에서 출력
			Note note = noteList.get(i);
			if(!note.isProceeded()) { //노트배열이 진행되고 있지않다면
				noteList.remove(i); //지운다
				i--;
			}
			else {
				note.screenDraw(g);
			}
		
		}
		g.drawImage(gameInfoImage, 0, 990, null);//tip:뒷부분에 둘수록 그래픽상 앞에옴
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
		judge("A");//판정
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseA() { //A를 땠을때
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressS() { //S를 눌렀을때
		judge("S");//판정
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseS() { //S를 땠을때
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressD() { //D를 눌렀을때
		judge("D");//판정
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseD() { //D를 땠을때
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressSpace() { //Space를 눌렀을때
		judge("Space");//판정
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseSpace() { //Space를 땠을때
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressJ() { //J를 눌렀을때
		judge("J");//판정
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseJ() { //J를 땠을때
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressK() { //K를 눌렀을때
		judge("K");//판정
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseK() { //K를 땠을때
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	public void pressL() { //L를 눌렀을때
		judge("L");//판정
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//노트루트가 눌렸을때의 색깔로 바뀌게한다.
		new Music("Beat.mp3", false).start();
	}
	public void releaseL() { //L를 땠을때
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//노트루트가 원래 색깔로 바뀌게한다.
	}
	
	@Override
	public void run() { //Thread는 run을 아무것도 없이라로 인자를 넘겨줘야한다. run을 채우면 start로 시작함 
		dropNotes(this.titleName);
	}
	
	public void close() { //게임을 닫았을때
		gameMusic.close(); //게임소리끄고
		this.interrupt(); //쓰레드 종료
	}

	public void dropNotes(String titleName) { //떨어지는 노트
		Beat[] beats = null; // 비트 추가
		if(titleName.equals("Soulworker Main Theme Arrange ver.") && difficulty.equals("Easy")) { //곡명마다 비트가 다르게
			//int startTime = 1000 - Main.REACTH_TIME*1000; //노래 시작부분이 다르기때문에 따로 설정
			int gap2 = 600;
			int gap3 = 1950;
			int gap = 1950; //격차 
			beats = new Beat[] {
					new Beat(2880-gap3, "A"),
					new Beat(3030-gap3, "S"),
					new Beat(3180-gap3, "D"),
					new Beat(4070-gap3, "D"),
					new Beat(4220-gap3, "S"),
					new Beat(4370-gap3, "A"),
					new Beat(5460-gap3, "L"),
					new Beat(5610-gap3, "K"),
					new Beat(5760-gap3, "J"),
					new Beat(6780-gap3, "D"),
					new Beat(6930-gap3, "S"),
					new Beat(7080-gap3, "A"),
					new Beat(8150-gap3, "A"),
					new Beat(8300-gap3, "S"),
					new Beat(8450-gap3, "D"),
					new Beat(9410-gap3, "J"),
					new Beat(9560-gap3, "K"),
					new Beat(9710-gap3, "L"),
					new Beat(10640-gap, "Space"),
					new Beat(10780-gap, "Space"),
					new Beat(10950-gap, "J"),
					new Beat(12100-gap, "K"),
					new Beat(12250-gap, "K"),
					new Beat(12780-gap, "J"),
					new Beat(13070-gap, "L"),
					new Beat(13340-gap, "A"),
					new Beat(13690-gap, "L"),
					new Beat(14020-gap, "A"),
					new Beat(14390-gap, "A"),
					new Beat(14730-gap, "S"),
					new Beat(14880-gap, "D"),
					new Beat(15630-gap, "K"),
					new Beat(16010-gap, "L"),
					new Beat(16350-gap, "J"),
					new Beat(17200-gap, "A"),
					new Beat(17510-gap, "D"),
					new Beat(17920-gap, "A"),
					new Beat(18290-gap, "Space"),
					new Beat(18660-gap, "Space"),
					new Beat(19030-gap, "A"),
					new Beat(19360-gap, "S"),
					new Beat(19720-gap, "D"),
					new Beat(19900-gap, "D"),
					new Beat(20130-gap, "S"),
					new Beat(20250-gap, "D"),
					new Beat(20630-gap, "S"),
					new Beat(20970-gap, "A"),
					new Beat(20130-gap, "A"),
					new Beat(21630-gap, "Space"),
					new Beat(22450-gap, "A"),
					new Beat(22730-gap, "L"),
					new Beat(22890-gap, "A"),
					new Beat(23340-gap, "L"),
					new Beat(23700-gap, "K"),
					new Beat(24020-gap, "J"),
					new Beat(24360-gap, "K"),
					new Beat(24700-gap, "S"),
					new Beat(25070-gap, "D"),
					new Beat(25380-gap, "S"),
					new Beat(25530-gap, "D"),
					new Beat(25930-gap, "A"),
					new Beat(26290-gap, "S"),
					new Beat(26630-gap, "D"),
					new Beat(26950-gap, "Space"),
					new Beat(27730-gap, "J"),
					new Beat(28080-gap, "D"),
					new Beat(28220-gap, "J"),
					new Beat(28660-gap, "S"),
					new Beat(29030-gap, "K"),
					new Beat(29360-gap, "L"),
					new Beat(29680-gap, "A"),
					new Beat(30010-gap, "A"),
					new Beat(30380-gap, "D"),
					new Beat(30650-gap, "S"),
					new Beat(30800-gap, "J"),
					new Beat(30930-gap, "L"),
					new Beat(31310-gap, "K"),
					new Beat(31640-gap, "S"),
					new Beat(31990-gap, "A"),
					new Beat(32320-gap, "S"),
					new Beat(33400-gap, "D"),
					new Beat(33720-gap, "K"),
					new Beat(34070-gap, "K"),
					new Beat(34720-gap, "J"),
					new Beat(35050-gap, "J"),
					new Beat(35530-gap, "L"),
					new Beat(36300-gap, "S"),
					new Beat(37150-gap, "A"),
					new Beat(37330-gap, "S"),
					new Beat(37500-gap, "D"),
					new Beat(37670-gap, "S"),
					new Beat(38600-gap, "L"),
					new Beat(38770-gap, "K"),
					new Beat(38970-gap, "J"),
					new Beat(39880-gap, "Space"),
					new Beat(40080-gap, "D"),
					new Beat(40260-gap, "S"),
					new Beat(40420-gap, "A"),
					new Beat(41210-gap, "A"),
					new Beat(41380-gap, "A"),
					new Beat(41530-gap, "A"),
					new Beat(42230-gap, "Space"),
					new Beat(42710-gap, "Space"),
					new Beat(43030-gap, "J"),
					new Beat(43830-gap, "L"),
					new Beat(44230-gap, "L"),
					new Beat(44810-gap, "K"),
					new Beat(45230-gap, "J"),
					new Beat(45620-gap, "K"),
					new Beat(46270-gap, "S"),
					new Beat(46960-gap, "D"),
					new Beat(47590-gap, "J"),
					new Beat(48120-gap, "A"),
					new Beat(48300-gap, "L"),
					new Beat(48470-gap, "A"),
					new Beat(48470-gap+gap2, "S"),
					new Beat(48470-gap+gap2+500, "L"),
					new Beat(48470-gap+gap2+1000, "K"),
					new Beat(48470-gap+gap2+1500, "K"),
					new Beat(48470-gap+gap2+2050, "J"),
					new Beat(48470-gap+gap2+2490, "S"),
					new Beat(48470-gap+gap2+2890, "S"),
					new Beat(48470-gap+gap2+3250, "D"),
					new Beat(48470-gap+gap2+4720, "Space"),
					new Beat(48470-gap+gap2+5090, "Space"),
					new Beat(48470-gap+gap2+5430, "Space"),
					new Beat(48470-gap+gap2+5760, "Space"),
					new Beat(48470-gap+gap2+5900, "K"),
					new Beat(48470-gap+gap2+6000, "S"),
					new Beat(48470-gap+gap2+6050, "L"),
					new Beat(48470-gap+gap2+6200, "K"),
					new Beat(48470-gap+gap2+6350, "L"),
					new Beat(48470-gap+gap2+6440, "D"),
					new Beat(48470-gap+gap2+6500, "K"),
					new Beat(48470-gap+gap2+6750, "L"),
					new Beat(48470-gap+gap2+6900, "K"),
					new Beat(48470-gap+gap2+6910, "D"),
					new Beat(48470-gap+gap2+7050, "L"),
					new Beat(48470-gap+gap2+7200, "K"),
					new Beat(48470-gap+gap2+7280, "D"),
					new Beat(48470-gap+gap2+7350, "L"),
					new Beat(48470-gap+gap2+7500, "K"),
					new Beat(48470-gap+gap2+7650, "L"),				
					new Beat(48470-gap+gap2+7740, "A"),
					new Beat(48470-gap+gap2+7800, "K"),
					new Beat(48470-gap+gap2+7950, "L"),
					new Beat(48470-gap+gap2+8100, "K"),	
					new Beat(48470-gap+gap2+8170, "S"),
					new Beat(48470-gap+gap2+8250, "L"),
					new Beat(48470-gap+gap2+8560, "K"),
					new Beat(48470-gap+gap2+8900, "A"),
					new Beat(48470-gap+gap2+9050, "S"),
					new Beat(48470-gap+gap2+9200, "A"),
					new Beat(48470-gap+gap2+9350, "S"),
					new Beat(48470-gap+gap2+9500, "A"),
					new Beat(48470-gap+gap2+9580, "L"),
					new Beat(48470-gap+gap2+9650, "S"),
					new Beat(48470-gap+gap2+9730, "L"),
					new Beat(48470-gap+gap2+9800, "A"),	
					new Beat(48470-gap+gap2+9900, "K"),
					new Beat(48470-gap+gap2+9950, "S"),
					new Beat(48470-gap+gap2+10100, "A"),
					new Beat(48470-gap+gap2+10250, "S"),
					new Beat(48470-gap+gap2+10400, "A"),
					new Beat(48470-gap+gap2+10550, "S"),
					new Beat(48470-gap+gap2+10700, "A"),
					new Beat(48470-gap+gap2+10910, "J"),
					new Beat(48470-gap+gap2+11070, "A"),
					new Beat(48470-gap+gap2+11270, "A"),
					new Beat(48470-gap+gap2+12230, "D"),
					new Beat(48470-gap+gap2+12410, "D"),
					new Beat(48470-gap+gap2+12590, "A"),
					new Beat(48470-gap+gap2+13420, "Space"),
					new Beat(48470-gap+gap2+13560, "Space"),
					new Beat(48470-gap+gap2+13730, "Space"),
					new Beat(48470-gap+gap2+14320, "S"),
					new Beat(48470-gap+gap2+14620, "A"),
					new Beat(48470-gap+gap2+14920, "S"),
					new Beat(48470-gap+gap2+15240, "D"),
					new Beat(48470-gap+gap2+15900, "Space"),
					new Beat(48470-gap+gap2+16430, "J"),
					new Beat(48470-gap+gap2+16600, "L"),
					new Beat(48470-gap+gap2+17190, "L"),
					new Beat(48470-gap+gap2+17340, "J"),
					new Beat(48470-gap+gap2+17550, "K"),
					new Beat(48470-gap+gap2+17700, "K"),
					new Beat(48470-gap+gap2+17920, "K"),
					new Beat(48470-gap+gap2+18120, "D"),
					new Beat(48470-gap+gap2+18320, "D"),
					new Beat(48470-gap+gap2+18540, "A"),
					new Beat(48470-gap+gap2+19060, "L"),
					new Beat(48470-gap+gap2+19710, "S"),
					new Beat(48470-gap+gap2+20380, "A"),
					new Beat(48470-gap+gap2+20520, "A"),
					new Beat(48470-gap+gap2+20690, "J"),
					new Beat(48470-gap+gap2+21060, "A"),
					new Beat(48470-gap+gap2+21410, "L"),
					new Beat(48470-gap+gap2+21740, "S"),
					new Beat(48470-gap+gap2+21890, "A"),
					new Beat(48470-gap+gap2+22030, "A"),
					new Beat(48470-gap+gap2+22530, "Space"),
					new Beat(48470-gap+gap2+22830, "Space"),
					new Beat(48470-gap+gap2+23180, "J"),
					new Beat(48470-gap+gap2+23330, "A"),
					new Beat(48470-gap+gap2+23480, "S"),
					new Beat(48470-gap+gap2+23630, "D"),
					new Beat(48470-gap+gap2+23760, "J"),
					new Beat(48470-gap+gap2+24620, "L"),
					new Beat(48470-gap+gap2+24620, "A"),
					new Beat(48470-gap+gap2+25020, "L"),
					new Beat(48470-gap+gap2+25020, "A"),
					new Beat(48470-gap+gap2+25320, "L"),
					new Beat(48470-gap+gap2+25320, "A"),
					new Beat(48470-gap+gap2+25480, "K"),
					new Beat(48470-gap+gap2+25480, "S"),
					new Beat(48470-gap+gap2+25620, "J"),
					new Beat(48470-gap+gap2+25620, "D"),
					new Beat(48470-gap+gap2+25770, "A"),
					new Beat(48470-gap+gap2+25770, "L"),
					new Beat(48470-gap+gap2+25870, "D"),
					new Beat(48470-gap+gap2+25870, "J"),
					new Beat(48470-gap+gap2+26130, "Space"),							
			};
		}
		else if(titleName.equals("Soulworker Main Theme Arrange ver.") && difficulty.equals("Hard")) {
			int startTime = 2000 - Main.REACTH_TIME*1000; //이 식을 만듬으로써 항상 판정바에 적중하게 한다.
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("기적의 분식집 OST - 소금빙수") && difficulty.equals("Easy")) {
			int startTime = 2000 - Main.REACTH_TIME*1000; //이 식을 만듬으로써 항상 판정바에 적중하게 한다.
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("기적의 분식집 OST - 소금빙수") && difficulty.equals("Hard")) {
			int startTime = 2000 - Main.REACTH_TIME*1000; //이 식을 만듬으로써 항상 판정바에 적중하게 한다.
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		if(titleName.equals("방구석의 인어아가씨 OST - Fall In") && difficulty.equals("Easy")) {
			int startTime = 2000 - Main.REACTH_TIME*1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}	
		if(titleName.equals("방구석의 인어아가씨 OST - Fall In") && difficulty.equals("Hard")) {
			int startTime = 2000 - Main.REACTH_TIME*1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start(); //음악실행시켜, 원래 이 명령은 생성자에 있었지만 비트와 같이 두는게 가장 합리적이기 때문에 옮겼다.
		while(i<beats.length && !isInterrupted()) { //Thread의 인터럽트 메소드
			boolean dropped = false; //인터럽트 발생시 설정
			if(beats[i].getTime() <= gameMusic.getTime()) { //만약 노래가 끝나지 않았는데 비트가 계속되면
				Note note = new Note(beats[i].getNoteName()); //노트에 추가시켜서
				note.start(); //시작해
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) { //인터럽트 발생시 
				try {
					Thread.sleep(5); //0.05초 쉬게한다.
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) {
		for(int i = 0 ; i< noteList.size(); i++) {
			Note note = noteList.get(i); //가장 앞에 있는 노트, 즉 가장 아래 있는 노트가 받아질 것
			if(input.equals(note.getNoteType())) { //그것을 노트타입과 비교 A S D .. 비교해서 맞는지
				note.judge(); //그걸 judge함수로 판단
				break; // 반복문 끝
			}
		}		
	}	
}





