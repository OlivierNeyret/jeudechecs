package fr.iutvalence.info.dut.m2107;

import java.util.Random;

/**
 * Classe qui gere la facon dont l'intelligence artificielle (IA) va jouer
 * 
 * @author Xavier
 *
 */
public class AI extends Player
{
	/**
	 * Constantes contenant les coefficients utilises dans la fonction d evaluation
	 */
	private final static int COEF_BISHOP = 3;
	private final static int COEF_KNIGHT = 3;
	private final static int COEF_ROOK = 5;
	private final static int COEF_QUEEN = 10;
	private final static int COEF_NBOFMOVE = 1;
	private final static int COEF_CHESS = 500;
	private final static int COEF_VICTORY = 1000;
	
	/**
	 * Difficulte de l'IA
	 */
	private final Difficulty difficulty;

	/**
	 * Cree une IA avec une difficulte donnee
	 * 
	 * @param difficulty
	 *            difficulte de l'IA
	 */
	public AI(Difficulty difficulty)
	{
		super(PieceColor.BLACK);
		this.difficulty = difficulty;
	}

	/**
	 * Choix du deplacement a faire
	 * Effectue le deplacement
	 */
	public void aiPlay()
	{
		Piece pieceChoisie;
		Position deplacementChoisi;
		
		if(this.difficulty==Difficulty.EASY)
		{
			//Choisir un deplacement
		}
		else if(this.difficulty==Difficulty.MIDDLE)
		{
			/*
			 * Parcourir toutes les pi�ces
			 * Pour chaque piece essayer chaque deplacement possible et calculer le meilleur coup
			 * retenir le meilleur coup de chaque piece
			 * comparer les meilleurs coups et choisir le meilleur coup
			 */
		}
		else
		{
			
		}

		
		//this.move(pieceChoisie, deplacementChoisi);
	}
	
	/**
	 * Methode evaluant la situation de l IA
	 * Plus le score renvoye est haut, plus la situation de l ia est bonne
	 * @param board le plateau de jeu qui doit etre evaule
	 * @return le score du plateau, entier <= 1000
	 */
	public int evaluate(Board board)
	{
		int eval = 0;
		int nbBishop=0;
		int nbKnight=0;
		int nbQueen=0;
		int nbRook=0;
		int nbOfMove=0;
		Position amodifier = null;
		if (board.isCheck(amodifier, this.getColor().Invertcolor()))
		{
			/*
			 * Si l'adversaire est battu
			 * alors return COEF_VICTORY;
			 * sinon
			 */
			eval += COEF_CHESS;
		}
		for (int i=0;i<8;i++)
		{
			for (int j=0;j<8;j++)
			{
				Piece currentPiece = board.getBoard()[i][j];
				if (currentPiece.getColor()==this.getColor())
				{
					if(currentPiece.getType()==PieceType.BISHOP) nbBishop++;
					else if(currentPiece.getType()==PieceType.ROOK) nbRook++;
					else if(currentPiece.getType()==PieceType.QUEEN) nbQueen++;
					else if(currentPiece.getType()==PieceType.KNIGHT) nbKnight++;
				}
				else if (currentPiece.getColor()==this.getColor().Invertcolor())
				{
					if(currentPiece.getType()==PieceType.BISHOP) nbBishop--;
					else if(currentPiece.getType()==PieceType.ROOK) nbRook--;
					else if(currentPiece.getType()==PieceType.QUEEN) nbQueen--;
					else if(currentPiece.getType()==PieceType.KNIGHT) nbKnight--;
				}
			}
		}
		eval+=(COEF_BISHOP * nbBishop)+(COEF_QUEEN * nbQueen)+(COEF_KNIGHT * nbKnight)+(COEF_QUEEN * nbQueen)+(COEF_ROOK * nbRook)+(COEF_NBOFMOVE * nbOfMove);
		return eval;
	}
	
	/**
	 * @return renvoie la difficulte de l'IA
	 */
	public Difficulty getDifficulty()
	{
		return this.difficulty;
	}

}