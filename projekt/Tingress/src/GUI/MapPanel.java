package GUI;

import javax.swing.JPanel;

import core.Game;
import core.Map;
import core.Player;
import core.Settings;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MapPanel extends JPanel{
	//private JButton field;
	
	private MainPanel mainPanel;
	
	private Map map;
	private Player player;
	
	private int zoom = Settings.MIN_ZOOM;
	private int xoffset = 0;
	private int yoffset = 0;
	
	public MapPanel(MainPanel mainPanel ,Game game) {
		
		this.mainPanel = mainPanel;
		this.player = game.getPlayers().get(0);
		this.map = game.getMap();
		
		setLayout(new BorderLayout(0, 0));
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getButton() == 1){
					if(e.getX() >= getSize().getWidth()/2+(zoom/2)){
						player.setX(player.getX()+1);
					}else if(e.getX() <= getSize().getWidth()/2-(zoom/2)){
						player.setX(player.getX()-1);
					}
					
					if(e.getY() >= getSize().getHeight()/2+(zoom/2)){
						player.setY(player.getY()+1);
					}else if(e.getY() <= getSize().getHeight()/2-(zoom/2)){
						player.setY(player.getY()-1);
					}
					
				}
				
				if(e.getButton() == 3){
					
					if(e.getX() <= getSize().getWidth()/2 + zoom/2 && e.getX() >= getSize().getWidth()/2 - zoom/2 &&
							e.getY() <= getSize().getHeight()/2 + zoom/2 && e.getY() >= getSize().getHeight()/2 - zoom/2){
						
						//System.out.println("Attack Something");
						
						
						MapPanel.this.mainPanel.pressedOnField();
						
						
						
						
					}
				}
				repaint();
				
			}
		});
		
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				//System.out.println(arg0.getWheelRotation());
				if(arg0.getWheelRotation() < 0){
					if(zoom >= Settings.MIN_ZOOM){
						zoom--;
					}
				}else if(arg0.getWheelRotation() > 0){
					if(zoom <= Settings.MAX_ZOOM){
						zoom++;
					}
				}
				repaint();
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		xoffset = (int) ((double)(getSize().getWidth())/2D);
		yoffset = (int) ((double)(getSize().getHeight())/2D);
		
		
		// Draw Map
		
		for(int i = 0 ; i < Settings.MAP_SIZE ; i++){
			for (int j = 0 ; j < Settings.MAP_SIZE ; j++){
				
				if(map.getField(i, j).getOwnerFraction() != null) {
					if(map.getField(i, j).getOwnerFraction().getNumber() == 0){
						g.setColor(Settings.LIGHT_BLUE);
					}else if(map.getField(i, j).getOwnerFraction().getNumber() == 1){
						g.setColor(Settings.LIGHT_RED);
					}else{
						g.setColor(Color.gray);
					}
				}else{
					g.setColor(Color.gray);
				}
				
				g.fillRect((i*zoom) - (player.getX()*zoom) + xoffset - (zoom/2), 
						(j*zoom) - (player.getY()*zoom) + yoffset - (zoom/2), 
						zoom, 
						zoom);
				
				
				g.setColor(Color.black);
				g.drawRect((i*zoom) - (player.getX()*zoom) + xoffset - zoom/2, 
						(j*zoom) - (player.getY()*zoom) + yoffset - zoom/2, 
						zoom, 
						zoom);
				/*
				g.fillRect((i*zoom) - (player.getX()*zoom) + xoffset, 
						(j*zoom) - (player.getY()*zoom) + yoffset , 
						zoom/2, 
						zoom/2);
				*/
				if(map.getField(i, j).isAttacked()){
					if(map.getField(i, j).getOwnerFraction() != null){
												
						//System.out.println(map.getField(i, j).getOwnerFraction().getNumber()+" "+player.getFraction().getNumber());
						
						g.setColor(Color.yellow);
						g.fillOval((i*zoom) - (player.getX()*zoom) + xoffset, (j*zoom) - (player.getY()*zoom) + yoffset,
								zoom/4, zoom/4);
						if(map.getField(i, j).getOwnerFraction().getNumber() == player.getFraction().getNumber()){
							g.fillOval((i*zoom) - (player.getX()*zoom) + xoffset, (j*zoom) - (player.getY()*zoom) + yoffset,
									zoom/4, zoom/4);
						}else{
							g.fillOval((i*zoom) - (player.getX()*zoom) + xoffset, (j*zoom) - (player.getY()*zoom) + yoffset,
									zoom/4, zoom/4);
						}
					}
				}		
			}
		}
		
		g.setColor(Color.green);
		
		// draw Player
		g.fillOval(-7 + xoffset, -7 +yoffset, 14, 14);
		
		g.setColor(Color.blue);
		g.fillOval(-5 + xoffset, -5 +yoffset, 10, 10);
		
	}
}
