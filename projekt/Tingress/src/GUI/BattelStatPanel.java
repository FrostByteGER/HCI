package GUI;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.GameField;
import core.Settings;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class BattelStatPanel extends JPanel {
	private JPanel panel;
	private JButton backButton;
	private JLabel battelStateTitleLabel;
	private JPanel unitTypPanel;
	private JLabel placeHolderLabel;
	private JLabel archerLabel;
	private JLabel lancerLabel;
	private JLabel horsemanLabel;
	private JPanel defLostPanel;
	private JLabel placeHolder2Label;
	private JLabel defNameLabel;
	private JLabel defLostLabel;
	private JLabel defLostArcherAmountLabel;
	private JLabel defLostLancerAmountLabel;
	private JLabel defLostHorsemanAmountLabel;
	private JPanel defRemainPanel;
	private JLabel defPlaceholderLabel;
	private JLabel defRemainLabel;
	private JLabel defRemainArcherAmountLabel;
	private JLabel defRemainLancerAmountLabel;
	private JLabel defRemainHorsemanAmountLabel;
	private JPanel atkLostPanel;
	private JLabel atkNameLabel;
	private JLabel atkLostLabel;
	private JLabel atkLostArcherAmountLabel;
	private JLabel atkLostLancerAmountLabel;
	private JLabel atkLostHorsemanAmountLabel;
	private JPanel atkRemainPanel;
	private JLabel atkPlaceholderLabel;
	private JLabel atkRemainLabel;
	private JLabel atkRemainArcherAmountLabel;
	private JLabel atkRemainLancerAmountLabel;
	private JLabel atkRemainHorsemanAmountLabel;
	private JPanel datePanel;
	private JLabel dateNameLable;
	private JLabel dateLable;
	private JButton reinforceButton;
	
	private MainPanel mainPanel;
	
	private GameField activeField;
	
	public BattelStatPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		this.activeField = mainPanel.getGame().getMap().getField(mainPanel.getActivePlayer().getX(), mainPanel.getActivePlayer().getY());
		
		setLayout(new GridLayout(8, 1, 0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BattelStatPanel.this.mainPanel.changeToMapPanel();
			}
		});
		panel.add(backButton, BorderLayout.WEST);
		
		battelStateTitleLabel = new JLabel("Battle State");
		battelStateTitleLabel.setFont(Settings.MID_FONT);
		battelStateTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
		battelStateTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(battelStateTitleLabel, BorderLayout.CENTER);
		
		unitTypPanel = new JPanel();
		add(unitTypPanel);
		unitTypPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		placeHolderLabel = new JLabel("");
		unitTypPanel.add(placeHolderLabel);
		
		placeHolder2Label = new JLabel("");
		unitTypPanel.add(placeHolder2Label);
		
		archerLabel = new JLabel("");
		archerLabel.setIcon(Settings.ARCHER);
		archerLabel.setVerticalAlignment(SwingConstants.CENTER);
		archerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unitTypPanel.add(archerLabel);
		
		lancerLabel = new JLabel("");
		lancerLabel.setIcon(Settings.LANCER);
		lancerLabel.setVerticalAlignment(SwingConstants.CENTER);
		lancerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unitTypPanel.add(lancerLabel);
		
		horsemanLabel = new JLabel("");
		horsemanLabel.setIcon(Settings.HORSEMAN);
		horsemanLabel.setVerticalAlignment(SwingConstants.CENTER);
		horsemanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unitTypPanel.add(horsemanLabel);
		
		defLostPanel = new JPanel();
		//defLostPanel.setBackground(Settings.LIGHT_BLUE);
		add(defLostPanel);
		defLostPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		defNameLabel = new JLabel("");
		defNameLabel.setIcon(Settings.SHIELD);
		defLostPanel.add(defNameLabel);
		
		defLostLabel = new JLabel("Lost");
		defLostPanel.add(defLostLabel);
		
		defLostArcherAmountLabel = new JLabel("0");
		defLostArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defLostArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defLostPanel.add(defLostArcherAmountLabel);
		
		defLostLancerAmountLabel = new JLabel("0");
		defLostLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defLostLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defLostPanel.add(defLostLancerAmountLabel);
		
		defLostHorsemanAmountLabel = new JLabel("0");
		defLostHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defLostHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defLostPanel.add(defLostHorsemanAmountLabel);
		
		defRemainPanel = new JPanel();
		add(defRemainPanel);
		defRemainPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		defPlaceholderLabel = new JLabel("");
		defRemainPanel.add(defPlaceholderLabel);
		
		defRemainLabel = new JLabel("Remain");
		defRemainPanel.add(defRemainLabel);
		
		defRemainArcherAmountLabel = new JLabel("0");
		defRemainArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defRemainArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defRemainPanel.add(defRemainArcherAmountLabel);
		
		defRemainLancerAmountLabel = new JLabel("0");
		defRemainLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defRemainLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defRemainPanel.add(defRemainLancerAmountLabel);
		
		defRemainHorsemanAmountLabel = new JLabel("0");
		defRemainHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defRemainHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defRemainPanel.add(defRemainHorsemanAmountLabel);
		
		atkLostPanel = new JPanel();
		add(atkLostPanel);
		atkLostPanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		atkNameLabel = new JLabel("");
		atkNameLabel.setIcon(Settings.SWORD);
		atkLostPanel.add(atkNameLabel);
		
		atkLostLabel = new JLabel("Lost");
		atkLostPanel.add(atkLostLabel);
		
		atkLostArcherAmountLabel = new JLabel("0");
		atkLostArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkLostArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkLostPanel.add(atkLostArcherAmountLabel);
		
		atkLostLancerAmountLabel = new JLabel("0");
		atkLostLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkLostLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkLostPanel.add(atkLostLancerAmountLabel);
		
		atkLostHorsemanAmountLabel = new JLabel("0");
		atkLostHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkLostHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkLostPanel.add(atkLostHorsemanAmountLabel);
		
		atkRemainPanel = new JPanel();
		add(atkRemainPanel);
		atkRemainPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		atkPlaceholderLabel = new JLabel("");
		atkRemainPanel.add(atkPlaceholderLabel);
		
		atkRemainLabel = new JLabel("Remain");
		atkRemainPanel.add(atkRemainLabel);
		
		atkRemainArcherAmountLabel = new JLabel("0");
		atkRemainArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkRemainArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkRemainPanel.add(atkRemainArcherAmountLabel);
		
		atkRemainLancerAmountLabel = new JLabel("0");
		atkRemainLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkRemainLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkRemainPanel.add(atkRemainLancerAmountLabel);
		
		atkRemainHorsemanAmountLabel = new JLabel("0");
		atkRemainHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkRemainHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkRemainPanel.add(atkRemainHorsemanAmountLabel);
		
		datePanel = new JPanel();
		add(datePanel);
		datePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		dateNameLable = new JLabel("Date");
		datePanel.add(dateNameLable);
		
		dateLable = new JLabel("26.01.2016");
		datePanel.add(dateLable);
		
		reinforceButton = new JButton("Reinforce");
		reinforceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BattelStatPanel.this.mainPanel.changeToBattelPreparePanel();
				
			}
		});
		
		add(reinforceButton);
		
	}
	
	public void refreshLables(){
		this.activeField = mainPanel.getGame().getMap().getField(mainPanel.getActivePlayer().getX(), mainPanel.getActivePlayer().getY());
		
		if(this.activeField.getOwnerFraction().getNumber() == 1){
			defLostPanel.setBackground(Settings.LIGHT_RED);
			defRemainPanel.setBackground(Settings.LIGHT_RED);
			
			atkLostPanel.setBackground(Settings.LIGHT_BLUE);
			atkRemainPanel.setBackground(Settings.LIGHT_BLUE);
		}else{		
			defLostPanel.setBackground(Settings.LIGHT_BLUE);
			defRemainPanel.setBackground(Settings.LIGHT_BLUE);
			
			atkLostPanel.setBackground(Settings.LIGHT_RED);
			atkRemainPanel.setBackground(Settings.LIGHT_RED);
		}
		
		defRemainArcherAmountLabel.setText(activeField.getArcherDefAmount()+"");
		defRemainLancerAmountLabel.setText(activeField.getLancerDefAmount()+"");
		defRemainHorsemanAmountLabel.setText(activeField.getHorsemanDefAmount()+"");
		
		atkRemainArcherAmountLabel.setText(activeField.getArcherAtkAmount()+"");
		atkRemainLancerAmountLabel.setText(activeField.getLancerAtkAmount()+"");
		atkRemainHorsemanAmountLabel.setText(activeField.getHorsemanAtkAmount()+"");
	}
	
}
