package fr.iutvalence.info.dut.m2107;
/**
 * Deplacements : les quatre diagonales d autant de case que voulues, 
 * idem pour avant, arrière et lateral.
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

	public Position[] deplacement() {
		// TODO - implement Reine.deplacement
		throw new UnsupportedOperationException();
	}

	public Type recupererType() {
		// TODO - implement Reine.recupererType
		throw new UnsupportedOperationException();
	}

}