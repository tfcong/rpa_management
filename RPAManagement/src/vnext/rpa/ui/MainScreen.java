package vnext.rpa.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vnext.rpa.contants.Contants;

public class MainScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final MainScreen mainScreen = new MainScreen();

	private MainScreen() {		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle(Contants.MAIN_SCREEN_TITLE);
		setVisible(true);
		setSize(Contants.SCREEN_WIDTH, Contants.SCREEN_HEIGHT);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(e.getWindow(), Contants.CLOSE_MAIN_SCREEN_MESSAGE,
						Contants.TITLE_CONFIRM_CLOSE, JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (option == JOptionPane.NO_OPTION) {
					e.getWindow().setVisible(false);
				} else {
					System.out.println("To do nothing");
				}
			}
		});
		SystemTrayIcon.createSysteamTrayIcon();
	}

	public static MainScreen getInstance() {
		return mainScreen;
	}

}
