package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
//PLAYER MOVEMENT	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			//key for player
			if(tempObj.getId() == ID.Player) {
				if(key == KeyEvent.VK_UP) { tempObj.setVelY(-5); keyDown[0] = true; }
				if(key == KeyEvent.VK_DOWN) { tempObj.setVelY(+5); keyDown[1] = true; }
				if(key == KeyEvent.VK_LEFT) { tempObj.setVelX(-5); keyDown[2] = true; }
				if(key == KeyEvent.VK_RIGHT) { tempObj.setVelX(+5); keyDown[3] = true; }
				//if(key == KeyEvent.VK_SPACE) handler.addObject(new Bullet(tempObj.getX()+7,tempObj.getY()-15, ID.Bullet, handler));
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObj = handler.object.get(i);
			//key for player
			if(tempObj.getId() == ID.Player) {
				if(key == KeyEvent.VK_UP) keyDown[0] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) keyDown[1] = false;// tempObj.setVelY(0);
				if(key == KeyEvent.VK_LEFT) keyDown[2] = false; //tempObj.setVelX(0);
				if(key == KeyEvent.VK_RIGHT) keyDown[3] = false;// tempObj.setVelX(0);
				
			//vertical movement
			if(!keyDown[0] && !keyDown[1]) tempObj.setVelY(0);
			//horizontal movement
			if(!keyDown[2] && !keyDown[3]) tempObj.setVelX(0);

			}
		}
	}
}
