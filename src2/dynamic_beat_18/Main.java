package dynamic_beat_18;



public class Main {

	public static final int SCREEN_WIDTH = 1920; // 해상도 설정
	public static final int SCREEN_HEIGHT = 1080;
	public static final int NOTE_SPEED = 10; // 노트의 속도
	public static final int SLEEP_TIME = 10; // 노트가 어느정도 주기로 떨어지는지
	public static final int REACTH_TIME = 1; // 노트가 판정노트에 도달하는 시간 초단위
	public static void main(String[] args) {
		
		new DynamicBeat(); //GUI객체생성

	}

}
