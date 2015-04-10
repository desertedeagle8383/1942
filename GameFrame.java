import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	private Game game;
	private GamePanel panel;
	private JLabel scoreLabel, livesLabel, rollsLabel;
	private JPanel contentPane;
	
	public GameFrame(Game game){
		this.game = game;
		
		scoreLabel = new JLabel(Integer.toString(game.getScore()));
		livesLabel = new JLabel(Integer.toString(game.getLives()));
		rollsLabel = new JLabel(Integer.toString(game.getRolls()));
		
		game.getGrid().createPlayer();
		
		panel = new GamePanel(game.getGrid());
		panel.addKeyListener(new GameKeyListener());
		panel.setFocusable(true);
		
		contentPane = new JPanel();
		
	}
	public void initializeGUI(){
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		add(panel);
		
		contentPane.setSize(new Dimension(1000, 50));
		contentPane.add(scoreLabel);
		contentPane.add(livesLabel);
		
		panel.setSize(new Dimension(1000, 950));
		
		setVisible(true);
		
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
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				game.getGrid().getPlayer().setXVelocity(0);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				game.getGrid().getPlayer().setXVelocity(0);
			} else if (e.getKeyCode() == KeyEvent.VK_UP){
				game.getGrid().getPlayer().setYVelocity(0);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				game.getGrid().getPlayer().setYVelocity(0);
			}
		}
		public void keyTyped(KeyEvent arg0) {}
	}
	public static void main(String args[]){
		Grid grid = new Grid(1000, 950);
		Game game = new Game(grid);
		GameFrame frame = new GameFrame(game);
		frame.initializeGUI();
	}
}
