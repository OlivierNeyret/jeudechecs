package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

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
	 * cree un plateau avec les pieces dessus, en position de depart
	 */
	public Plateau()
	{
		this.plateau = new Piece[8][8];
		
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
			this.plateau[i][6]= new Pion(Couleur.Blanc, Type.Pion);
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
			this.plateau[i][1]= new Pion(Couleur.Noir, Type.Pion);
		}
		for(int i=0;i<8;i++)
		{
			for(int j=2;j<6;j++)
			{
				this.plateau[i][j] = new Pion(Couleur.None, Type.None);
			}
		}
	}
	
	/**
	 * Cree un plateau a partir d'un tableau de pieces donne
	 * @param tabP Le tableau de pieces
	 */
	public Plateau(Piece[][] tabP)
	{
		this.plateau=tabP;
	}

	/**
	 * @param piece La piece qu el'on veut deplacer
	 * @param positionDep La position où l'on veut deplacer la piece
	 * @return Le plateau avec le deplacement effectué
	 */
	public Plateau emulateDeplacement(Piece piece, Position positionDep)
	{
		Piece[][] tabP = this.plateau;
		int x1 = positionDep.getAbscisse();
		int y1 = positionDep.getOrdonnee();
		int x2 = this.getCoordonateOfPiece(piece).getAbscisse();
		int y2 = this.getCoordonateOfPiece(piece).getOrdonnee();
		tabP[x2][y2]= new Pion(Couleur.None, Type.None);
		tabP[x1][y1]= piece;
		
		Plateau p1 = new Plateau(tabP);
		return p1;
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

	/**
	 * Donne un liste de Piece contenant les pieces restantes du joueur passe en parametre
	 * @param joueur le joueur pour lequel on veut recuperer ses pieces
	 * @return une liste de Piece contenant les pieces restantes du joueur passe en parametre
	 */
	public ArrayList<Piece> getPieceJoueur(Joueur joueur)
	{
		ArrayList<Piece> pieceJoueur = new ArrayList<Piece>();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(this.plateau[i][j].getCouleur()==joueur.getCouleur())
					pieceJoueur.add(this.plateau[i][j]);
			}
		}
		return pieceJoueur;
	}
	
	/**
	 * Recupere le roi de la couleur donnee
	 * @param couleur La couleur du roi que l'on cherche
	 * @return Le roi de la couleur donnee
	 */
	public Piece getKing(Couleur couleur)
	{
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(this.plateau[i][j].recupererType()==Type.Roi && this.plateau[i][j].getCouleur()==couleur){
					return (this.plateau[i][j]);
				}
					
			}
		}
		return null;
	}
	
	/**
	 * Affiche le plateau avec les pieces en ASCII
	 */
	public String toString()
	{
		String result = "";
		for (int row = 0; row < 8; row++)
		{
			for (int column = 0; column < 8; column++)
			{
				result += this.plateau[column][row].toString();
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Verifie si la position donnee est en echec pour le roi de la couleur donnee
	 * @param position La posiition sur laquelle on veut tester l'echec
	 * @param couleur La couleur du roi sur lequel on veut tester l'echec
	 * @return true si la position est en echec pour le roi de la couleur donnee, false sinon
	 */
	public boolean estEnEchec(Position position, Couleur couleur)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
