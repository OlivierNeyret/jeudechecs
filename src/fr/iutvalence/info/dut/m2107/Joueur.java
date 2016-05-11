package fr.iutvalence.info.dut.m2107;

/**
 * Cette classe represente les actions possibles pour un joueur
 * 
 * @author jacobjul
 */
public class Joueur
{
	/**
	 * Constante contenant le nombre maximal de piece de chaque joueur
	 */
	private final static int nombreDePieces = 16;
	
	/**
	 * Represente toutes les pieces que possede le joueur
	 */
	protected Piece pieceDuJoueur[] = new Piece[nombreDePieces];
	private Couleur couleur;
	
	/**
	 * Creer un joueur avec les pieces par defaut, de la couleur choisie
	 * @param couleur0 La couleur choisie par le joueur
	 */
	public Joueur(Couleur couleur0)
	{	
		this.couleur = couleur0;
	}

	/**
	 * Choix de la piece a déplacer par le joueur
	 * 
	 * @param piece La piece choisie par le joueur
	 */
	public void choisirPiece(Piece piece)
	{
		// TODO
	}

	/**
	 * Choix du deplacement par le joueur
	 * 
	 * @param piece
	 *            est la piece que l'on souhaite deplacer
	 * @param deplacement
	 *            est le deplacement voulu pour la piece choisi parmis les déplacements posibbles definis dans la pièce.
	 */
	public void deplacer(Piece piece, Position deplacement)
	{
		// TODO - implement Joueur.deplacer
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Donne le nombre max de piece du joueur
	 * @return Le nombre de piece max du joueur
	 */
	public int getNombreDePieces()
	{
		return nombreDePieces;
	}

}