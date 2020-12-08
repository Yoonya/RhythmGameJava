package dynamic_beat_11;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{ //키보드 입력 처리
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game == null) { //Dynamic클래스의 game이 실행되고 있지 않다면
			return; // 아래 코드들을 하지 않고 종료, 아마 없으면 게임 시작도안했는데 타이틀같은 곳에서 키보드 리슨리슨할 것
		}
		if(e.getKeyCode() == KeyEvent.VK_A){ //A키를 눌렀을 때 처리
			DynamicBeat.game.pressA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){ //S키를 눌렀을 때 처리
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){ //D키를 눌렀을 때 처리
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){ //SpaceBar키를 눌렀을 때 처리
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J){ //J키를 눌렀을 때 처리
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K){ //K키를 눌렀을 때 처리
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L){ //L키를 눌렀을 때 처리
			DynamicBeat.game.pressL();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { //키보드 입력 후 땠을 때 처리
		if(DynamicBeat.game == null) { //Dynamic클래스의 game이 실행되고 있지 않다면
			return; // 아래 코드들을 하지 않고 종료
		}
        if(e.getKeyCode() == KeyEvent.VK_A){ //A키를 눌렀을 때 처리
        	DynamicBeat.game.releaseA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){ //S키를 눌렀을 때 처리
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){ //D키를 눌렀을 때 처리
			DynamicBeat.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){ //SpaceBar키를 눌렀을 때 처리
			DynamicBeat.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J){ //J키를 눌렀을 때 처리
			DynamicBeat.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K){ //K키를 눌렀을 때 처리
			DynamicBeat.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L){ //L키를 눌렀을 때 처리
			DynamicBeat.game.releaseL();
		}
		
	}
}
