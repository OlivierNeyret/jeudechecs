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
		// TODO - implement Pion.deplacement
		throw new UnsupportedOperationException();
	}

	public Type recupererType() {
		// TODO - implement Pion.recupererType
		throw new UnsupportedOperationException();
	}

}