package dynamic_beat_8;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{ //������� ���α׷� �ȿ� ���� ���α׷��� ���� �� �ְ� �Ѵ�.

	private Player player;
	private boolean isLoop; //���� �ݺ��Ǵ��� �ѹ��ϰ� ��������
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() { //����Ǵ� ������ ��� ��ġ���� ����Ǵ��� 0.001�� ������ ��ȯ
		if(player == null)
			return 0;
		return player.getPosition();
	}
	public void close() { // ������ ���� ����ǰ� ���� �׻� ���ᰡ���ϰ�, ex)�����ϴٰ� �� �ٲٷ����Ҷ� �������̰�����
		isLoop = false;
		player.close();
		this.interrupt();//������ �ȿ��ִ� ������ ����Ǵ°� ���߰� �Ѵ�.
	}
	@Override
	public void run() { //�������̵�, ������ �ȿ� ������ ������ ������Ѵ�
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop); //true�϶� ���� �ݺ��ϵ���
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
