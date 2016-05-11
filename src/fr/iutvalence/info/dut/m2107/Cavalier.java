  package fr.iutvalence.info.dut.m2107;
  
/**
 * Deplacement: se deplace en L, de deux cases en ligne droite puis de une sur le coté
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

	public Deplacement[] deplacement()
	{

		// TODO - implement Cavalier.deplacement
		throw new UnsupportedOperationException();
	}

	public Type recupererType()
	{
		// TODO - implement Cavalier.recupererType
		throw new UnsupportedOperationException();
	}

}