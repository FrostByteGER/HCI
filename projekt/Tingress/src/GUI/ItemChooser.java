package GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ItemChooser extends JPanel{
	private JButton leftButton;
	private JButton rightButton;
	private JButton item1Button;
	private JButton item2Button;
	private JButton item3Button;
	
	private MainPanel mainPanel;
	
	public ItemChooser(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		leftButton = new JButton("<");
		add(leftButton);
		
		item1Button = new JButton("[1]");
		add(item1Button);
		item1Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		item2Button = new JButton("[2]");
		add(item2Button);
		
		item3Button = new JButton("[3]");
		add(item3Button);
		
		rightButton = new JButton(">");
		add(rightButton);
		
	}
	
	
}
