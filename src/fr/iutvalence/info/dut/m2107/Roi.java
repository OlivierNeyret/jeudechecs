package fr.iutvalence.info.dut.m2107;
/**
 * Deplacements: 	1 case toute direction 
 * 					si echec le roi doit etre prot�g�
 * 					si plus de roi partie fini
 * 					si pat egalit�
 * @author pasquiop
 *
 */
public class Roi extends Piece {

	/**
	 * Cree un roi de la couleur donnee
	 * @param couleur
	 */
	public Roi(Couleur couleur)
	{
		super(couleur, Type.Roi);
	}

	public Deplacement[] deplacement() {
		// TODO - implement Roi.deplacement
		throw new UnsupportedOperationException();
	}

	public Type recupererType() {
		// TODO - implement Roi.recupererType
		throw new UnsupportedOperationException();
	}

}