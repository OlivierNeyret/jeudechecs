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
		int x = plateau.getCoordonateOfPiece(this).getOrdonnee();
		int y = plateau.getCoordonateOfPiece(this).getAbscisse();
		for (int i=1;i<=2;i++)
		{
			if (plateau.getPieceAtPosition(new Position(x+i,y+j)).getCouleur()!=this.getCouleur())
			{
				plateau.emulateDeplacement(this, new Position(x+i,y+j)).estEnEchec(plateau.getKing(couleur), couleur)
				deplacement.add(new Position(x+i,y+j));
			}
			if (plateau.getPieceAtPosition(new Position(x-j,y+i)).getCouleur()!=this.getCouleur())
			{
				deplacement.add(new Position(x-j,y+i));
				
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y-j)).getCouleur()!=this.getCouleur())
			{
				deplacement.add(new Position(x-i,y-j));
				
			}
			if (plateau.getPieceAtPosition(new Position(x+j,y-i)).getCouleur()!=this.getCouleur())
			{
				deplacement.add(new Position(x+j,y-i));
				
			}
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