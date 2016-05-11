package fr.iutvalence.info.dut.m2107;

/**
 * D�placement : pi�ce pouvant se d�placer en diagonal, d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Fou extends Piece {


	/**
	 * Cree un fou de la couleur donnee
	 * @param couleur
	 */
	public Fou(Couleur couleur)
	{
		super(couleur, Type.Fou);
	}

	public Position[] deplacement() {
		// TODO - implement Fou.deplacement
		
		throw new UnsupportedOperationException();
	}

	public Type recupererType() {
		// TODO - implement Fou.recupererType
		throw new UnsupportedOperationException();
	}

}