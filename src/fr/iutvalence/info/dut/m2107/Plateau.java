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
		
		this.plateau[0][0] = new Tour(Couleur.Blanc);
		this.plateau[0][1] = new Cavalier(Couleur.Blanc);
		this.plateau[0][2] = new Fou(Couleur.Blanc);
		this.plateau[0][4] = new Roi(Couleur.Blanc);
		this.plateau[0][3] = new Reine(Couleur.Blanc);
		this.plateau[0][5] = new Fou(Couleur.Blanc);
		this.plateau[0][6] = new Cavalier(Couleur.Blanc);
		this.plateau[0][7] = new Tour(Couleur.Blanc);
		
		for(int i=0;i<8;i++)
		{
			this.plateau[1][i]= new Pion(Couleur.Blanc);
		}
		
		this.plateau[7][0] = new Tour(Couleur.Noir);
		this.plateau[7][1] = new Cavalier(Couleur.Noir);
		this.plateau[7][2] = new Fou(Couleur.Noir);
		this.plateau[7][3] = new Roi(Couleur.Noir);
		this.plateau[7][4] = new Reine(Couleur.Noir);
		this.plateau[7][5] = new Fou(Couleur.Noir);
		this.plateau[7][6] = new Cavalier(Couleur.Noir);
		this.plateau[7][7] = new Tour(Couleur.Noir);
		
		for(int i=0;i<8;i++)
		{
			this.plateau[6][i]= new Pion(Couleur.Noir);
		}
		
	}
	
	/**
	 * @param piece
	 * @return
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
}
