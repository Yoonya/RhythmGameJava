package dynamic_beat_15;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread { //자기가 알아서 떨어져야 하기 때문에

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();
	private int x, y = 870 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACTH_TIME; // 노트를 그려줄 좌표
	//위의 y의 식은 노트판정라인에 정확히 1초 뒤에 다다르게 해준다. 1초에 1000픽셀떨어지니 1000픽셀임
	private String noteType; //노트타입
	private boolean proceeded = true; //현재 노트가 진행중인지
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	public void close() { //현재 노트를 움직이지 않게 하기 위함
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("A")) {
			x=360;
		}
		else if(noteType.equals("S")) {
			x=516;
		}
		else if(noteType.equals("D")) {
			x=672;
		}
		else if(noteType.equals("Space")) {
			x=828;
		}
		else if(noteType.equals("J")) {
			x=1134;
		}
		else if(noteType.equals("K")) {
			x=1290;
		}
		else if(noteType.equals("L")) {
			x=1446;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space")) { //일반 노트처리
			g.drawImage(noteBasicImage, x, y, null); 
		}
		else { //스페이스바처리
			g.drawImage(noteBasicImage, x, y, null); 
			g.drawImage(noteBasicImage, x + 150, y, null); 
		}
	}
	
	public void drop() { //노트가 떨어진다
		y += Main.NOTE_SPEED; //y좌표 이동
		if(y >940) { //미스판정
			System.out.println("Miss");
			close();
		}
			
	}
	
	@Override
	public void run() { 
		try {
			while(true) {
				drop(); //y좌표 무한 이동
				if(proceeded) { //노트가 진행중이라면
				Thread.sleep(Main.SLEEP_TIME); //그런데 이걸 정해진 시간만큼 쉬었다가 다시 떨어뜨리는.. 
				                               //->0.01초(SLEEP_TIME)에 10픽셀(NOTE_SPEED)만큼 떨어짐 
				}
				else { //노트가 끝난다면
					interrupt(); 
					break;
				}
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	public void judge() {
		if(y>=920) {
			System.out.println("Late");
			close(); //이거 close를 해줘야 노트가 눌렀을때 사라진다.
		}
		else if(y>=910) {
			System.out.println("Good");
			close();
		}
		else if(y>=894) {
			System.out.println("Great");
			close();
		}
		else if(y>=883) {
			System.out.println("Perfect");
			close();
		}
		else if(y>=873) {
			System.out.println("Great");
			close();
		}
		else if(y>=862) {
			System.out.println("Good");
			close();
		}
		else if(y>=850) {
			System.out.println("Early");
			close();
		}
		
	}
}
