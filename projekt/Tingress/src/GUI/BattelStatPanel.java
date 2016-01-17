package GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
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
	
	public BattelStatPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(8, 1, 0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		panel.add(backButton, BorderLayout.WEST);
		
		battelStateTitleLabel = new JLabel("Battel State");
		panel.add(battelStateTitleLabel, BorderLayout.CENTER);
		
		unitTypPanel = new JPanel();
		add(unitTypPanel);
		unitTypPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		placeHolderLabel = new JLabel("/");
		unitTypPanel.add(placeHolderLabel);
		
		placeHolder2Label = new JLabel("/");
		unitTypPanel.add(placeHolder2Label);
		
		archerLabel = new JLabel("Archer");
		unitTypPanel.add(archerLabel);
		
		lancerLabel = new JLabel("Lancer");
		unitTypPanel.add(lancerLabel);
		
		horsemanLabel = new JLabel("Horseman");
		unitTypPanel.add(horsemanLabel);
		
		defLostPanel = new JPanel();
		add(defLostPanel);
		defLostPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		defNameLabel = new JLabel("Def");
		defLostPanel.add(defNameLabel);
		
		defLostLabel = new JLabel("Lost");
		defLostPanel.add(defLostLabel);
		
		defLostArcherAmountLabel = new JLabel("0");
		defLostPanel.add(defLostArcherAmountLabel);
		
		defLostLancerAmountLabel = new JLabel("0");
		defLostPanel.add(defLostLancerAmountLabel);
		
		defLostHorsemanAmountLabel = new JLabel("0");
		defLostPanel.add(defLostHorsemanAmountLabel);
		
		defRemainPanel = new JPanel();
		add(defRemainPanel);
		defRemainPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		defPlaceholderLabel = new JLabel("/");
		defRemainPanel.add(defPlaceholderLabel);
		
		defRemainLabel = new JLabel("Remain");
		defRemainPanel.add(defRemainLabel);
		
		defRemainArcherAmountLabel = new JLabel("0");
		defRemainPanel.add(defRemainArcherAmountLabel);
		
		defRemainLancerAmountLabel = new JLabel("0");
		defRemainPanel.add(defRemainLancerAmountLabel);
		
		defRemainHorsemanAmountLabel = new JLabel("0");
		defRemainPanel.add(defRemainHorsemanAmountLabel);
		
		atkLostPanel = new JPanel();
		add(atkLostPanel);
		atkLostPanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		atkNameLabel = new JLabel("Atk");
		atkLostPanel.add(atkNameLabel);
		
		atkLostLabel = new JLabel("Lost");
		atkLostPanel.add(atkLostLabel);
		
		atkLostArcherAmountLabel = new JLabel("0");
		atkLostPanel.add(atkLostArcherAmountLabel);
		
		atkLostLancerAmountLabel = new JLabel("0");
		atkLostPanel.add(atkLostLancerAmountLabel);
		
		atkLostHorsemanAmountLabel = new JLabel("0");
		atkLostPanel.add(atkLostHorsemanAmountLabel);
		
		atkRemainPanel = new JPanel();
		add(atkRemainPanel);
		atkRemainPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		atkPlaceholderLabel = new JLabel("/");
		atkRemainPanel.add(atkPlaceholderLabel);
		
		atkRemainLabel = new JLabel("Remain");
		atkRemainPanel.add(atkRemainLabel);
		
		atkRemainArcherAmountLabel = new JLabel("0");
		atkRemainPanel.add(atkRemainArcherAmountLabel);
		
		atkRemainLancerAmountLabel = new JLabel("0");
		atkRemainPanel.add(atkRemainLancerAmountLabel);
		
		atkRemainHorsemanAmountLabel = new JLabel("0");
		atkRemainPanel.add(atkRemainHorsemanAmountLabel);
		
		datePanel = new JPanel();
		add(datePanel);
		datePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		dateNameLable = new JLabel("Date");
		datePanel.add(dateNameLable);
		
		dateLable = new JLabel("TT.MM.JJJJ");
		datePanel.add(dateLable);
		
		reinforceButton = new JButton("Reinforce");
		add(reinforceButton);
		
	}
	
}
