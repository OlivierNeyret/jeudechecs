package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements: 	1 case toute direction 
 * 					si echec le roi doit etre protege
 * 					si plus de roi partie fini
 * 					si pat egalite
 * @author pasquiop
 *
 */
public class King extends Piece {

	/**
	 * Cree un roi de la couleur donnee
	 * @param couleur
	 */
	public King(Color couleur)
	{
		super(couleur, Type.KING);
	}

	public ArrayList<Position> deplacement(Board plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		
		
		try
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+1,plateau.getCoordonateOfPiece(this).getAbscissa()+1)).getColor()!=this.getColor() && plateau.isCheck(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+1,plateau.getCoordonateOfPiece(this).getAbscissa()+1),this.getColor()))
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+1,plateau.getCoordonateOfPiece(this).getAbscissa()+1));
		} catch (PositionOutOfBoardException e)
		{
		}
		try
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+1,plateau.getCoordonateOfPiece(this).getAbscissa()-1)).getColor()!=this.getColor() && plateau.isCheck(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+1,plateau.getCoordonateOfPiece(this).getAbscissa()-1),this.getColor()))
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+1,plateau.getCoordonateOfPiece(this).getAbscissa()-1));
		} catch (PositionOutOfBoardException e)
		{	
		}
		try
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-1,plateau.getCoordonateOfPiece(this).getAbscissa()+1)).getColor()!=this.getColor() && plateau.isCheck(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-1,plateau.getCoordonateOfPiece(this).getAbscissa()+1),this.getColor()))
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-1,plateau.getCoordonateOfPiece(this).getAbscissa()+1));
		} catch (PositionOutOfBoardException e)
		{
		}
		try
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-1,plateau.getCoordonateOfPiece(this).getAbscissa()-1)).getColor()!=this.getColor() && plateau.isCheck(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-1,plateau.getCoordonateOfPiece(this).getAbscissa()-1),this.getColor()))
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-1,plateau.getCoordonateOfPiece(this).getAbscissa()-1));
		} catch (PositionOutOfBoardException e)
		{
		}
		
		int j=1;
		for (int i =0;i<=1;i++)
		{
			try
			{
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa()+j)).getColor()!=this.getColor() && plateau.isCheck(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa()+j),this.getColor()))
					deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa()+j));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-i,plateau.getCoordonateOfPiece(this).getAbscissa()-j)).getColor()!=this.getColor() && plateau.isCheck(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa()+j),this.getColor()))
					deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-i,plateau.getCoordonateOfPiece(this).getAbscissa()-j));
			} catch (PositionOutOfBoardException e)
			{
			}
			j=j-1;
		}
		
		
		return deplacement;
	}

	public Type getType() {
		// TODO - implement Roi.recupererType
		throw new UnsupportedOperationException();
	}

}