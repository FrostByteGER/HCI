package GUI;

import javax.swing.JPanel;
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
	
	public BattelPreparePanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(8, 0, 0, 0));
		
		titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		titlePanel.add(backButton, BorderLayout.WEST);
		
		prepareTitleLabel = new JLabel("Prepare");
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
		
		archerLabel = new JLabel("Archer");
		archerChoosePanel.add(archerLabel);
		
		archerDecreaseButton = new JButton("-");
		archerChoosePanel.add(archerDecreaseButton);
		
		archerAmountLabel = new JLabel("0");
		archerChoosePanel.add(archerAmountLabel);
		
		archerIncreaseButton = new JButton("+");
		archerChoosePanel.add(archerIncreaseButton);
		
		archerMaxLabel = new JLabel("10");
		archerChoosePanel.add(archerMaxLabel);
		
		lancerChoosePanel = new JPanel();
		add(lancerChoosePanel);
		lancerChoosePanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		lancerChooseLabel = new JLabel("Lancer");
		lancerChoosePanel.add(lancerChooseLabel);
		
		lancerDecreaseButton = new JButton("-");
		lancerChoosePanel.add(lancerDecreaseButton);
		
		lancerAmountLabel = new JLabel("0");
		lancerChoosePanel.add(lancerAmountLabel);
		
		lancerIncreaseButton = new JButton("+");
		lancerChoosePanel.add(lancerIncreaseButton);
		
		lancerMaxLabel = new JLabel("10");
		lancerChoosePanel.add(lancerMaxLabel);
		
		horsemanChoosePanel = new JPanel();
		add(horsemanChoosePanel);
		horsemanChoosePanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		horsemanChooseLabel = new JLabel("Horseman");
		horsemanChoosePanel.add(horsemanChooseLabel);
		
		horsemanDecreaseButton = new JButton("-");
		horsemanChoosePanel.add(horsemanDecreaseButton);
		
		horsemanAmountLabel = new JLabel("0");
		horsemanChoosePanel.add(horsemanAmountLabel);
		
		horsemanIncreaseButton = new JButton("+");
		horsemanChoosePanel.add(horsemanIncreaseButton);
		
		horsemanMaxLabel = new JLabel("10");
		horsemanChoosePanel.add(horsemanMaxLabel);
		
		totalInfoPanel = new JPanel();
		add(totalInfoPanel);
		totalInfoPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		totalLabel = new JLabel("Total");
		totalInfoPanel.add(totalLabel);
		
		chooseAmountLabel = new JLabel("0");
		totalInfoPanel.add(chooseAmountLabel);
		
		maxLabel = new JLabel("30");
		totalInfoPanel.add(maxLabel);
		
		itemPanel = new JPanel();
		add(itemPanel);
		itemPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		itemLabel = new JLabel("Items");
		itemPanel.add(itemLabel);
		
		itemButton1 = new JButton("Item1");
		itemPanel.add(itemButton1);
		itemButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				itemPanel = new JPanel();
				
			}
		});
		
		itemButton2 = new JButton("Item2");
		itemPanel.add(itemButton2);
		
		itemButton3 = new JButton("Item3");
		itemPanel.add(itemButton3);
		
		executeButton = new JButton("Attack / Defend");
		add(executeButton);
		
	}
	
	
	
}
