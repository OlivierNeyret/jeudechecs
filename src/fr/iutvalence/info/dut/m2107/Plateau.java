package fr.iutvalence.info.dut.m2107;

/**
 * represente le plateau de jeu
 * @author pasquiop
 *
 */
public class Plateau
{
	/**
	 * Le plateau du jeu
	 * Contient les references de chaque piece encore en jeu
	 * S il n y a pas de piece sur une case, la case vaut NULL
	 */
	private Piece[][] plateau;
	
	/**
	 * crée un plateau avec les pièces dessus, en position de départ
	 */
	public Plateau()
	{
		this.plateau = new Piece[7][7];
		
		this.plateau[0][7] = new Tour(Couleur.Blanc);
		this.plateau[1][7] = new Cavalier(Couleur.Blanc);
		this.plateau[2][7] = new Fou(Couleur.Blanc);
		this.plateau[4][7] = new Roi(Couleur.Blanc);
		this.plateau[3][7] = new Reine(Couleur.Blanc);
		this.plateau[5][7] = new Fou(Couleur.Blanc);
		this.plateau[6][7] = new Cavalier(Couleur.Blanc);
		this.plateau[7][7] = new Tour(Couleur.Blanc);
		
		for(int i=0;i<8;i++)
		{
			this.plateau[i][6]= new Pion(Couleur.Blanc);
		}
		
		this.plateau[0][0] = new Tour(Couleur.Noir);
		this.plateau[1][0] = new Cavalier(Couleur.Noir);
		this.plateau[2][0] = new Fou(Couleur.Noir);
		this.plateau[3][0] = new Roi(Couleur.Noir);
		this.plateau[4][0] = new Reine(Couleur.Noir);
		this.plateau[5][0] = new Fou(Couleur.Noir);
		this.plateau[6][0] = new Cavalier(Couleur.Noir);
		this.plateau[7][0] = new Tour(Couleur.Noir);
		
		for(int i=0;i<8;i++)
		{
			this.plateau[i][1]= new Pion(Couleur.Noir);
		}
		
	}
	
	/**
	 * renvoie la position de la piece passee en param
	 * @param piece la piece que l'on souhaite deplacer
	 * @return la position de la piece a deplacer
	 */
	public Position getCoordonateOfPiece(Piece piece)
	{
		for (int i=0;i<8;i++)
		{
			for (int j=0;j<8;j++)
			{
				if (piece == this.plateau[i][j])
					return (new Position(i, j));
			}
		}
		return null;
	}
	
	/**
	 * renvoie la piece presente a la position donnee ou NULL si vide
	 * @param i est la position qu'on souhaite verifier
	 * @return la piece presente ou NULL
	 */
	public Piece getPieceAtPosition(Position i)
	{
		return (this.plateau[i.getOrdonnee()][i.getAbscisse()]);
	}
}
