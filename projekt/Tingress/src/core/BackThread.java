package core;

import GUI.MainPanel;

public class BackThread extends Thread {
	
	private MainPanel mainPanel;
	
	public BackThread(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	@Override
	public void run() {
		super.run();
		while(true){
			try {
				
				mainPanel.getGame().runOnce();
				mainPanel.updateUI();
				//System.out.println("Tick");
				sleep(Settings.TICK_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
