package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * represente le plateau de jeu
 * 
 * @author pasquiop
 *
 */
public class Board implements Cloneable
{
	/**
	 * Le plateau du jeu Contient les references de chaque piece encore en jeu S
	 * il n y a pas de piece sur une case, la case vaut la piece Null
	 */
	private Piece[][] board;

	/**
	 * cree un plateau avec les pieces dessus, en position de depart
	 */
	public Board()
	{
		this.board = new Piece[8][8];

		this.board[0][7] = new Rook(PieceColor.WHITE);
		this.board[1][7] = new Knight(PieceColor.WHITE);
		this.board[2][7] = new Bishop(PieceColor.WHITE);
		this.board[4][7] = new King(PieceColor.WHITE);
		this.board[3][7] = new Queen(PieceColor.WHITE);
		this.board[5][7] = new Bishop(PieceColor.WHITE);
		this.board[6][7] = new Knight(PieceColor.WHITE);
		this.board[7][7] = new Rook(PieceColor.WHITE);

		for (int i = 0; i < 8; i++)
		{
			this.board[i][6] = new Pawn(PieceColor.WHITE, PieceType.PAWN);
		}

		this.board[0][0] = new Rook(PieceColor.BLACK);
		this.board[1][0] = new Knight(PieceColor.BLACK);
		this.board[2][0] = new Bishop(PieceColor.BLACK);
		this.board[4][0] = new King(PieceColor.BLACK);
		this.board[3][0] = new Queen(PieceColor.BLACK);
		this.board[5][0] = new Bishop(PieceColor.BLACK);
		this.board[6][0] = new Knight(PieceColor.BLACK);
		this.board[7][0] = new Rook(PieceColor.BLACK);

		for (int i = 0; i < 8; i++)
		{
			this.board[i][1] = new Pawn(PieceColor.BLACK, PieceType.PAWN);
		}
		for (int i = 0; i < 8; i++)
		{
			for (int j = 2; j < 6; j++)
			{
				this.board[i][j] = new Null();
			}
		}
	}

	/**
	 * Cree un plateau a partir d'un tableau de pieces donne
	 * 
	 * @param tabP
	 *            Le tableau de pieces
	 */
	public Board(Piece[][] tabP)
	{
		this.board = tabP;

	}

	/**
	 * @param piece
	 *            La piece que l'on veut deplacer
	 * @param positionDep
	 *            La position ou l'on veut deplacer la piece
	 * @return Le plateau avec le deplacement effectue
	 */
	public Board emulateMove(Piece piece, Position positionDep)
	{
		Board temporaryBoard = (Board) this.clone();
		/*
		Piece[][] tabP1 = new Piece[8][8];
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				tabP1[i][j] = this.board[i][j];
			}
		}
		Board p1 = new Board(tabP1);*/
		temporaryBoard.move(piece, positionDep);

		return temporaryBoard;
	}

	/**
	 * renvoie la position de la piece passee en param
	 * 
	 * @param piece
	 *            la piece que l'on souhaite deplacer
	 * @return la position de la piece a deplacer
	 */
	public Position getCoordonateOfPiece(Piece piece)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
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
	 * 
	 * @param i
	 *            est la position qu'on souhaite verifier
	 * @return la piece presente ou NULL
	 */
	public Piece getPieceAtPosition(Position i)
	{
		return (this.board[i.getOrdonate()][i.getAbscissa()]);
	}

	/**
	 * Donne un liste de Piece contenant les pieces restantes du joueur passe en
	 * parametre
	 * 
	 * @param color
	 *            la couleur du joueur dont on veut recuperer les pieces
	 * @return une liste de Piece contenant les pieces restantes du joueur passe
	 *         en parametre
	 */
	public ArrayList<Piece> getPiecePlayer(PieceColor color)
	{
		ArrayList<Piece> piecePlayer = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (this.board[i][j].getColor() == color)
					piecePlayer.add(this.board[i][j]);
			}
		}
		return piecePlayer;
	}

	/**
	 * Recupere le roi de la couleur donnee
	 * 
	 * @param color
	 *            La couleur du roi que l'on cherche
	 * @return Le roi de la couleur donnee
	 */
	public Piece getKing(PieceColor color)
	{

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (this.board[i][j].getType() == PieceType.KING
						&& this.board[i][j].getColor() == color)
				{
					return (this.board[i][j]);
				}

			}
		}
		return null;
	}

	/**
	 * Verifie si la position donnee est en echec pour le roi de la couleur
	 * donnee
	 * 
	 * @param position
	 *            La position sur laquelle on veut tester l'echec
	 * @param color
	 *            La couleur du roi sur lequel on veut tester l'echec
	 * @return true si la position est en echec pour le roi de la couleur
	 *         donnee, false sinon
	 */
	public boolean isCheck(Position position, PieceColor color)
	{

		ArrayList<Piece> piecesJ = new ArrayList<Piece>();
		piecesJ = getPiecePlayer(color.Invertcolor());
		for (int i = 0; i < piecesJ.size(); i++)
		{
			for (int j = 0; j < piecesJ.get(i).deplacement(this, false).size(); j++)
			{
				if (piecesJ.get(i).deplacement(this, false).get(j)
						.equals(position))
					return true;
			}
		}
		return false;
	}

	/**
	 * Verifie si un joueur a gagne
	 * @param color La couleur du joueur sur lequel on teste la victoire
	 * @return renvoie true si le joueur a gagne, false sinon
	 */
	public boolean checkVictory(PieceColor color)
	{
		if (!(isCheck(getCoordonateOfPiece(getKing(color.Invertcolor())),color.Invertcolor())))
			return false;
		ArrayList<Piece> piecesJ = new ArrayList<Piece>();
		piecesJ = getPiecePlayer(color.Invertcolor());
		for (int i = 0; i < piecesJ.size(); i++)
		{
			if (!(piecesJ.get(i).deplacement(this, false).isEmpty()))
				return false;
		}
		return true;

	}

	/**
	 * Transforme un pion qui atteindrait la derniere ligne du plateau en une
	 * reine.
	 * 
	 * @param piece
	 *            Le pion qui doit etre transforme
	 * @param askedNewPiece
	 *            la piece demandee, a la place d'un pion
	 */
	public void promotion(Piece piece, Piece askedNewPiece)
	{

		this.board[this.getCoordonateOfPiece(piece).getOrdonate()][this
				.getCoordonateOfPiece(piece).getAbscissa()] = askedNewPiece;
	}

	/**
	 * Choix du deplacement par le joueur
	 * 
	 * @param piece
	 *            est la piece que l'on souhaite deplacer
	 * @param arrivalPosition
	 *            est le deplacement voulu pour la piece choisi parmis les
	 *            deplacements posibbles definis dans la piece.
	 */
	public void move(Piece piece, Position arrivalPosition)
	{
		this.board[this.getCoordonateOfPiece(piece).getOrdonate()][this
				.getCoordonateOfPiece(piece).getAbscissa()] = new Null();
		this.board[arrivalPosition.getOrdonate()][arrivalPosition.getAbscissa()] = piece;
	}

	/**
	 * Donne le tableau a 2 dimensions representant le plateau
	 * 
	 * @return tableau de 8 par 8
	 */
	public Piece[][] getBoard()
	{
		return board;
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
	 * Redefinition de la methode clone
	 * Renvoie une copie du plateau
	 */
	public Object clone()
	{
		Object o = null;
		try
		{
			o = super.clone();
		} 
		catch (CloneNotSupportedException cnse)
		{
			cnse.printStackTrace(System.err);
		}
		return o;
	}
}
