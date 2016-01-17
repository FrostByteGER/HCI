package GUI;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
	private JButton btnNewButton;
	private JLabel nameLabel;
	private JLabel cashLabel;
	private JLabel fieldNameLabel;
	private JLabel fieldCashLabel;
	
	private MainPanel mainPanel;
	
	public FieldStatPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(7, 0, 0, 0));
		
		titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		titlePanel.add(backButton, BorderLayout.WEST);
		
		statisticLabel = new JLabel("Statistic");
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
		
		fieldCashLabel = new JLabel("0$");
		infoPanel.add(fieldCashLabel);
		
		btnNewButton = new JButton("New button");
		infoAttackPanel.add(btnNewButton, BorderLayout.EAST);
		
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
		
		archerNameLabel = new JLabel("Archer");
		archerPanel.add(archerNameLabel);
		
		archerAmountLabel = new JLabel("0");
		archerPanel.add(archerAmountLabel);
		
		lancerPanel = new JPanel();
		add(lancerPanel);
		lancerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lancerNameLabel = new JLabel("Lancer");
		lancerPanel.add(lancerNameLabel);
		
		lancerAmountLabel = new JLabel("0");
		lancerPanel.add(lancerAmountLabel);
		
		horsemanPanel = new JPanel();
		add(horsemanPanel);
		horsemanPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		horsemanLabel = new JLabel("Horseman");
		horsemanPanel.add(horsemanLabel);
		
		horsemanAmountLabel = new JLabel("0");
		horsemanPanel.add(horsemanAmountLabel);
		
		itemPanel = new JPanel();
		add(itemPanel);
		itemPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		itemButton1 = new JButton("Item1");
		itemPanel.add(itemButton1);
		
		itemButton2 = new JButton("Item2");
		itemPanel.add(itemButton2);
		
		itemButton3 = new JButton("Item3");
		itemPanel.add(itemButton3);
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
