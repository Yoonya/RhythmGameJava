package dynamic_beat_11;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{ //Ű���� �Է� ó��
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game == null) { //DynamicŬ������ game�� ����ǰ� ���� �ʴٸ�
			return; // �Ʒ� �ڵ���� ���� �ʰ� ����, �Ƹ� ������ ���� ���۵����ߴµ� Ÿ��Ʋ���� ������ Ű���� ���������� ��
		}
		if(e.getKeyCode() == KeyEvent.VK_A){ //AŰ�� ������ �� ó��
			DynamicBeat.game.pressA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){ //SŰ�� ������ �� ó��
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){ //DŰ�� ������ �� ó��
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){ //SpaceBarŰ�� ������ �� ó��
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J){ //JŰ�� ������ �� ó��
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K){ //KŰ�� ������ �� ó��
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L){ //LŰ�� ������ �� ó��
			DynamicBeat.game.pressL();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { //Ű���� �Է� �� ���� �� ó��
		if(DynamicBeat.game == null) { //DynamicŬ������ game�� ����ǰ� ���� �ʴٸ�
			return; // �Ʒ� �ڵ���� ���� �ʰ� ����
		}
        if(e.getKeyCode() == KeyEvent.VK_A){ //AŰ�� ������ �� ó��
        	DynamicBeat.game.releaseA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){ //SŰ�� ������ �� ó��
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){ //DŰ�� ������ �� ó��
			DynamicBeat.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){ //SpaceBarŰ�� ������ �� ó��
			DynamicBeat.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J){ //JŰ�� ������ �� ó��
			DynamicBeat.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K){ //KŰ�� ������ �� ó��
			DynamicBeat.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L){ //LŰ�� ������ �� ó��
			DynamicBeat.game.releaseL();
		}
		
	}
}
