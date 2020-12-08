package dynamic_beat_8;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{ //쓰레드는 프로그램 안에 작은 프로그램을 만들 수 있게 한다.

	private Player player;
	private boolean isLoop; //곡이 반복되는지 한번하고 꺼지는지
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
	
	public int getTime() { //실행되는 음악이 어느 위치에서 실행되는지 0.001초 단위로 반환
		if(player == null)
			return 0;
		return player.getPosition();
	}
	public void close() { // 음악이 언제 실행되건 간에 항상 종료가능하게, ex)게임하다가 곡 바꾸려고할때 안정적이게종료
		isLoop = false;
		player.close();
		this.interrupt();//쓰레드 안에있는 것으로 실행되는걸 멈추게 한다.
	}
	@Override
	public void run() { //오버라이드, 쓰레드 안에 있으면 무조건 해줘야한다
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop); //true일때 무한 반복하도록
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
