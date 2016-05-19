package fr.iutvalence.info.dut.m2107;

/**
 * Une partie d'echecs.
 * 
 * @author olivier
 *
 */

public class Game
{

	/**
	 * Le joueur qui joue les blancs
	 */
	private Player white;
	/**
	 * Le joueur qui joue les noirs
	 */
	private Player black;
	/**
	 * Le plateau de la partie
	 */
	private Board plateau;

	/**
	 * Creer une partie a deux joueurs humains
	 */
	public Game()
	{
		this.white = new Player(Color.WHITE);
		this.black = new Player(Color.BLACK);
		this.plateau = new Board();
	}

	/**
	 * Creer une partie contre l ordi
	 * 
	 * @param couleurJoueur
	 *            la couleur choisie par le joueur humain
	 * @param difficulteChoisie
	 *            la difficulte choisie par le joueur humain
	 * 
	 */
	public Game(Color couleurJoueur, Difficulty difficulteChoisie)
	{
		if (couleurJoueur == Color.WHITE)
		{
			this.white = new Player(Color.WHITE);
			this.black = new AI(difficulteChoisie);
		} else
		{
			this.black = new Player(Color.BLACK);
			this.white = new AI(difficulteChoisie);
		}
		this.plateau = new Board();
	}

	/**
	 * Affiche tous les deplacements possibles pour une piece.
	 * 
	 * @param Piece
	 *            Indique la piece sur laquelle on veut connaitre ses
	 *            deplacements.
	 */
	public void afficherDeplacementsPossible(int Piece)
	{
		// TODO - implement Partie.AfficherDeplacementsPossible
		throw new UnsupportedOperationException();
	}

	/**
	 * Verifie si un joueur a gagne
	 * 
	 * @return renvoie true si le joueur a gagne, false sinon
	 */
	public boolean verifierConditionsVictoire()
	{
		// TODO - implement Partie.VerifierConditionsVictoire
		throw new UnsupportedOperationException();
	}

	/**
	 * Transforme un pion qui atteindrait la derniere ligne du plateau en une
	 * reine.
	 * 
	 * @param Pion
	 *            Le pion qui doit etre transforme
	 */
	public void promotion(int Pion)
	{
		// TODO - implement Partie.Promotion
		throw new UnsupportedOperationException();
	}

	/**
	 * Renvoie le plateau de la partie
	 * 
	 * @return Le plateau de la partie
	 */
	public Board getPlateau()
	{
		// TODO Auto-generated method stub
		return this.plateau;
	}

	/**
	 * Le deroulement de la partie
	 */
	public void play()
	{
		int nombreDeCoups = 0;
		IHM_Player ihm = new IHM_Player(this);
		while (this.verifierConditionsVictoire() == false)
		{
			Position pieceABouger;
			ihm.displayBoard();
			if(nombreDeCoups%2==0) //Le tour des blancs
			{
				System.out.println("Coup des blancs, choisissez une pièce à déplacer :");
				pieceABouger = ihm.askPosition();
				//Demander coup
				//Afficher les deplcaments possibles
				//verifier validite du coup
				//effectuer le coup
			}
			else //Le tour des noirs
			{
				
			}
			nombreDeCoups++;
		}
		System.out.println(plateau.getPiecePlayer(Color.WHITE));
	}
}