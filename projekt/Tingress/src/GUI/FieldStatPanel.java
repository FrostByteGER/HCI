package GUI;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.GameField;
import core.Settings;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class FieldStatPanel extends JPanel {
	private JPanel titlePanel;
	private JPanel infoAttackPanel;
	private JPanel unitTypAmountPanel;
	private JPanel archerPanel;
	private JPanel lancerPanel;
	private JPanel horsemanPanel;
	private JPanel itemPanel;
	private JButton backButton;
	private JLabel statisticLabel;
	private JLabel typeLabel;
	private JLabel amountLabel;
	private JLabel archerNameLabel;
	private JLabel archerAmountLabel;
	private JLabel lancerNameLabel;
	private JLabel lancerAmountLabel;
	private JLabel horsemanLabel;
	private JLabel horsemanAmountLabel;
	private JButton itemButton1;
	private JButton itemButton2;
	private JButton itemButton3;
	private JPanel infoPanel;
	private JButton actionButton;
	private JLabel nameLabel;
	private JLabel cashLabel;
	private JLabel fieldNameLabel;
	private JLabel fieldCashLabel;
	
	private MainPanel mainPanel;
	
	private GameField activField;
	
	public FieldStatPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		this.activField = this.mainPanel.getGame().getMap().getField(0, 0);
		
		setLayout(new GridLayout(7, 0, 0, 0));
		
		titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FieldStatPanel.this.mainPanel.changeToMapPanel();
			}
		});
		titlePanel.add(backButton, BorderLayout.WEST);
		
		statisticLabel = new JLabel("Statistic");
		statisticLabel.setFont(Settings.MID_FONT);
		statisticLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statisticLabel.setVerticalAlignment(SwingConstants.CENTER);
		titlePanel.add(statisticLabel, BorderLayout.CENTER);
		
		infoAttackPanel = new JPanel();
		add(infoAttackPanel);
		infoAttackPanel.setLayout(new BorderLayout(0, 0));
		
		infoPanel = new JPanel();
		infoAttackPanel.add(infoPanel, BorderLayout.CENTER);
		infoPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		nameLabel = new JLabel("Name");
		infoPanel.add(nameLabel);
		
		fieldNameLabel = new JLabel("Rewe");
		infoPanel.add(fieldNameLabel);
		
		cashLabel = new JLabel("Cash");
		infoPanel.add(cashLabel);
		
		fieldCashLabel = new JLabel("100$");
		infoPanel.add(fieldCashLabel);
		
		actionButton = new JButton("");
		actionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				mainPanel.changeToBattelPreparePanel();
				
			}
		});
		
		infoAttackPanel.add(actionButton, BorderLayout.EAST);
		
		unitTypAmountPanel = new JPanel();
		add(unitTypAmountPanel);
		unitTypAmountPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		typeLabel = new JLabel("Typ");
		unitTypAmountPanel.add(typeLabel);
		
		amountLabel = new JLabel("Amount");
		unitTypAmountPanel.add(amountLabel);
		
		archerPanel = new JPanel();
		add(archerPanel);
		archerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		archerNameLabel = new JLabel("");
		archerNameLabel.setIcon(Settings.ARCHER);
		archerPanel.add(archerNameLabel);
		
		archerAmountLabel = new JLabel("0");
		archerPanel.add(archerAmountLabel);
		
		lancerPanel = new JPanel();
		add(lancerPanel);
		lancerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lancerNameLabel = new JLabel("");
		lancerNameLabel.setIcon(Settings.LANCER);
		lancerPanel.add(lancerNameLabel);
		
		lancerAmountLabel = new JLabel("0");
		lancerPanel.add(lancerAmountLabel);
		
		horsemanPanel = new JPanel();
		add(horsemanPanel);
		horsemanPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		horsemanLabel = new JLabel("");
		horsemanLabel.setIcon(Settings.HORSEMAN);
		horsemanPanel.add(horsemanLabel);
		
		horsemanAmountLabel = new JLabel("0");
		horsemanPanel.add(horsemanAmountLabel);
		
		itemPanel = new JPanel();
		add(itemPanel);
		itemPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		itemButton1 = new JButton("");
		itemButton1.setIcon(Settings.ITEM);
		itemPanel.add(itemButton1);
		
		itemButton2 = new JButton("");
		itemButton2.setIcon(Settings.ITEM);
		itemPanel.add(itemButton2);
		
		itemButton3 = new JButton("");
		itemButton3.setIcon(Settings.ITEM);
		itemPanel.add(itemButton3);
		
		
	}
	
	public void changeActiveField(GameField field){
		activField = field;
		
		if(activField.getOwnerFraction().getNumber() == mainPanel.getActivePlayer().getFraction().getNumber()){
			actionButton.setText("Reinforce");
			
			if(activField.getDefGroups().containsKey(mainPanel.getActivePlayer().getId())){
				//System.out.println("hasUnits");			
			}else{
				//System.out.println("noUnits");
			}
			
			if(activField.isAttacked()){
				mainPanel.changeToBattelStatPanel();
			}
			
		}else{
			actionButton.setText("Attack");
			
			if(activField.getAtkGroups().containsKey(mainPanel.getActivePlayer().getId())){
				//System.out.println("hasUnits");			
			}else{
				//System.out.println("noUnits");
			}
			
			if(activField.isAttacked()){
				mainPanel.changeToBattelStatPanel();
			}
			
			//mainPanel.changeToBattelPreparePanel();
			
		}
		
		archerAmountLabel.setText(activField.getArcherDefAmount()+"");
		lancerAmountLabel.setText(activField.getLancerDefAmount()+"");
		horsemanAmountLabel.setText(activField.getHorsemanDefAmount()+"");
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
	}

}
