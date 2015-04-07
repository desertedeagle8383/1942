import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private Grid grid;
	
	public GamePanel(Grid grid){
		this.grid = grid;
	}
	
	public void updatePanel(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i = 0; i < grid.getEnemies().size(); i++)
			g2.drawImage(grid.getEnemies().get(i).getImage(), 
			grid.getEnemies().get(i).getCoordinate().getX(), 
			grid.getEnemies().get(i).getCoordinate().getY(), 
			null); 
		
		for(int i = 0; i < grid.getProjectiles().size(); i++)
			g2.drawImage(grid.getProjectiles().get(i).getImage(), 
			grid.getProjectiles().get(i).getCoordinate().getX(), 
			grid.getProjectiles().get(i).getCoordinate().getY(), 
			null); 
		
		g2.drawImage(grid.getPlayer().getImage(), 
		grid.getPlayer().getCoordinate().getX(), 
		grid.getPlayer().getCoordinate().getY(), 
		null);
	}
}
