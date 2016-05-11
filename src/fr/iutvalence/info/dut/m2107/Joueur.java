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
		this.pieceDuJoueur[0] = new Tour();
		this.pieceDuJoueur[1] = new Cavalier();
		this.pieceDuJoueur[2] = new Fou();
		this.pieceDuJoueur[3] = new Roi();
		this.pieceDuJoueur[4] = new Reine();
		this.pieceDuJoueur[5] = new Fou();
		this.pieceDuJoueur[6] = new Cavalier();
		this.pieceDuJoueur[7] = new Tour();
		int i;
		for(i=nombreDePieces/2;i<nombreDePieces;i++)
		{
			this.pieceDuJoueur[i]= new Pion();
		}
		this.couleur = couleur0;
	}

	/**
	 * Choix de la piece par le joueur
	 * 
	 * @param piece
	 *            La piece choisie par le joueur
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
	 *            est le deplacement voulu pour la piece
	 */
	public void deplacer(Piece piece, Deplacement deplacement)
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