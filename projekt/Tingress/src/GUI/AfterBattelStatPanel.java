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

public class AfterBattelStatPanel extends JPanel {
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
	
	public AfterBattelStatPanel(MainPanel mainPanel) {
		
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
				AfterBattelStatPanel.this.mainPanel.changeToMapPanel();
			}
		});
		panel.add(backButton, BorderLayout.WEST);
		
		battelStateTitleLabel = new JLabel("WIN");
		battelStateTitleLabel.setFont(Settings.MID_FONT);
		battelStateTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
		battelStateTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(battelStateTitleLabel, BorderLayout.CENTER);
		
		unitTypPanel = new JPanel();
		add(unitTypPanel);
		unitTypPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		placeHolderLabel = new JLabel("/");
		unitTypPanel.add(placeHolderLabel);
		
		placeHolder2Label = new JLabel("/");
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
		add(defLostPanel);
		defLostPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		defNameLabel = new JLabel("Def");
		defLostPanel.add(defNameLabel);
		
		defLostLabel = new JLabel("Lost");
		defLostPanel.add(defLostLabel);
		
		defLostArcherAmountLabel = new JLabel("10");
		defLostArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defLostArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defLostPanel.add(defLostArcherAmountLabel);
		
		defLostLancerAmountLabel = new JLabel("15");
		defLostArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defLostArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defLostPanel.add(defLostLancerAmountLabel);
		
		defLostHorsemanAmountLabel = new JLabel("12");
		defLostArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defLostArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defLostPanel.add(defLostHorsemanAmountLabel);
		
		defRemainPanel = new JPanel();
		add(defRemainPanel);
		defRemainPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		defPlaceholderLabel = new JLabel("/");
		defRemainPanel.add(defPlaceholderLabel);
		
		defRemainLabel = new JLabel("Remain");
		defRemainPanel.add(defRemainLabel);
		
		defRemainArcherAmountLabel = new JLabel("16");
		defRemainArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defRemainArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defRemainPanel.add(defRemainArcherAmountLabel);
		
		defRemainLancerAmountLabel = new JLabel("13");
		defRemainLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defRemainLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defRemainPanel.add(defRemainLancerAmountLabel);
		
		defRemainHorsemanAmountLabel = new JLabel("9");
		defRemainHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		defRemainHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defRemainPanel.add(defRemainHorsemanAmountLabel);
		
		atkLostPanel = new JPanel();
		add(atkLostPanel);
		atkLostPanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		atkNameLabel = new JLabel("Atk");
		atkLostPanel.add(atkNameLabel);
		
		atkLostLabel = new JLabel("Lost");
		atkLostPanel.add(atkLostLabel);
		
		atkLostArcherAmountLabel = new JLabel("20");
		atkLostArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkLostArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkLostPanel.add(atkLostArcherAmountLabel);
		
		atkLostLancerAmountLabel = new JLabel("20");
		atkLostLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkLostLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkLostPanel.add(atkLostLancerAmountLabel);
		
		atkLostHorsemanAmountLabel = new JLabel("20");
		atkLostHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkLostHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkLostPanel.add(atkLostHorsemanAmountLabel);
		
		atkRemainPanel = new JPanel();
		add(atkRemainPanel);
		atkRemainPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		atkPlaceholderLabel = new JLabel("/");
		atkRemainPanel.add(atkPlaceholderLabel);
		
		atkRemainLabel = new JLabel("Remain");
		atkRemainPanel.add(atkRemainLabel);
		
		atkRemainArcherAmountLabel = new JLabel("0");
		atkRemainArcherAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkRemainArcherAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkRemainPanel.add(atkRemainArcherAmountLabel);
		
		atkRemainLancerAmountLabel = new JLabel("0");
		atkRemainLancerAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkRemainLancerAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkRemainPanel.add(atkRemainLancerAmountLabel);
		
		atkRemainHorsemanAmountLabel = new JLabel("0");
		atkRemainHorsemanAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		atkRemainHorsemanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atkRemainPanel.add(atkRemainHorsemanAmountLabel);
		
		datePanel = new JPanel();
		add(datePanel);
		datePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		dateNameLable = new JLabel("Date");
		datePanel.add(dateNameLable);
		
		dateLable = new JLabel("TT.MM.JJJJ");
		datePanel.add(dateLable);
		
		reinforceButton = new JButton("Reinforce");
		reinforceButton.setEnabled(false);
		add(reinforceButton);
		
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
		
	}
	
	public void refreshLables(){
		this.activeField = mainPanel.getGame().getMap().getField(mainPanel.getActivePlayer().getX(), mainPanel.getActivePlayer().getY());
		
		
		defRemainArcherAmountLabel.setText(activeField.getArcherDefAmount()+"");
		defRemainLancerAmountLabel.setText(activeField.getLancerDefAmount()+"");
		defRemainHorsemanAmountLabel.setText(activeField.getHorsemanDefAmount()+"");
		
		atkRemainArcherAmountLabel.setText(activeField.getArcherAtkAmount()+"");
		atkRemainLancerAmountLabel.setText(activeField.getLancerAtkAmount()+"");
		atkRemainHorsemanAmountLabel.setText(activeField.getHorsemanAtkAmount()+"");
	}
	
}
