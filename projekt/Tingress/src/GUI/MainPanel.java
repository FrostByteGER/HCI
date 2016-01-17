package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

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
	
	
	public MainPanel() {
		setPreferredSize(new Dimension(213 , 384));
		
		setOpaque(true);
		setBackground(Color.blue);
		setLayout(new BorderLayout(0, 0));
		
		fieldStatPanel = new FieldStatPanel(this);
		buyUnitPanel = new BuyUnitPanel(this);
		battelStatPanel = new BattelStatPanel(this);
		battelPreparePanel = new BattelPreparePanel(this);
		mapPanel = new MapPanel(this);
		
		playerStatPanel = new JPanel();
		add(playerStatPanel, BorderLayout.NORTH);
		playerStatPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		playerMoneyLabel = new JLabel("100$");
		playerStatPanel.add(playerMoneyLabel);
		
		playerUnitCapLabel = new JLabel("21/300");
		playerStatPanel.add(playerUnitCapLabel);
		
		fractionOwningLabel = new JLabel("11%");
		playerStatPanel.add(fractionOwningLabel);
		
		option = new JLabel("Option");
		playerStatPanel.add(option);

		
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
		
		chatLabel = new JLabel("Chat");
		lowerInfoPanel.add(chatLabel);
		
		clanLabel = new JLabel("Clan");
		lowerInfoPanel.add(clanLabel);
		
		logLabel = new JLabel("log");
		lowerInfoPanel.add(logLabel);
		
		playerLabel = new JLabel("Player?");
		lowerInfoPanel.add(playerLabel);
	}
	
	public void changeToBattelPreparePanel(){
		remove(mapPanel);
		mainPanel = battelPreparePanel;
		add(battelPreparePanel , BorderLayout.CENTER);
		updateUI();
		
		System.out.println("changeToBattelPreparePanel");
	}
	
	public void changeToFieldStatPanel(){
		mainPanel = fieldStatPanel;
	}
	
	public void changeToBuyUnitPanel(){
		mainPanel = buyUnitPanel;
	}
	
	public void changeToBattelStatPanel(){
		mainPanel = battelStatPanel;
	}
	
	public void changeToMapPanel(){
		mainPanel = mapPanel;
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
