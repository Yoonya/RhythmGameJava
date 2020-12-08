package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat"); //게임제목
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //사이즈 선언
		setResizable(false); //사이즈를 임의로 못 바꾸게한다.
		setLocationRelativeTo(null); //실행시킬 때, 화면 정중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임을 종료하면 종료가 되게(안넣으면 종료가 안됨)
		setVisible(true); // 눈에 보이도록 함
	}

}
