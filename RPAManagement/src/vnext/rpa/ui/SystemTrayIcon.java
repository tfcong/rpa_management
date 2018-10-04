package vnext.rpa.ui;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


import vnext.rpa.contants.Contants;

public class SystemTrayIcon {
	public static void createSysteamTrayIcon() {
		if (SystemTray.isSupported()) {
			// init tray
			SystemTray tray = SystemTray.getSystemTray();
			// get image from resources
			Image image = Toolkit.getDefaultToolkit()
					.getImage(SystemTray.class.getResource(Contants.STRAY_ICON_FILE_NAME_PNG));
			// create menu to tray icon
			PopupMenu popupMenu = new PopupMenu();
			// create item menu start
			final MenuItem miStart = new MenuItem(Contants.START_MENU_LABEL);
			final MenuItem miExit = new MenuItem(Contants.EXIT_MENU_LABEL);
			final MenuItem miPause = new MenuItem(Contants.PAUSE_MENU_LABEL);

			ActionListener exitListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Runtime r = Runtime.getRuntime();
					System.out.println("Exiting...");
					r.exit(0);
				}
			};

			ActionListener startListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					System.out.println("Starting...");

				}
			};
			ActionListener pauseListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("Pause...");

				}
			};
			miStart.addActionListener(startListener);
			miPause.addActionListener(pauseListener);
			miExit.addActionListener(exitListener);
			popupMenu.add(miStart);
			popupMenu.add(miPause);
			popupMenu.add(miExit);
			final TrayIcon trayIcon = new TrayIcon(image, Contants.TRAY_ICON_TITLE, popupMenu);
			ActionListener doubleClickListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("double click");
				}
			};	
			trayIcon.setImageAutoSize(true);
			trayIcon.addActionListener(doubleClickListener);
			trayIcon.addMouseListener(new MouseAdapter() {
			});
			try {
				tray.add(trayIcon);
			} catch (Exception e) {
				e.printStackTrace();	
				 
			}
		} else {
			System.out.println("Tray icon is not supported");
		}
	}

}
