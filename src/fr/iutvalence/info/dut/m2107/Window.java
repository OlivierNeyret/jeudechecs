package fr.iutvalence.info.dut.m2107;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;

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

import com.sun.glass.events.MouseEvent;

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
	

	public Window(Board gameboard)
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

				game(gameboard);
			}
		});

		this.menu1.add(item1_1);
		this.menu1.add(item1_2);
		this.menuBar.add(menu1);
		this.menuBar.add(menu2);
		this.setJMenuBar(menuBar);
		
		//CONTENT//////////////////////////////////////////////////////

		introduction(gameboard);
		this.setResizable(true);
		
		//VISIBLE//////////////////////////////////////////////////////
		this.setVisible(true);

	}
	
	

	private void introduction(Board gameboard){
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
				game(gameboard);
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
	
	public void game(Board gameboard){
		this.getContentPane().removeAll();
	    
		 Object[][] data = {{1,"","","","","","","","",1},
		 					{2,"", "","","","","","","",2},
		 					{3,"","","","","","","","",3},
		 					{4,"", "","","","","","","",4},
		 					{5,"","","","","","","","",5},
		 					{6,"", "","","","","","","",6},
		 					{7,"","","","","","","","",7},
		 					{8,"", "","","","","","","",8}};

		 //Les titres des colonnes
	    String[]  title = {"","A", "B", "C","D", "E", "F","G", "H",""};
	    JTable plateau = new JTable(data, title);
	    plateau.getTableHeader().setReorderingAllowed(false);
	    JScrollPane scroll=new JScrollPane(plateau);
	    plateau.setDefaultRenderer(Object.class, new Cell());
	    
	    
	    
	    for(int i=0; i<8 ; i++ )
	        plateau.setRowHeight(i,100);
	    
	    TableColumn column = null;
	    for (int i = 0; i < 10; i++) 
	    {
	        column = plateau.getColumnModel().getColumn(i);
	       
	            column.setPreferredWidth(100);
	    }
	    this.getContentPane().add(scroll, BorderLayout.CENTER);

	    ImageIcon CN = new ImageIcon("CN");
	    ImageIcon TN = new ImageIcon("TN");
	    ImageIcon FN = new ImageIcon("FN");
	    ImageIcon RoiN = new ImageIcon("RoiN");
	    ImageIcon RN = new ImageIcon("RN");
	    ImageIcon PN = new ImageIcon("PN");
	    
	    ImageIcon CB = new ImageIcon("CB");
	    ImageIcon TB = new ImageIcon("TB");
	    ImageIcon FB = new ImageIcon("FB");
	    ImageIcon RoiB = new ImageIcon("RoiB");
	    ImageIcon RB = new ImageIcon("RB");
	    ImageIcon PB = new ImageIcon("PB");
	    
	    //setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Led_Bleu_Fix.gif")));
	    
	    //plateau.setValueAt(icon, 0, 1);
	    
	    for(int i=0; i<8; i++)
	    {
	    	for(int j=0;j<8;j++)
	    	{
	    		Piece current_piece;
				try
				{
					current_piece = gameboard.getPieceAtPosition(new Position(i,j));
					
					if (current_piece.getColor() == PieceColor.WHITE)
		    		{
		    			if(current_piece.getType()==PieceType.KNIGHT)
		    			{
		    				plateau.setValueAt(CB, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.ROOK)
		    			{
		    				plateau.setValueAt(TB, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.BISHOP)
		    			{
		    				plateau.setValueAt(FB, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.KING)
		    			{
		    				plateau.setValueAt(RoiB, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.QUEEN)
		    			{
		    				plateau.setValueAt(RB, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.PAWN)
		    			{
		    				plateau.setValueAt(PB, j, i+1);
			    		}
		    		}
		    		
		    		
		    		
		    		if (current_piece.getColor() == PieceColor.BLACK)
		    		{
		    			if(current_piece.getType()==PieceType.KNIGHT)
		    			{
		    				plateau.setValueAt(CN, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.ROOK)
		    			{
		    				plateau.setValueAt(TN, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.BISHOP)
		    			{
		    				plateau.setValueAt(FN, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.KING)
		    			{
		    				plateau.setValueAt(RoiN, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.QUEEN)
		    			{
		    				plateau.setValueAt(RN, j, i+1);
			    		}
		    			if(current_piece.getType()==PieceType.PAWN)
		    			{
		    				plateau.setValueAt(PN, j, i+1);
			    		}
		    		}
				} 
				catch (PositionOutOfBoardException e)
				{
					e.printStackTrace();
				}
	    	}
	    }
	    
		this.repaint();
		this.revalidate();

	    this.setVisible(true);
	    System.out.println("babbabe");
		plateau.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		      int row = plateau.getSelectedRow();
		      int column = plateau.getSelectedColumn()-1;
		      try
			{
				if (row < 9 && row >=0 && column <9 && column >=0 && gameboard.getPieceAtPosition(new Position(column,row)).getType()!=PieceType.NONE)
				  { 
						ArrayList<Position> deplacement = (gameboard.getPieceAtPosition(new Position(column,row)).deplacement(gameboard, true)); 
						while(deplacement.remove(0)!= null)
						{
							
						}
				  }
			} catch (PositionOutOfBoardException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
	    	      
	    	  }
	    	});
	}
}