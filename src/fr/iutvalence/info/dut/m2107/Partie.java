package fr.iutvalence.info.dut.m2107;

/**
 * Une partie d'echecs.
 * 
 * @author olivier
 *
 */

public class Partie
{

	/**
	 * Le joueur qui joue les blancs
	 */
	private Joueur blanc;
	/**
	 * Le joueur qui joue les noirs
	 */
	private Joueur noir;
	/**
	 * Le plateau de la partie
	 */
	private Plateau plateau;

	/**
	 * Creer une partie a deux joueurs humains
	 */
	public Partie()
	{
		this.blanc = new Joueur(Couleur.Blanc);
		this.noir = new Joueur(Couleur.Noir);
		this.plateau = new Plateau();
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
	public Partie(Couleur couleurJoueur, Difficulte difficulteChoisie)
	{
		if (couleurJoueur == Couleur.Blanc)
		{
			this.blanc = new Joueur(Couleur.Blanc);
			this.noir = new IA(difficulteChoisie);
		} else
		{
			this.noir = new Joueur(Couleur.Noir);
			this.blanc = new IA(difficulteChoisie);
		}
		this.plateau = new Plateau();
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
	public Plateau getPlateau()
	{
		// TODO Auto-generated method stub
		return this.plateau;
	}

	/**
	 * Le deroulement de la partie
	 */
	public void jouer()
	{
		int nombreDeCoups = 0;
		IHM_Joueur ihm = new IHM_Joueur(this);
		while (this.verifierConditionsVictoire() == false)
		{
			Position pieceABouger;
			ihm.displayBoard();
			if(nombreDeCoups%2==0) //Le tour des blancs
			{
				System.out.println("Coup des blancs, choisissez une pi�ce � d�placer :");
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
		System.out.println(plateau.getPieceJoueur(blanc));
	}
}