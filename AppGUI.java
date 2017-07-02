package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.List;
import java.util.LinkedList;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class AppGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFilterAttendance = new JMenu("Filter Attendance");
		menuBar.add(mnFilterAttendance);
		
		JMenuItem mntmBelow = new JMenuItem("Below 90%");
		mnFilterAttendance.add(mntmBelow);
		
		JMenuItem mntmBelow_1 = new JMenuItem("Below 80%");
		mnFilterAttendance.add(mntmBelow_1);
		
		JMenuItem mntmBelow_2 = new JMenuItem(" Below 70%");
		mnFilterAttendance.add(mntmBelow_2);
		
		JMenuItem mntmBelow_3 = new JMenuItem("Below 60%");
		mnFilterAttendance.add(mntmBelow_3);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmChangeUsername = new JMenuItem("Change UserName");
		mnSettings.add(mntmChangeUsername);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mnSettings.add(mntmChangePassword);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		
		
		
		Panel panel_1 = new Panel();
		frame.getContentPane().add(panel_1,BorderLayout.EAST);
		//list.setBounds(10,10,180,180);
		List list_1=new List();
		//list_1.setBounds(10,10,180,180);
		int i;
		List list=new List();
		
		Moodle m=new Moodle("pankhudisb","pankhudisb");		//username and password to be replaced with required one.
		LinkedList<String> a= m.fetchAttendance();
		for(i=0;i<a.size();)
		{
				list.add(a.get(i));
				i++;
				list_1.add(a.get(i));
				i++;
		}
		panel.setLayout(new BorderLayout(0, 0));
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(list_1);
		
		
		frame.getContentPane().add(list, BorderLayout.CENTER);
	}
}
