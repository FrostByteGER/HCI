package GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
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
	private JLabel archerAmount;
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
	
	public BuyUnitPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(0, 1, 0, 0));
		
		titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		backButton = new JButton("Back");
		titlePanel.add(backButton, BorderLayout.WEST);
		
		titleBuyLabel = new JLabel("Buy Units");
		titlePanel.add(titleBuyLabel, BorderLayout.CENTER);
		
		infoPanel = new JPanel();
		add(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		maxLable = new JLabel("Max");
		infoPanel.add(maxLable);
		
		maxAmountLable = new JLabel("11");
		infoPanel.add(maxAmountLable);
		
		costLable = new JLabel("Cost");
		infoPanel.add(costLable);
		
		archerPanel = new JPanel();
		add(archerPanel);
		archerPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		archerLable = new JLabel("Archer");
		archerPanel.add(archerLable);
		
		archerDecreaseButton = new JButton("-");
		archerPanel.add(archerDecreaseButton);
		
		archerAmount = new JLabel("0");
		archerPanel.add(archerAmount);
		
		archerIncreaseButton = new JButton("+");
		archerPanel.add(archerIncreaseButton);
		
		archerCostLable = new JLabel("5");
		archerPanel.add(archerCostLable);
		
		lancerPanel = new JPanel();
		add(lancerPanel);
		lancerPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		lancerLable = new JLabel("Lancer");
		lancerPanel.add(lancerLable);
		
		lancerDecreaseButton = new JButton("-");
		lancerPanel.add(lancerDecreaseButton);
		
		lancerAmountLable = new JLabel("0");
		lancerPanel.add(lancerAmountLable);
		
		lancerIncreaseButton = new JButton("+");
		lancerPanel.add(lancerIncreaseButton);
		
		lancerCostLable = new JLabel("5");
		lancerPanel.add(lancerCostLable);
		
		HorsemanPanel = new JPanel();
		add(HorsemanPanel);
		HorsemanPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		horsemanLable = new JLabel("Horseman");
		HorsemanPanel.add(horsemanLable);
		
		horsemanDecreaseButton = new JButton("-");
		HorsemanPanel.add(horsemanDecreaseButton);
		
		horsemanAmountLable = new JLabel("0");
		HorsemanPanel.add(horsemanAmountLable);
		
		horsemanIncreaseButton = new JButton("+");
		HorsemanPanel.add(horsemanIncreaseButton);
		
		horsemanCostLable = new JLabel("5");
		HorsemanPanel.add(horsemanCostLable);
		
		totalPanel = new JPanel();
		add(totalPanel);
		totalPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		totalLable = new JLabel("Total");
		totalPanel.add(totalLable);
		
		totalAmountLable = new JLabel("0");
		totalPanel.add(totalAmountLable);
		
		totalCostLable = new JLabel("15");
		totalPanel.add(totalCostLable);
		
		buyUnitsButton = new JButton("Buy Units");
		add(buyUnitsButton);
		// TODO Auto-generated constructor stub
	}
	
	
}
