package fr.iutvalence.info.dut.m2107;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Window extends JFrame
{
	private static int couleur=0;

	private JMenuBar menuBar = new JMenuBar();

	private JMenu menu1 = new JMenu("Fichier");

	private JMenu menu2 = new JMenu("Options");

	private JMenu menu2_1 = new JMenu("Couleur");

	private JMenuItem item1_1 = new JMenuItem("Nouvelle Partie");

	private JMenuItem item1_2 = new JMenuItem("Fermer");

	private JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("Noir & Blanc");

	private JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Doge Game Company Edition");
	

	public Window()
	{
		// MENU//////////////////////////////////////////////////////////////
		this.setSize(500, 500);

		this.setTitle("Jeu d'échecs");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setLocationRelativeTo(null);
		

		// On initialise nos menus

		this.menu1.add(item1_1);

		this.menu2.add(item1_1);

		// On met nos radios dans un ButtonGroup

		ButtonGroup bg = new ButtonGroup();

		bg.add(rb1);

		bg.add(rb1);

		// On présélectionne la première radio

		rb1.setSelected(true);

		// On ajoute les éléments dans notre sous-menu

		this.menu2_1.add(rb1);

		this.menu2_1.add(rb2);

		// Ajout du sous-menu dans notre menu

		this.menu2.add(this.menu2_1);

		item1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				System.exit(0);
			}
		});
		
		item1_1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{

				game();
			}
		});

		/*this.menu1.add(item1_1);
		this.menu1.add(item1_2);
		this.menuBar.add(menu1);
		this.menuBar.add(menu2);
		this.setJMenuBar(menuBar);*/
		
		//CONTENT//////////////////////////////////////////////////////

		introduction();
		
		//VISIBLE//////////////////////////////////////////////////////
		this.setVisible(true);

	}
	
	

	private void introduction(){
		JPanel intro = new JPanel();
	
		JLabel title = new JLabel("Chess Game");
		JLabel company = new JLabel("Doge Game Company");
		JButton start = new JButton("Start");
		JButton exit = new JButton("Exit");
		
		intro.add(title);
		intro.add(company);
		intro.add(start);
		intro.add(exit);
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				game();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});

		
		this.add(intro);
	}
	
	public void game(){
		this.getContentPane().removeAll();
	    
		 Object[][] data = {{1,"","","","","","","",""},
		 					{2,"", "","","","","","",""},
		 					{3,"","","","","","","",""},
		 					{4,"", "","","","","","",""},
		 					{5,"","","","","","","",""},
		 					{6,"", "","","","","","",""},
		 					{7,"","","","","","","",""},
		 					{8,"", "","","","","","",""}};

		 //Les titres des colonnes
	    String[]  title = {"","A", "", "C","D", "E", "F","G", "H"};
	    JTable plateau = new JTable(data, title);
	    plateau.getTableHeader().setReorderingAllowed(false);
	    JScrollPane scroll=new JScrollPane(plateau);
	    plateau.setDefaultRenderer(Object.class, new Cell());
	    
	    for(int i=0; i<8 ; i++ )
	        plateau.setRowHeight(i,100);
	    
	    TableColumn column = null;
	    for (int i = 0; i < 9; i++) {
	        column = plateau.getColumnModel().getColumn(i);
	        if (i == 0) {
	            column.setPreferredWidth(1); //third column is bigger
	        } else {
	            column.setPreferredWidth(50);
	        }
	    }
	    this.getContentPane().add(scroll, BorderLayout.CENTER);

	    
		this.repaint();
		this.revalidate();

	    this.setVisible(true);
	}
}