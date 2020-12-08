package dynamic_beat_15;

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
		for(int i = 0; i< noteList.size(); i++) {//��Ʈ�迭���� ���
			Note note = noteList.get(i);
			if(!note.isProceeded()) { //��Ʈ�迭�� ����ǰ� �����ʴٸ�
				noteList.remove(i); //�����
				i--;
			}
			else {
				note.screenDraw(g);
			}
		
		}
		g.drawImage(gameInfoImage, 0, 990, null);//tip:�޺κп� �Ѽ��� �׷��Ȼ� �տ���
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
		judge("A");//����
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseA() { //A�� ������
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressS() { //S�� ��������
		judge("S");//����
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseS() { //S�� ������
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressD() { //D�� ��������
		judge("D");//����
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseD() { //D�� ������
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressSpace() { //Space�� ��������
		judge("Space");//����
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseSpace() { //Space�� ������
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressJ() { //J�� ��������
		judge("J");//����
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseJ() { //J�� ������
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressK() { //K�� ��������
		judge("K");//����
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseK() { //K�� ������
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	public void pressL() { //L�� ��������
		judge("L");//����
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();//��Ʈ��Ʈ�� ���������� ����� �ٲ���Ѵ�.
		new Music("Beat.mp3", false).start();
	}
	public void releaseL() { //L�� ������
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();//��Ʈ��Ʈ�� ���� ����� �ٲ���Ѵ�.
	}
	
	@Override
	public void run() { //Thread�� run�� �ƹ��͵� ���̶�� ���ڸ� �Ѱ�����Ѵ�. run�� ä��� start�� ������ 
		dropNotes(this.titleName);
	}
	
	public void close() { //������ �ݾ�����
		gameMusic.close(); //���ӼҸ�����
		this.interrupt(); //������ ����
	}

	public void dropNotes(String titleName) { //�������� ��Ʈ
		Beat[] beats = null; // ��Ʈ �߰�
		if(titleName.equals("Soulworker Main Theme Arrange ver.") && difficulty.equals("Easy")) { //����� ��Ʈ�� �ٸ���
			//int startTime = 1000 - Main.REACTH_TIME*1000; //�뷡 ���ۺκ��� �ٸ��⶧���� ���� ����
			int gap2 = 600;
			int gap3 = 1950;
			int gap = 1950; //���� 
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
			int startTime = 2000 - Main.REACTH_TIME*1000; //�� ���� �������ν� �׻� �����ٿ� �����ϰ� �Ѵ�.
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("������ �н��� OST - �ұݺ���") && difficulty.equals("Easy")) {
			int startTime = 2000 - Main.REACTH_TIME*1000; //�� ���� �������ν� �׻� �����ٿ� �����ϰ� �Ѵ�.
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("������ �н��� OST - �ұݺ���") && difficulty.equals("Hard")) {
			int startTime = 2000 - Main.REACTH_TIME*1000; //�� ���� �������ν� �׻� �����ٿ� �����ϰ� �Ѵ�.
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		if(titleName.equals("�汸���� �ξ�ư��� OST - Fall In") && difficulty.equals("Easy")) {
			int startTime = 2000 - Main.REACTH_TIME*1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}	
		if(titleName.equals("�汸���� �ξ�ư��� OST - Fall In") && difficulty.equals("Hard")) {
			int startTime = 2000 - Main.REACTH_TIME*1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start(); //���ǽ������, ���� �� ����� �����ڿ� �־����� ��Ʈ�� ���� �δ°� ���� �ո����̱� ������ �Ű��.
		while(i<beats.length && !isInterrupted()) { //Thread�� ���ͷ�Ʈ �޼ҵ�
			boolean dropped = false; //���ͷ�Ʈ �߻��� ����
			if(beats[i].getTime() <= gameMusic.getTime()) { //���� �뷡�� ������ �ʾҴµ� ��Ʈ�� ��ӵǸ�
				Note note = new Note(beats[i].getNoteName()); //��Ʈ�� �߰����Ѽ�
				note.start(); //������
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) { //���ͷ�Ʈ �߻��� 
				try {
					Thread.sleep(5); //0.05�� �����Ѵ�.
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) {
		for(int i = 0 ; i< noteList.size(); i++) {
			Note note = noteList.get(i); //���� �տ� �ִ� ��Ʈ, �� ���� �Ʒ� �ִ� ��Ʈ�� �޾��� ��
			if(input.equals(note.getNoteType())) { //�װ��� ��ƮŸ�԰� �� A S D .. ���ؼ� �´���
				note.judge(); //�װ� judge�Լ��� �Ǵ�
				break; // �ݺ��� ��
			}
		}		
	}	
}





