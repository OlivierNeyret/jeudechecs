package fr.iutvalence.info.dut.m2107;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Cell extends DefaultTableCellRenderer
{

	private Board board;
	private ArrayList<Position> dep;

	public Cell(Board gameboard)
	{
		this.board=gameboard;
		this.dep=new ArrayList();
	}

	public Cell(Board gameboard, ArrayList<Position> deplacement)
	{
		this.board=gameboard;
		this.dep=deplacement;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column)
	{
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (column == 0 || column==9 )
			cell.setBackground(Color.BLACK);
		else if (row % 2 == 0)
		{
			if (column % 2 == 0)
				cell.setBackground(Color.GRAY);
			if (column % 2 == 1)
				cell.setBackground(Color.WHITE);
			
		}
		else if (row % 2 == 1)
		{
			if (column % 2 == 0)
				cell.setBackground(Color.WHITE);
			if (column % 2 == 1)
				cell.setBackground(Color.GRAY);
		}
		try
		{
			if (column != 0 && column!=9 )
			{
				if (this.dep.contains(new Position(column-1,row )))
				{
					cell.setBackground(Color.BLUE);
				}
			}
		} catch (PositionOutOfBoardException e1)
		{
			e1.printStackTrace();
		}
		
		//couleur piece selected 
		    		Piece current_piece;
					try
					{
						if (column == 0 || column==9 )
						{
							((JLabel) cell).setIcon(new ImageIcon(""));
						}
						else
						{
							current_piece = this.board.getPieceAtPosition(new Position(column-1,row));
							
							if (current_piece.getColor() == PieceColor.WHITE)
				    		{
				    			if(current_piece.getType()==PieceType.KNIGHT)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/CB.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.ROOK)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/TB.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.BISHOP)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/FB.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.KING)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/RB.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.QUEEN)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/DB.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.PAWN)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/PB.gif"));
					    		}
				    		}
							else if (current_piece.getColor() == PieceColor.BLACK)
				    		{
				    			if(current_piece.getType()==PieceType.KNIGHT)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/CN.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.ROOK)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/TN.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.BISHOP)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/FN.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.KING)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/RN.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.QUEEN)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/DN.gif"));
					    		}
				    			if(current_piece.getType()==PieceType.PAWN)
				    			{
				    				((JLabel) cell).setIcon(new ImageIcon("ressources/PN.gif"));
					    		}
				    		}
						} 
						
					}	
					catch (PositionOutOfBoardException e)
					{
						e.printStackTrace();
					}
		return cell;
	}
}