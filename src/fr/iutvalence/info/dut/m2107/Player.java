package fr.iutvalence.info.dut.m2107;

/**
 * Cette classe represente les actions possibles pour un joueur
 * 
 * @author jacobjul
 */
public class Player
{
	private Color color;

	/**
	 * Creer un joueur avec les pieces par defaut, de la couleur choisie
	 * 
	 * @param color
	 *            La couleur choisie par le joueur
	 */
	public Player(Color color)
	{
		this.color = color;
	}

	/**
	 * Choix de la piece a deplacer par le joueur (lien avec IHM)
	 * 
	 * @param position
	 *            La position de la piece choisie par le joueur
	 */
	public void pickPiece(Position position)
	{
		// TODO
	}

	/**
	 * Choix du deplacement par le joueur
	 * 
	 * @param piece
	 *            est la piece que l'on souhaite deplacer
	 * @param deplacement
	 *            est le deplacement voulu pour la piece choisi parmis les
	 *            d�placements posibbles definis dans la pi�ce.
	 */
	public void move(Piece piece, Position deplacement)
	{
		// TODO - implement Joueur.deplacer
		throw new UnsupportedOperationException();
	}

	/**
	 * Renvoie la couleur du joueur
	 * 
	 * @return la couleur du joueur
	 */
	public Color getColor()
	{
		return this.color;
	}
}