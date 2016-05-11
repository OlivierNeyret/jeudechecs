package fr.iutvalence.info.dut.m2107;

/**
 * Deplacement: se deplace en ligne droite d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Tour extends Piece {

	/**
	 * Cree une tour de la couleur donnee
	 * @param couleur
	 */
	public Tour(Couleur couleur)
	{
		super(couleur, Type.Tour);
	}

	public Deplacement[] deplacement() {
		// TODO - implement Tour.deplacement
		throw new UnsupportedOperationException();
	}

	public Type recupererType() {
		// TODO - implement Tour.recupererType
		throw new UnsupportedOperationException();
	}

}