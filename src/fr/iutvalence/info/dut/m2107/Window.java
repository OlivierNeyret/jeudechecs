package fr.iutvalence.info.dut.m2107;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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


/**
 * la classe qui crée et gère la fenêtre
 * @author pasquiop
 *
 */
@SuppressWarnings("serial")
public class Window extends JFrame
{
	
	/**
	 * représente la barre de menu
	 */
	private JMenuBar menuBar = new JMenuBar();

	/**
	 * le sous menu
	 */
	private JMenu menu1 = new JMenu("Fichier");

	/**
	 * premier élément du sous menu
	 */
	private JMenuItem item1_1 = new JMenuItem("Nouvelle Partie");

	/**
	 * deuxième élément du sous menu
	 */
	private JMenuItem item1_2 = new JMenuItem("Fermer");

	

	/**
	 * méthode initialisant le menu et lançant l'écran titre (la méthode "introduction")
	 * @param gameboard : le tableau dans lequel les pièces sont stockées
	 */
	@SuppressWarnings({ "static-access", "unqualified-field-access" })
	public Window(Board gameboard)
	{
		// MENU//////////////////////////////////////////////////////////////
		this.setSize(500, 500);

		this.setTitle("Jeu d'échecs");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setExtendedState(this.MAXIMIZED_BOTH);

		this.setSize((int)getToolkit().getScreenSize().getWidth(), ((int)getToolkit().getScreenSize().getHeight() - 2));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		

		// On initialise nos menus

		this.menu1.add(item1_1);


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

				option(gameboard);
			}
		});

		this.menu1.add(item1_1);
		this.menu1.add(item1_2);
		this.menuBar.add(menu1);
		this.setJMenuBar(menuBar);
		
		//CONTENT//////////////////////////////////////////////////////

		introduction(gameboard);
		this.setResizable(false);
		
		//VISIBLE//////////////////////////////////////////////////////
		this.setVisible(true);

	}
	
	/**
	 * cette méthode gère l'affichage du choix des options dans différents panels
	 * @param gameboard : le tableau qui stocke les pièces
	 */
	private void option(Board gameboard){
		this.getContentPane().removeAll();
		JPanel joueur = new JPanel() ;
		JPanel AIpanel = new JPanel() ;
		JPanel couleur = new JPanel() ;
		JPanel lancerpanel = new JPanel() ;
		
		JRadioButtonMenuItem j1 = new JRadioButtonMenuItem("1 Joueur");
		JRadioButtonMenuItem j2 = new JRadioButtonMenuItem("2 Joueurs");
		
		JRadioButtonMenuItem AI1 = new JRadioButtonMenuItem("Facile");
		JRadioButtonMenuItem AI2 = new JRadioButtonMenuItem("Normal");
		JRadioButtonMenuItem AI3 = new JRadioButtonMenuItem("Difficile");
		
		JRadioButtonMenuItem BN1 = new JRadioButtonMenuItem("Blanc");
		JRadioButtonMenuItem BN2 = new JRadioButtonMenuItem("Noir");
		
		JButton lancer = new JButton("Lancer Partie");
		
		ButtonGroup j = new ButtonGroup();
		j.add(j1);
		j.add(j2);
		joueur.add(j1);
		joueur.add(j2);
		joueur.setBounds(500, 200, 100, 100);
		this.add(joueur);
		j1.setSelected(true);
		
		ButtonGroup AI = new ButtonGroup();
		AI.add(AI1);
		AI.add(AI2);
		AI.add(AI3);
		AIpanel.add(AI1);
		AIpanel.add(AI2);
		AIpanel.add(AI3);
		AIpanel.setBounds(500, 300, 100, 100);
		this.add(AIpanel);
		AI1.setSelected(true);
		
		ButtonGroup BN = new ButtonGroup();
		BN.add(BN1);
		BN.add(BN2);
		couleur.add(BN1);
		couleur.add(BN2);
		couleur.setBounds(500, 400, 100, 100);
		this.add(couleur);
		BN1.setSelected(true);
		
		lancerpanel.add(lancer);
		lancerpanel.setBounds(500, 500, 100, 100);
		this.add(lancerpanel);
	    
		
		lancer.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				if(j2.isSelected())
				{
					game(gameboard);
					new Game();
				}
				else
				{
					Difficulty difficulty = null;
					if(AI1.isSelected())
						difficulty=Difficulty.EASY;
					if(AI2.isSelected())
						difficulty=Difficulty.MIDDLE;
					if(AI3.isSelected())
						difficulty=Difficulty.DIFFICULT;
					
					PieceColor color = null;
					if(BN1.isSelected())
						color=PieceColor.WHITE;
					if(BN2.isSelected())
						color=PieceColor.BLACK;
					
					
					new Game(color,difficulty);
					
					game(gameboard);
				}
			}
		});

		this.repaint();
		this.revalidate();
		
	}

	/**
	 * cette méthode affiche l'écran titre, d'ou l'on peut lancer une partie ou quitter
	 * @param gameboard : le tableau qui stocke les pièces
	 */
	private void introduction(Board gameboard){
		JPanel intro = new JPanel();
		JPanel intro2 = new JPanel();
	
		JLabel title = new JLabel("Chess Game");
		JLabel company = new JLabel("Doge Game Company présente:");
		Font font = new Font("Arial",Font.BOLD,12);
		title.setFont(font);
		JButton start = new JButton("Start");
		JButton exit = new JButton("Exit");
		
		start.setBounds(200,200,50,50);
		
		intro.add(company);
		intro.add(title);
		intro2.add(start);
		intro2.add(exit);
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				option(gameboard);
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});

		intro.setBounds(500, 100, 300, 300);
		this.add(intro);
		this.add(intro2);
	}
	
	/**
	 * cette méthode gère l'affichage de l'échiquier, des pièces et affiche les déplacement possible lorsqu'on clique sur une pièce
	 * @param gameboard le tableau qui stocke les pièces
	 */
	public void game(Board gameboard){
		this.getContentPane().removeAll();
	    
		 Object[][] data = {{1,"","","","","","","","",""},
		 					{2,"", "","","","","","","",""},
		 					{3,"","","","","","","","",""},
		 					{4,"", "","","","","","","",""},
		 					{5,"","","","","","","","",""},
		 					{6,"", "","","","","","","",""},
		 					{7,"","","","","","","","",""},
		 					{8,"", "","","","","","","",""}};

		 //Les titres des colonnes
	    String[]  title = {"","A", "B", "C","D", "E", "F","G", "H",""};
	    JTable plateau = new JTable(data, title);
	    
//	    JTable plateau = new JTable(data,title) {
//
//	    	public boolean isCellEditable(int row, int column) {
//
//	    	return false;
//
//	    	}
//
//	    	};
	    plateau.removeEditor();
	    plateau.getTableHeader().setReorderingAllowed(false);
	    JScrollPane scroll=new JScrollPane(plateau);
	    plateau.setDefaultRenderer(Object.class, new Cell(gameboard));//TODO
	    
	    
	    
	    for(int i=0; i<8 ; i++ )
	        plateau.setRowHeight(i,100);
	    
	    TableColumn column = null;
	    for (int i = 0; i < 10; i++) 
	    {
	        column = plateau.getColumnModel().getColumn(i);
	       
	            column.setPreferredWidth(100);
	    }
	    this.getContentPane().add(scroll, BorderLayout.CENTER);
	    
	    
		this.repaint();
		this.revalidate();

	    this.setVisible(true);
		plateau.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) 
		    {
		      int row = plateau.getSelectedRow();
		      int column = plateau.getSelectedColumn()-1;
		      
		      try
		      {
				if (row <=8 && row >=0 && column <=8 && column >=0 )
				 { 	
					if(gameboard.getPieceAtPosition(new Position(column,row)).getType()!=PieceType.NONE)
					{
						plateau.setDefaultRenderer(Object.class, new Cell(gameboard, (gameboard.getPieceAtPosition(new Position(column,row)).deplacement(gameboard, true))));
						
						Piece prev =  gameboard.getBoard()[row][column] ;
						plateau.addMouseListener(new java.awt.event.MouseAdapter() 
						{
						    @Override
						    public void mouseClicked(java.awt.event.MouseEvent evt) 
						    {
						      int newrow = plateau.getSelectedRow();
						      int newcolumn = plateau.getSelectedColumn()-1;
						    
								if (row < 9 && row >=0 && column <9 && column >=0 )
								  { 
									ArrayList<Position> deplacement;
									try
									{
										deplacement = (gameboard.getPieceAtPosition(new Position(column,row)).deplacement(gameboard, true));
										
										if (deplacement.contains(new Position(newrow,newcolumn)) )
										{
											gameboard.getBoard()[newrow][newcolumn] = prev ;
											plateau.setDefaultRenderer(Object.class, new Cell(gameboard));
										}
									} catch (PositionOutOfBoardException e)
									{
										
									} 
								  }
							} 
					    }); 
				  }
				}
						
			} catch (PositionOutOfBoardException e)
			{
				e.printStackTrace();
			}
	     
	    	      
	    	  }
	    	});
		
		
	}
}