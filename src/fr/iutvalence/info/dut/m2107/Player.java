package fr.iutvalence.info.dut.m2107;

/**
 * Cette classe represente les actions possibles pour un joueur
 * 
 * @author jacobjul
 */
public class Player
{
	/**
	 * La couleur du joueur
	 */
	private PieceColor color;

	/**
	 * Creer un joueur avec les pieces par defaut, de la couleur choisie
	 * 
	 * @param color
	 *            La couleur choisie par le joueur
	 */
	public Player(PieceColor color)
	{
		this.color = color;
	}

	/**
	 * Renvoie la couleur du joueur
	 * 
	 * @return la couleur du joueur
	 */
	public PieceColor getColor()
	{
		return this.color;
	}
}