package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import core.BackThread;
import core.Game;
import core.Player;
import core.Settings;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel {
	private JPanel playerStatPanel;
	private JPanel mainPanel;
	private JPanel lowerInfoPanel;
	private JLabel playerMoneyLabel;
	private JLabel playerUnitCapLabel;
	private JLabel fractionOwningLabel;
	private JLabel option;
	private JLabel chatLabel;
	private JLabel clanLabel;
	private JLabel logLabel;
	private JLabel playerLabel;
	
	private FieldStatPanel fieldStatPanel;
	private BuyUnitPanel buyUnitPanel;
	private BattelStatPanel battelStatPanel;
	private MapPanel mapPanel;
	private BattelPreparePanel battelPreparePanel;
	private AfterBattelStatPanel afterBattelStatPanel;
	
	private Game game;
	
	private Player activePlayer;
	
	private BackThread backThread;
	
	public MainPanel() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		game = new Game();
		
		this.backThread = new BackThread(this);
		
		activePlayer = game.getPlayers().get(0);
		
		activePlayer.setBot(false);
		activePlayer.setMoney(200);
		
		setPreferredSize(new Dimension(213 , 384));
		
		setOpaque(true);
		setBackground(Color.blue);
		setLayout(new BorderLayout(0, 0));
		
		fieldStatPanel = new FieldStatPanel(this);
		buyUnitPanel = new BuyUnitPanel(this);
		battelStatPanel = new BattelStatPanel(this);
		battelPreparePanel = new BattelPreparePanel(this);
		afterBattelStatPanel = new AfterBattelStatPanel(this);
		mapPanel = new MapPanel(this ,game);
		
		playerStatPanel = new JPanel();
		add(playerStatPanel, BorderLayout.NORTH);
		playerStatPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		playerMoneyLabel = new JLabel("100$");
		refreshingPlayerMoneyLabel();
		playerMoneyLabel.setFont(Settings.MID_FONT);
		playerStatPanel.add(playerMoneyLabel);
		
		playerUnitCapLabel = new JLabel("21/300");
		refreshingPlayerUnitCapLabel();
		playerUnitCapLabel.setFont(Settings.MID_FONT);
		playerUnitCapLabel.setIcon(Settings.PERSON);
		playerUnitCapLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		playerStatPanel.add(playerUnitCapLabel);
		playerUnitCapLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToBuyUnitPanel();	
			}
		});
		
		fractionOwningLabel = new JLabel("");
		refreshingFractionOwningLabel();
		fractionOwningLabel.setIcon(Settings.HAUS);
		fractionOwningLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		fractionOwningLabel.setFont(Settings.MID_FONT);
		playerStatPanel.add(fractionOwningLabel);
		/*
		option = new JLabel("");
		option.setIcon(Settings.OPTION);
		option.setFont(Settings.SMALL_FONT);
		playerStatPanel.add(option);
		*/
		
		mainPanel = mapPanel;
		add(mainPanel, BorderLayout.CENTER);
		//add(fieldStatPanel, BorderLayout.CENTER);
		//add(buyUnitPanel, BorderLayout.CENTER);
		//add(battelPreparePanel, BorderLayout.CENTER);
		//add(mapPanel, BorderLayout.CENTER);
		//add(battelStatPanel, BorderLayout.CENTER);
		
		lowerInfoPanel = new JPanel();
		add(lowerInfoPanel, BorderLayout.SOUTH);
		lowerInfoPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		chatLabel = new JLabel("");
		chatLabel.setIcon(Settings.CHAT);
		lowerInfoPanel.add(chatLabel);
		
		clanLabel = new JLabel("");
		clanLabel.setIcon(Settings.CLAN);
		lowerInfoPanel.add(clanLabel);
		
		logLabel = new JLabel("");
		logLabel.setIcon(Settings.LOG);
		logLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeToAfterBattelStatPanel();
			}
		});
		lowerInfoPanel.add(logLabel);
		
		playerLabel = new JLabel("");//TODO Player
		playerLabel.setIcon(Settings.OPTION);
		lowerInfoPanel.add(playerLabel);
		
		backThread.start();
	}
	
	public void pressedOnField(){
		if(game.getMap().getField(activePlayer.getX(), activePlayer.getY()).getOwnerFraction() == null){
			game.getMap().getField(activePlayer.getX(), activePlayer.getY()).setOwnerFraction(activePlayer.getFraction());
		}
		
		if(game.getMap().getField(activePlayer.getX(), activePlayer.getY()).getOwnerFraction().getNumber() == 
				activePlayer.getFraction().getNumber()){
			if(game.getMap().getField(activePlayer.getX(), activePlayer.getY()).isAttacked()){
				changeToBattelStatPanel();
			}else{
				changeToFieldStatPanel();
			}
		}else{
			if(game.getMap().getField(activePlayer.getX(), activePlayer.getY()).isAttacked()){
				changeToBattelStatPanel();
			}else{
				changeToFieldStatPanel();
			}
		}
	}
	
	public void changeToBattelPreparePanel(){
		//System.out.println("changeToBattelPreparePanel");
		remove(mainPanel);
		mainPanel = battelPreparePanel;
		
		battelPreparePanel.refresh();
		
		add(mainPanel,BorderLayout.CENTER);
		refresh();
		updateUI();
		
		//System.out.println(activePlayer.getUnits().getArcher().size()+" "+activePlayer.getUnits().getLancer().size()+" "+activePlayer.getUnits().getHorseman().size()+" "+activePlayer.getUnits().getUnitAmount());
		
	}
	
	public void changeToFieldStatPanel(){
		//System.out.println("changeToFieldStatPanel");
		remove(mainPanel);
		mainPanel = fieldStatPanel;
		
		fieldStatPanel.changeActiveField(game.getMap().getField(activePlayer.getX(), activePlayer.getY()));
		
		add(mainPanel,BorderLayout.CENTER);
		refresh();
		updateUI();
	}
	
	public void changeToBuyUnitPanel(){
		//System.out.println("changeToBuyUnitPanel");
		remove(mainPanel);
		mainPanel = buyUnitPanel;
		add(mainPanel,BorderLayout.CENTER);
		refresh();
		updateUI();
	}
	
	public void changeToBattelStatPanel(){
		//System.out.println("changeToBattelStatPanel");
		remove(mainPanel);
		mainPanel = battelStatPanel;
		battelStatPanel.refreshLables();
		add(mainPanel,BorderLayout.CENTER);
		refresh();
		updateUI();
		
		
	}
	
	public void changeToMapPanel(){
		//System.out.println("changeToMapPanel");
		remove(mainPanel);
		mainPanel = mapPanel;
		add(mainPanel,BorderLayout.CENTER);
		refresh();
		updateUI();
		
	}
	
	private void changeToAfterBattelStatPanel(){
		//System.out.println("changeToAfterBattelStatPanel");
		remove(mainPanel);
		mainPanel = afterBattelStatPanel;
		add(mainPanel,BorderLayout.CENTER);
		refresh();
		updateUI();
	}
	
	private void refresh(){
		refreshingFractionOwningLabel();
		refreshingPlayerMoneyLabel();
		refreshingPlayerUnitCapLabel();
	}
	
	private void refreshingFractionOwningLabel(){
		fractionOwningLabel.setText(((int)((float)(activePlayer.getFraction().getOwning())/((float)(Settings.MAP_SIZE*Settings.MAP_SIZE))*100))+" %");
	}
	
	private void refreshingPlayerMoneyLabel(){
		playerMoneyLabel.setText(activePlayer.getMoney()+" $");
	}
	
	private void refreshingPlayerUnitCapLabel(){
		playerUnitCapLabel.setText(activePlayer.getUnits().getUnitAmount()+"/"+Settings.UNIT_CAP_PLAYER);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refreshingFractionOwningLabel();
		refreshingPlayerMoneyLabel();
		refreshingPlayerUnitCapLabel();

	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the activePlayer
	 */
	public Player getActivePlayer() {
		return activePlayer;
	}

	/**
	 * @param activePlayer the activePlayer to set
	 */
	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public static void main(String[] args) {
		
		MainPanel p = new MainPanel();
		
		JFrame f = new JFrame("test");
		
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		
		f.setContentPane(p);
		
		f.pack();
		
		f.setResizable(false);
		
		f.setVisible(true);	
	}
}
