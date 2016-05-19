package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * represente le plateau de jeu
 * @author pasquiop
 *
 */
public class Board
{
	/**
	 * Le plateau du jeu
	 * Contient les references de chaque piece encore en jeu
	 * S il n y a pas de piece sur une case, la case vaut NULL
	 */
	private Piece[][] board;
	
	/**
	 * cree un plateau avec les pieces dessus, en position de depart
	 */
	public Board()
	{
		this.board = new Piece[8][8];
		
		this.board[0][7] = new Rook(Color.WHITE);
		this.board[1][7] = new Knight(Color.WHITE);
		this.board[2][7] = new Bishop(Color.WHITE);
		this.board[4][7] = new King(Color.WHITE);
		this.board[3][7] = new Queen(Color.WHITE);
		this.board[5][7] = new Bishop(Color.WHITE);
		this.board[6][7] = new Knight(Color.WHITE);
		this.board[7][7] = new Rook(Color.WHITE);
		
		for(int i=0;i<8;i++)
		{
			this.board[i][6]= new Pawn(Color.WHITE, Type.PAWN);
		}
		
		this.board[0][0] = new Rook(Color.BLACK);
		this.board[1][0] = new Knight(Color.BLACK);
		this.board[2][0] = new Bishop(Color.BLACK);
		this.board[3][0] = new King(Color.BLACK);
		this.board[4][0] = new Queen(Color.BLACK);
		this.board[5][0] = new Bishop(Color.BLACK);
		this.board[6][0] = new Knight(Color.BLACK);
		this.board[7][0] = new Rook(Color.BLACK);
		
		for(int i=0;i<8;i++)
		{
			this.board[i][1]= new Pawn(Color.BLACK, Type.PAWN);
		}
		for(int i=0;i<8;i++)
		{
			for(int j=2;j<6;j++)
			{
				this.board[i][j] = new Null();
			}
		}
	}
	
	/**
	 * Cree un plateau a partir d'un tableau de pieces donne
	 * @param tabP Le tableau de pieces
	 */
	public Board(Piece[][] tabP)
	{
		this.board=tabP;
	}

	/**
	 * @param piece La piece qu el'on veut deplacer
	 * @param positionDep La position o� l'on veut deplacer la piece
	 * @return Le plateau avec le deplacement effectu�
	 */
	public Board emulateDeplacement(Piece piece, Position positionDep)
	{
		Piece[][] tabP = this.board;
		int x1 = positionDep.getAbscissa();
		int y1 = positionDep.getOrdonate();
		int x2 = this.getCoordonateOfPiece(piece).getAbscissa();
		int y2 = this.getCoordonateOfPiece(piece).getOrdonate();
		tabP[x2][y2]= new Pawn(Color.NONE, Type.NONE);
		tabP[x1][y1]= piece;
		
		Board p1 = new Board(tabP);
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
				if (piece == this.board[i][j])
					try
					{
						return (new Position(i, j));
					} catch (PositionOutOfBoardException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		return (this.board[i.getOrdonate()][i.getAbscissa()]);
	}

	/**
	 * Donne un liste de Piece contenant les pieces restantes du joueur passe en parametre
	 * @param color la couleur du joueur dont on veut recuperer les pieces
	 * @return une liste de Piece contenant les pieces restantes du joueur passe en parametre
	 */
	public ArrayList<Piece> getPiecePlayer(Color color)
	{
		ArrayList<Piece> piecePlayer = new ArrayList<Piece>();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(this.board[i][j].getColor()==color)
					piecePlayer.add(this.board[i][j]);
			}
		}
		return piecePlayer;
	}
	
	/**
	 * Recupere le roi de la couleur donnee
	 * @param color La couleur du roi que l'on cherche
	 * @return Le roi de la couleur donnee
	 */
	public Piece getKing(Color color)
	{
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(this.board[i][j].getType()==Type.KING && this.board[i][j].getColor()==color){
					return (this.board[i][j]);
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
				result += this.board[column][row].toString();
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Verifie si la position donnee est en echec pour le roi de la couleur donnee
	 * @param position La posiition sur laquelle on veut tester l'echec
	 * @param color La couleur du roi sur lequel on veut tester l'echec
	 * @return true si la position est en echec pour le roi de la couleur donnee, false sinon
	 */
	public boolean isCHeck(Position position, Color color)
	{
		int i = 0;
		int j = 0;
		ArrayList<Piece> piecesJ = getPiecePlayer(color.Invertcolor());
		while (i < piecesJ.size())
		{
			while (j < piecesJ.get(i).deplacement(this).size())
			{
				if (piecesJ.get(i).deplacement(this).get(j) == position)
					return true;
				j++;
			}
			i++;
			j = 0;
		}
		return false;
	}
}
