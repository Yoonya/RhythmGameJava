package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat"); //��������
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //������ ����
		setResizable(false); //����� ���Ƿ� �� �ٲٰ��Ѵ�.
		setLocationRelativeTo(null); //�����ų ��, ȭ�� ���߾�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ �����ϸ� ���ᰡ �ǰ�(�ȳ����� ���ᰡ �ȵ�)
		setVisible(true); // ���� ���̵��� ��
	}

}
