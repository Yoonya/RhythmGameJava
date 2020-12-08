package dynamic_beat_13;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Game extends Thread{ //������ �������� ���� ���Ͽ�
	
	 //����ȭ�� ������
	 private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
				.getImage();//��������
	 private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
				.getImage();//��Ʈ��ζ���	
	 private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
				.getImage();//��������
	 private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
	 private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ���
		
	private String titleName; //������
	private String difficulty; //���̵�
	private String musicTitle; //��������
	private Music gameMusic; // ��������
	
	ArrayList<Note> noteList = new ArrayList<Note>(); //��Ʈ�� ���� �迭
	
	public Game(String titleName, String difficulty, String musicTitle) { //���ӻ����� �����
		this.titleName = titleName; //���� �޾ƿ���
		this.difficulty = difficulty; //���̵� �޾ƿ���
		this.musicTitle = musicTitle; // ��������޾ƿ���
		gameMusic = new Music(this.musicTitle, false); //���� ��������ְ�
		gameMusic.start(); //���ǽ������
		dropNotes(titleName);//������ �޾ƿͼ� ��Ʈ�� ����߸�
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
		for(int i = 0; i< noteList.size(); i++) {//��Ʈ�迭���� ���
			Note note = noteList.get(i);
			note.screenDraw(g);
		}//tip:�޺κп� �Ѽ��� �׷��Ȼ� �տ���
		g.setColor(Color.white); //������
		//��Ʈ�� ȭ���� ������ ������ ��Ƽ���Ϸ��� �߰�
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Ariel", Font.BOLD, 45)); //��Ʈ����
		g.drawString(titleName, 30, 1053); //������������
		g.drawString(difficulty, 1670, 1053); //���̵�����
		g.setColor(Color.DARK_GRAY); //������
		g.setFont(new Font("Ariel", Font.PLAIN, 39)); //��Ʈ����
		g.drawString("A", 420, 913); //��������
		g.drawString("S", 576, 913); //��������
		g.drawString("D", 732, 913); //��������
		g.drawString("Space Bar", 883, 913); //��������
		g.drawString("J", 1199, 913); //��������
		g.drawString("K", 1355, 913); //��������
		g.drawString("L", 1511, 913); //��������
		g.setColor(Color.LIGHT_GRAY); //������
		g.setFont(new Font("Elephant", Font.BOLD, 45)); //��Ʈ����
		g.drawString("000000", 880, 1053); //��������
		
	}
	
	public void pressA() { //A�� ��������
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseA() { //A�� ������
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressS() { //S�� ��������
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseS() { //S�� ������
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressD() { //D�� ��������
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseD() { //D�� ������
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressSpace() { //Space�� ��������
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseSpace() { //S�� ������
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressJ() { //J�� ��������
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseJ() { //J�� ������
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressK() { //K�� ��������
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseK() { //K�� ������
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressL() { //L�� ��������
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseL() { //L�� ������
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	
	@Override
	public void run() { //Thread�� �̷������� ���ڸ� �Ѱ�����Ѵ�. run�� ä��� start�� ������ //musicŬ����ó��
		
	}
	
	public void close() { //������ �ݾ�����
		gameMusic.close(); //���ӼҸ�����
		this.interrupt(); //������ ����
	}

	public void dropNotes(String titleName) { //�������� ��Ʈ
		Note note = new Note(360, "short");
		note.start();
		noteList.add(note);
		/*noteList.add(new Note(360, 30, "short")); //��Ʈ�� �迭�� �߰�
		noteList.add(new Note(516, 500, "short"));
		noteList.add(new Note(672, 90, "short"));
		noteList.add(new Note(828, 710, "long"));
		noteList.add(new Note(1134, 420, "short"));
		noteList.add(new Note(1290, 620, "short"));
		noteList.add(new Note(1446, 820, "short"));	*/
	}
}
