import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame{
	private Game game;
	private GamePanel panel;
	private JLabel scoreLabel, livesLabel, rollsLabel;

	public GameFrame(Game game){
		this.game = game;
		scoreLabel = new JLabel(Integer.toString(game.getScore()));
		livesLabel = new JLabel(Integer.toString(game.getLives()));
		rollsLabel = new JLabel(Integer.toString(game.getRolls()));

		panel = new GamePanel(game.getGrid());
		panel.addKeyListener(new GameKeyListener());
		panel.setFocusable(true);
	}

	public void initializeGUI(){

	}

	public void updateLabels(){
		scoreLabel.setText(Integer.toString(game.getScore()));
		livesLabel.setText(Integer.toString(game.getLives()));
		rollsLabel.setText(Integer.toString(game.getRolls()));

	}
	private class GameKeyListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				game.getGrid().getPlayer().setXVelocity(-1);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				game.getGrid().getPlayer().setXVelocity(-1);
			} else if (e.getKeyCode() == KeyEvent.VK_UP){
				game.getGrid().getPlayer().setYVelocity(1);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				game.getGrid().getPlayer().setYVelocity(-1);
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE){
				game.shoot();
			}
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	}
}
