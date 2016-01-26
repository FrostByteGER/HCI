package GUI;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.Settings;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BattelPreparePanel extends JPanel {
	private JPanel titlePanel;
	private JPanel namePanel;
	private JPanel archerChoosePanel;
	private JPanel lancerChoosePanel;
	private JPanel horsemanChoosePanel;
	private JPanel totalInfoPanel;
	private JPanel itemPanel;
	private JButton executeButton;
	private JButton backButton;
	private JLabel prepareTitleLabel;
	private JLabel nameLabel;
	private JLabel fieldNameLabel;
	private JLabel archerLabel;
	private JButton archerDecreaseButton;
	private JLabel archerAmountLabel;
	private JButton archerIncreaseButton;
	private JLabel archerMaxLabel;
	private JLabel lancerChooseLabel;
	private JButton lancerDecreaseButton;
	private JLabel lancerAmountLabel;
	private JButton lancerIncreaseButton;
	private JLabel lancerMaxLabel;
	private JLabel horsemanChooseLabel;
	private JButton horsemanDecreaseButton;
	private JLabel horsemanAmountLabel;
	private JButton horsemanIncreaseButton;
	private JLabel horsemanMaxLabel;
	private JLabel totalLabel;
	private JLabel chooseAmountLabel;
	private JLabel maxLabel;
	private JLabel itemLabel;
	private JButton itemButton1;
	private JButton itemButton2;
	private JButton itemButton3;
	
	private MainPanel mainPanel;
	
	private int archerAmount = 0;
	private int lancerAmount = 0;
	private int horsemanAmount = 0;
	
	public BattelPreparePanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(8, 0, 0, 0));
		
		titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BattelPreparePanel.this.mainPanel.changeToMapPanel();
			}
		});
		titlePanel.add(backButton, BorderLayout.WEST);
		
		prepareTitleLabel = new JLabel("Prepare");
		prepareTitleLabel.setFont(Settings.MID_FONT);
		prepareTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
		prepareTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(prepareTitleLabel, BorderLayout.CENTER);
		
		namePanel = new JPanel();
		add(namePanel);
		namePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		nameLabel = new JLabel("Name");
		namePanel.add(nameLabel);
		
		fieldNameLabel = new JLabel("Rewe");
		namePanel.add(fieldNameLabel);
		
		archerChoosePanel = new JPanel();
		add(archerChoosePanel);
		archerChoosePanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		archerLabel = new JLabel("");
		archerLabel.setIcon(Settings.ARCHER);
		archerLabel.setVerticalAlignment(SwingConstants.CENTER);
		archerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		archerChoosePanel.add(archerLabel);
		
		archerDecreaseButton = new JButton("-");
		archerDecreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(0 < archerAmount){
					archerAmount--;
					refreshArcherAmountLabel();
				}
			}
		});
		archerChoosePanel.add(archerDecreaseButton);
		
		archerAmountLabel = new JLabel("0");
		archerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		archerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		archerChoosePanel.add(archerAmountLabel);
		
		archerIncreaseButton = new JButton("+");
		archerIncreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BattelPreparePanel.this.mainPanel.getActivePlayer().getUnits().getArcher().size() > archerAmount){
					archerAmount++;
					refreshArcherAmountLabel();
				}
			}
		});
		archerChoosePanel.add(archerIncreaseButton);
		
		archerMaxLabel = new JLabel("10");
		archerMaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		archerMaxLabel.setVerticalAlignment(SwingConstants.CENTER);
		archerChoosePanel.add(archerMaxLabel);
		
		lancerChoosePanel = new JPanel();
		add(lancerChoosePanel);
		lancerChoosePanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		lancerChooseLabel = new JLabel("");
		lancerChooseLabel.setIcon(Settings.LANCER);
		lancerChooseLabel.setVerticalAlignment(SwingConstants.CENTER);
		lancerChooseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lancerChoosePanel.add(lancerChooseLabel);
		
		lancerDecreaseButton = new JButton("-");
		lancerDecreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(0 < lancerAmount){
					lancerAmount--;
					refreshLancerAmountLabel();
				}
			}
		});
		lancerChoosePanel.add(lancerDecreaseButton);
		
		lancerAmountLabel = new JLabel("0");
		lancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		lancerChoosePanel.add(lancerAmountLabel);
		
		lancerIncreaseButton = new JButton("+");
		lancerIncreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BattelPreparePanel.this.mainPanel.getActivePlayer().getUnits().getLancer().size() > lancerAmount){
					lancerAmount++;
					refreshLancerAmountLabel();
				}
			}
		});
		lancerChoosePanel.add(lancerIncreaseButton);
		
		lancerMaxLabel = new JLabel("10");
		lancerMaxLabel.setVerticalAlignment(SwingConstants.CENTER);
		lancerMaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lancerChoosePanel.add(lancerMaxLabel);
		
		horsemanChoosePanel = new JPanel();
		add(horsemanChoosePanel);
		horsemanChoosePanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		horsemanChooseLabel = new JLabel("");
		horsemanChooseLabel.setIcon(Settings.HORSEMAN);
		horsemanChooseLabel.setVerticalAlignment(SwingConstants.CENTER);
		horsemanChooseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horsemanChoosePanel.add(horsemanChooseLabel);
		
		horsemanDecreaseButton = new JButton("-");
		horsemanDecreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(0 < horsemanAmount){
					horsemanAmount--;
					refreshHorsemanAmountLabel();
				}
			}
		});
		horsemanChoosePanel.add(horsemanDecreaseButton);
		
		horsemanAmountLabel = new JLabel("0");
		horsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		horsemanChoosePanel.add(horsemanAmountLabel);
		
		horsemanIncreaseButton = new JButton("+");
		horsemanIncreaseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BattelPreparePanel.this.mainPanel.getActivePlayer().getUnits().getHorseman().size() > horsemanAmount){
					horsemanAmount++;
					refreshHorsemanAmountLabel();
				}
			}
		});
		horsemanChoosePanel.add(horsemanIncreaseButton);
		
		horsemanMaxLabel = new JLabel("10");
		horsemanMaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horsemanMaxLabel.setVerticalAlignment(SwingConstants.CENTER);
		horsemanChoosePanel.add(horsemanMaxLabel);
		
		totalInfoPanel = new JPanel();
		add(totalInfoPanel);
		totalInfoPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		totalLabel = new JLabel("Total");
		totalInfoPanel.add(totalLabel);
		
		chooseAmountLabel = new JLabel("0");
		chooseAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalInfoPanel.add(chooseAmountLabel);
		
		maxLabel = new JLabel("30");
		maxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxLabel.setVerticalAlignment(SwingConstants.CENTER);
		totalInfoPanel.add(maxLabel);
		
		itemPanel = new JPanel();
		add(itemPanel);
		itemPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		itemLabel = new JLabel("Items");
		itemPanel.add(itemLabel);
		
		itemButton1 = new JButton("");
		itemButton1.setIcon(Settings.ITEM);
		itemPanel.add(itemButton1);
		
		itemButton2 = new JButton("");
		itemButton2.setIcon(Settings.ITEM);
		itemPanel.add(itemButton2);
		
		itemButton3 = new JButton("");
		itemButton3.setIcon(Settings.ITEM);
		itemPanel.add(itemButton3);
		
		executeButton = new JButton("Attack / Defend");
		executeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//BattelPreparePanel.this.mainPanel.getGame().getMap().getField(BattelPreparePanel.this.mainPanel.getActivePlayer().getX(), BattelPreparePanel.this.mainPanel.getActivePlayer().getY()).
				//addUnits(BattelPreparePanel.this.mainPanel.getActivePlayer(), archerAmount, horsemanAmount, lancerAmount);
				
				BattelPreparePanel.this.mainPanel.getActivePlayer().addUnitsToField(BattelPreparePanel.this.mainPanel.getGame().getMap().getField(BattelPreparePanel.this.mainPanel.getActivePlayer().getX(), BattelPreparePanel.this.mainPanel.getActivePlayer().getY()), archerAmount, horsemanAmount, lancerAmount);
				
				// addUnitsToField
				
				BattelPreparePanel.this.mainPanel.changeToMapPanel();
			}
		});
		add(executeButton);
		
	}
	
	private void refreshArcherAmountLabel(){
		archerAmountLabel.setText(archerAmount+"");
		chooseAmountLabel.setText((archerAmount+lancerAmount+horsemanAmount)+"");
	}
	
	private void refreshLancerAmountLabel(){
		lancerAmountLabel.setText(lancerAmount+"");
		chooseAmountLabel.setText((archerAmount+lancerAmount+horsemanAmount)+"");
	}
	
	private void refreshHorsemanAmountLabel(){
		horsemanAmountLabel.setText(horsemanAmount+"");
		chooseAmountLabel.setText((archerAmount+lancerAmount+horsemanAmount)+"");
	}
	
	public void refresh(){
		
		//activPlayer owns the Field
		if(mainPanel.getGame().getMap().getField(mainPanel.getActivePlayer().getX(), mainPanel.getActivePlayer().getY()).getOwnerFraction().getNumber() == mainPanel.getActivePlayer().getFraction().getNumber()){
			executeButton.setText("Defend");
		}else{
			executeButton.setText("Attack");
		}
		
		archerAmount = 0;
		lancerAmount = 0;
		horsemanAmount = 0;
		
		archerMaxLabel.setText(mainPanel.getActivePlayer().getUnits().getArcher().size()+"");
		lancerMaxLabel.setText(mainPanel.getActivePlayer().getUnits().getLancer().size()+"");
		horsemanMaxLabel.setText(mainPanel.getActivePlayer().getUnits().getHorseman().size()+"");
		
		maxLabel.setText(mainPanel.getActivePlayer().getUnits().getUnitAmount()+"");
		
		refreshArcherAmountLabel();
		refreshLancerAmountLabel();
		refreshHorsemanAmountLabel();
		
	}
	
}
