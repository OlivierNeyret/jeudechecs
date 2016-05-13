package fr.iutvalence.info.dut.m2107;
/**
 * Deplacements: 	2 cases avant si non deplac�
 * 					sinon 1 case avant et prend en 1 case diagonale avant
 * @author pasquiop
 *
 */
public class Pion extends Piece {

	/**
	 * Cree un pion de la couleur donnee
	 * @param couleur
	 */
	public Pion(Couleur couleur, Type type)
	{
		super(couleur, type);
	}

	
	public Position[] deplacement() {
		Position deplacement[] = null;
		int i=0;
		if (this.getCouleur()==Couleur.Blanc)
		{
			if (Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse() == 6)
			{
				if (Partie.getPlateau().getPieceAtPosition(new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()+2,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse())) != null)
				{
					deplacement[i]=new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()+2,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse());
					i=i+1;
				}
			}
			if (Partie.getPlateau().getPieceAtPosition(new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()+1,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse())) != null)
			{
				deplacement[i]=new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()+1,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse());
				i=i+1;
			}
		}
		else
		{
			if (Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse() == 1)
			{
				if (Partie.getPlateau().getPieceAtPosition(new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()-2,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse())) != null)
				{
					deplacement[i]=new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()-2,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse());
					i=i+1;
				}
			}
			if (Partie.getPlateau().getPieceAtPosition(new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()-1,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse())) != null)
			{
				deplacement[i]=new Position(Partie.getPlateau().getCoordonateOfPiece(this).getOrdonnee()-1,Partie.getPlateau().getCoordonateOfPiece(this).getAbscisse());
				i=i+1;
			}
		}
		return deplacement;
	}

	public Type recupererType() {
		// TODO - implement Pion.recupererType
		throw new UnsupportedOperationException();
	}

}
