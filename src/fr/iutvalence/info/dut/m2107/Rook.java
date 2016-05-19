package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement: se deplace en ligne droite d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Rook extends Piece {

	/**
	 * Cree une tour de la couleur donnee
	 * @param couleur
	 */
	public Rook(Color couleur)
	{
		super(couleur, Type.ROOK);
	}

	public ArrayList<Position> deplacement(Board plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		for (int i=0;i<=7;i++)
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa())).getColor()!=this.getColor() && colA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa()));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()+i,plateau.getCoordonateOfPiece(this).getAbscissa())).getType() != Type.NONE)
					colA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-i,plateau.getCoordonateOfPiece(this).getAbscissa())).getColor()!=this.getColor() && colB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-i,plateau.getCoordonateOfPiece(this).getAbscissa()));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate()-i,plateau.getCoordonateOfPiece(this).getAbscissa())).getType() != Type.NONE)
					colB=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate(),plateau.getCoordonateOfPiece(this).getAbscissa()+i)).getColor()!=this.getColor() && rowA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate(),plateau.getCoordonateOfPiece(this).getAbscissa()+i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate(),plateau.getCoordonateOfPiece(this).getAbscissa()+i)).getType() != Type.NONE)
					rowA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate(),plateau.getCoordonateOfPiece(this).getAbscissa()-i)).getColor()!=this.getColor() && rowB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonate(),plateau.getCoordonateOfPiece(this).getAbscissa()-i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonate(),plateau.getCoordonateOfPiece(this).getAbscissa()-i)).getType() != Type.NONE)
					rowB=false;
			}			
		}
		return deplacement;
	}

	public Type getType() {
		// TODO - implement Tour.recupererType
		throw new UnsupportedOperationException();
	}

}