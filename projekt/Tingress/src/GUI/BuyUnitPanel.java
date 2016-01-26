package GUI;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.Archer;
import core.Settings;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BuyUnitPanel extends JPanel{
	private JPanel titlePanel;
	private JPanel infoPanel;
	private JPanel archerPanel;
	private JPanel lancerPanel;
	private JPanel HorsemanPanel;
	private JPanel totalPanel;
	private JButton backButton;
	private JLabel titleBuyLabel;
	private JLabel maxLable;
	private JLabel maxAmountLable;
	private JLabel costLable;
	private JLabel archerLable;
	private JButton archerDecreaseButton;
	private JLabel archerAmountLable;
	private JButton archerIncreaseButton;
	private JLabel archerCostLable;
	private JLabel lancerLable;
	private JButton lancerDecreaseButton;
	private JLabel lancerAmountLable;
	private JButton lancerIncreaseButton;
	private JLabel lancerCostLable;
	private JLabel horsemanLable;
	private JButton horsemanDecreaseButton;
	private JLabel horsemanAmountLable;
	private JButton horsemanIncreaseButton;
	private JLabel horsemanCostLable;
	private JLabel totalLable;
	private JLabel totalAmountLable;
	private JLabel totalCostLable;
	private JButton buyUnitsButton;
	
	private MainPanel mainPanel;
	
	private int archerAmount = 0;
	private int lancerAmount = 0;
	private int horsemanAmount = 0;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
		
	
	public BuyUnitPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(0, 1, 0, 0));
		
		titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyUnitPanel.this.mainPanel.changeToMapPanel();
			}
		});
		
		titlePanel.add(backButton, BorderLayout.WEST);
		
		titleBuyLabel = new JLabel("Buy Units");
		titlePanel.add(titleBuyLabel, BorderLayout.CENTER);
		
		infoPanel = new JPanel();
		add(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 6, 0, 0));
		
		maxLable = new JLabel("");
		infoPanel.add(maxLable);
		
		label_3 = new JLabel("");
		infoPanel.add(label_3);
		
		label_4 = new JLabel("");
		infoPanel.add(label_4);
		
		maxAmountLable = new JLabel("");
		infoPanel.add(maxAmountLable);
		
		label_5 = new JLabel("");
		infoPanel.add(label_5);
		
		costLable = new JLabel("Cost");
		infoPanel.add(costLable);
		
		archerPanel = new JPanel();
		add(archerPanel);
		archerPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		archerLable = new JLabel("");
		archerLable.setIcon(Settings.ARCHER);
		archerPanel.add(archerLable);
		
		archerDecreaseButton = new JButton("-");
		archerDecreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(archerAmount > 0){
					archerAmount--;
				}							
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		archerPanel.add(archerDecreaseButton);
		
		archerAmountLable = new JLabel("0");
		archerAmountLable.setHorizontalAlignment(SwingConstants.CENTER);
		archerPanel.add(archerAmountLable);
		
		archerIncreaseButton = new JButton("+");
		archerIncreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BuyUnitPanel.this.mainPanel.getActivePlayer().getUnits().getUnitAmount() + archerAmount +lancerAmount +horsemanAmount +1 <= Settings.UNIT_CAP_PLAYER){
					if(Settings.UNIT_COST*(archerAmount +lancerAmount +horsemanAmount + 1) <= BuyUnitPanel.this.mainPanel.getActivePlayer().getMoney()){
						archerAmount++;
					}
					
				}
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		archerPanel.add(archerIncreaseButton);
		
		archerCostLable = new JLabel(Settings.UNIT_COST+"");
		archerCostLable.setHorizontalAlignment(SwingConstants.CENTER);
		archerPanel.add(archerCostLable);
		
		lancerPanel = new JPanel();
		add(lancerPanel);
		lancerPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		lancerLable = new JLabel("");
		lancerLable.setIcon(Settings.LANCER);
		lancerPanel.add(lancerLable);
		
		lancerDecreaseButton = new JButton("-");
		lancerDecreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lancerAmount > 0){
					lancerAmount--;
				}								
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		lancerPanel.add(lancerDecreaseButton);
		
		lancerAmountLable = new JLabel("0");
		lancerAmountLable.setHorizontalAlignment(SwingConstants.CENTER);
		lancerPanel.add(lancerAmountLable);
		
		lancerIncreaseButton = new JButton("+");
		lancerIncreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BuyUnitPanel.this.mainPanel.getActivePlayer().getUnits().getUnitAmount() + archerAmount +lancerAmount +horsemanAmount +1 <= Settings.UNIT_CAP_PLAYER){
					if(Settings.UNIT_COST*(archerAmount +lancerAmount +horsemanAmount + 1) <= BuyUnitPanel.this.mainPanel.getActivePlayer().getMoney()){
						lancerAmount++;
					}
				}
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		lancerPanel.add(lancerIncreaseButton);
		
		lancerCostLable = new JLabel(Settings.UNIT_COST+"");
		lancerCostLable.setHorizontalAlignment(SwingConstants.CENTER);
		lancerPanel.add(lancerCostLable);
		
		HorsemanPanel = new JPanel();
		add(HorsemanPanel);
		HorsemanPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		horsemanLable = new JLabel("");
		horsemanLable.setIcon(Settings.HORSEMAN);
		HorsemanPanel.add(horsemanLable);
		
		horsemanDecreaseButton = new JButton("-");
		horsemanDecreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(horsemanAmount > 0){
					horsemanAmount--;
				}								
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		HorsemanPanel.add(horsemanDecreaseButton);
		
		horsemanAmountLable = new JLabel("0");
		horsemanAmountLable.setHorizontalAlignment(SwingConstants.CENTER);
		HorsemanPanel.add(horsemanAmountLable);
		
		horsemanIncreaseButton = new JButton("+");
		horsemanIncreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BuyUnitPanel.this.mainPanel.getActivePlayer().getUnits().getUnitAmount() + archerAmount +lancerAmount +horsemanAmount +1 <= Settings.UNIT_CAP_PLAYER){
					if(Settings.UNIT_COST*(archerAmount +lancerAmount +horsemanAmount + 1) <= BuyUnitPanel.this.mainPanel.getActivePlayer().getMoney()){
						horsemanAmount++;
					}					
				}
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		HorsemanPanel.add(horsemanIncreaseButton);
		
		horsemanCostLable = new JLabel(Settings.UNIT_COST+"");
		horsemanCostLable.setHorizontalAlignment(SwingConstants.CENTER);
		HorsemanPanel.add(horsemanCostLable);
		
		totalPanel = new JPanel();
		add(totalPanel);
		totalPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		totalLable = new JLabel("Total");
		totalPanel.add(totalLable);
		
		label_2 = new JLabel("");
		totalPanel.add(label_2);
		
		label = new JLabel("");
		totalPanel.add(label);
		
		totalAmountLable = new JLabel("0");
		totalPanel.add(totalAmountLable);
		
		label_1 = new JLabel("");
		totalPanel.add(label_1);
		
		totalCostLable = new JLabel("0$");
		totalPanel.add(totalCostLable);
		
		buyUnitsButton = new JButton("Buy Units");
		buyUnitsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyUnitPanel.this.mainPanel.getActivePlayer().getUnits().addArcher(archerAmount);
				BuyUnitPanel.this.mainPanel.getActivePlayer().getUnits().addLancer(lancerAmount);
				BuyUnitPanel.this.mainPanel.getActivePlayer().getUnits().addHorseman(horsemanAmount);
				BuyUnitPanel.this.mainPanel.getActivePlayer().setMoney(BuyUnitPanel.this.mainPanel.getActivePlayer().getMoney()-
						((archerAmount+lancerAmount+horsemanAmount)*Settings.UNIT_COST));
				BuyUnitPanel.this.mainPanel.changeToMapPanel();
				
				archerAmount = 0;
				lancerAmount = 0;
				horsemanAmount = 0;
				refreshAmountLables();
				refreshTotalCostLable();
				refreshTotalAmountLable();
			}
		});
		add(buyUnitsButton);
	}
	
	private void refreshAmountLables(){
		archerAmountLable.setText(archerAmount+"");
		lancerAmountLable.setText(lancerAmount+"");
		horsemanAmountLable.setText(horsemanAmount+"");
	}
	
	private void refreshTotalCostLable(){
		totalCostLable.setText(((archerAmount+lancerAmount+horsemanAmount)*Settings.UNIT_COST)+"$");
	}
	
	private void refreshTotalAmountLable(){
		totalAmountLable.setText((archerAmount+lancerAmount+horsemanAmount)+"");
	}
	
}
