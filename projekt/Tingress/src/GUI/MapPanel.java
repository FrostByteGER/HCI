package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapPanel extends JPanel{
	private JButton field;
	
	private MainPanel mainPanel;
	
	public MapPanel(MainPanel mainPanel) {
		
		this.mainPanel = mainPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		field = new JButton("Field");
		add(field);
		
		field.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.changeToBattelPreparePanel();
				
			}
		});
	}
}
