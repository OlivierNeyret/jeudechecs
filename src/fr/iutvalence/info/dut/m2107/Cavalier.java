  package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement: se deplace en L, de deux cases en ligne droite puis de une sur le cote
 * @author lucianor
 *
 */
public class Cavalier extends Piece
{

	/**
	 * Cree un cavalier de la couleur donnee
	 * @param couleur
	 */
	public Cavalier(Couleur couleur)
	{
		super(couleur,Type.Cavalier);
	}

	public ArrayList<Position> deplacement(Plateau plateau)
	{
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int j=2;
		for (int i=1;i<=2;i++)
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+j)).getCouleur()!=this.getCouleur())
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+j));
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-j,plateau.getCoordonateOfPiece(this).getAbscisse()+i)).getCouleur()!=this.getCouleur())
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-j,plateau.getCoordonateOfPiece(this).getAbscisse()+i));
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-j)).getCouleur()!=this.getCouleur())
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-j));
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+j,plateau.getCoordonateOfPiece(this).getAbscisse()-i)).getCouleur()!=this.getCouleur())
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+j,plateau.getCoordonateOfPiece(this).getAbscisse()-i));
			j=j-1;
		}
		return deplacement;
	}

	public Type recupererType()
	{
		// TODO - implement Cavalier.recupererType
		throw new UnsupportedOperationException();
	}

}