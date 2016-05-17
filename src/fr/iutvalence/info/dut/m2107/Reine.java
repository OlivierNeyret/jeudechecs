package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements : les quatre diagonales d autant de case que voulues, 
 * idem pour avant, arriere et lateral.
 * @author jacobjul
 */
public class Reine extends Piece {

	/**
	 * Cree une reine de la couleur donnee
	 * @param couleur
	 */
	public Reine(Couleur couleur)
	{
		super(couleur, Type.Reine);
	}

	public ArrayList<Position> deplacement(Plateau plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		boolean diagA=true;
		boolean diagB=true;
		boolean diagC=true;
		boolean diagD=true;
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		for (int i=1;i<=7;i++)
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse())).getCouleur()!=this.getCouleur() && colA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() != Type.None)
					colA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse())).getCouleur()!=this.getCouleur() && colB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() != Type.None)
					colB=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()+i)).getCouleur()!=this.getCouleur() && rowA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()+i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()+i)).recupererType() != Type.None)
					rowA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()-i)).getCouleur()!=this.getCouleur() && rowB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()-i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()-i)).recupererType() != Type.None)
					rowB=false;
			}
			
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+i)).getCouleur()!=this.getCouleur() && diagA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+i)).recupererType() != Type.None)
					diagA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()-i)).getCouleur()!=this.getCouleur() && diagB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()-i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()-i)).recupererType() != Type.None)
					diagB=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-i)).getCouleur()!=this.getCouleur() && diagC)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-i)).recupererType() != Type.None)
					diagC=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()+i)).getCouleur()!=this.getCouleur() && diagD)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()+i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()+i)).recupererType() != Type.None)
					diagD=false;
			}
			
		}
		return deplacement;
	}

	public Type recupererType() {
		// TODO - implement Reine.recupererType
		throw new UnsupportedOperationException();
	}

}