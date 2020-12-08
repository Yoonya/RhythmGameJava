package dynamic_beat_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread { //�ڱⰡ �˾Ƽ� �������� �ϱ� ������

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();
	private int x, y = 870 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED; // ��Ʈ�� �׷��� ��ǥ
	//���� y�� ���� ��Ʈ�������ο� ��Ȯ�� 1�� �ڿ� �ٴٸ��� ���ش�. 1�ʿ� 1000�ȼ��������� 1000�ȼ���
	private String noteType; //��ƮŸ��
	
	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("short")) { //�Ϲ� ��Ʈó��
			g.drawImage(noteBasicImage, x, y, null); 
		}
		else if(noteType.equals("long")) { //�����̽���ó��
			g.drawImage(noteBasicImage, x, y, null); 
			g.drawImage(noteBasicImage, x + 150, y, null); 
		}
	}
	
	public void drop() { //��Ʈ�� ��������
		y += Main.NOTE_SPEED; //y��ǥ �̵�
		
	}
	
	@Override
	public void run() { 
		try {
			while(true) {
				drop(); //y��ǥ ���� �̵�
				Thread.sleep(Main.SLEEP_TIME); //�׷��� �̰� ������ �ð���ŭ �����ٰ� �ٽ� ����߸���.. 
				                               //->0.01��(SLEEP_TIME)�� 10�ȼ�(NOTE_SPEED)��ŭ ������ 
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
