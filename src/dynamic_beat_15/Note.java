package dynamic_beat_15;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread { //�ڱⰡ �˾Ƽ� �������� �ϱ� ������

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();
	private int x, y = 870 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACTH_TIME; // ��Ʈ�� �׷��� ��ǥ
	//���� y�� ���� ��Ʈ�������ο� ��Ȯ�� 1�� �ڿ� �ٴٸ��� ���ش�. 1�ʿ� 1000�ȼ��������� 1000�ȼ���
	private String noteType; //��ƮŸ��
	private boolean proceeded = true; //���� ��Ʈ�� ����������
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	public void close() { //���� ��Ʈ�� �������� �ʰ� �ϱ� ����
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
		if(!noteType.equals("Space")) { //�Ϲ� ��Ʈó��
			g.drawImage(noteBasicImage, x, y, null); 
		}
		else { //�����̽���ó��
			g.drawImage(noteBasicImage, x, y, null); 
			g.drawImage(noteBasicImage, x + 150, y, null); 
		}
	}
	
	public void drop() { //��Ʈ�� ��������
		y += Main.NOTE_SPEED; //y��ǥ �̵�
		if(y >940) { //�̽�����
			System.out.println("Miss");
			close();
		}
			
	}
	
	@Override
	public void run() { 
		try {
			while(true) {
				drop(); //y��ǥ ���� �̵�
				if(proceeded) { //��Ʈ�� �������̶��
				Thread.sleep(Main.SLEEP_TIME); //�׷��� �̰� ������ �ð���ŭ �����ٰ� �ٽ� ����߸���.. 
				                               //->0.01��(SLEEP_TIME)�� 10�ȼ�(NOTE_SPEED)��ŭ ������ 
				}
				else { //��Ʈ�� �����ٸ�
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
			close(); //�̰� close�� ����� ��Ʈ�� �������� �������.
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
