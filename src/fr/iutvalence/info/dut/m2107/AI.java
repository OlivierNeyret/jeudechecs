package fr.iutvalence.info.dut.m2107;

import java.util.Random;
import java.util.ArrayList;

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
	public void aiPlay(Board board)
	{
		Piece pieceChoisie;
		Position deplacementChoisi;
		
		if(this.difficulty==Difficulty.EASY)
		{
			//Choisir un deplacement
		}
		else if(this.difficulty==Difficulty.MIDDLE)
		{
			int depth=3;
			int max_val = -COEF_VICTORY;
			Board temporaryBoard;
			Piece pieceToMove;
			ArrayList<Position> listOfMove;
			
			ArrayList<Piece> pieceOfAI = board.getPiecePlayer(this.getColor());
			for(int i=0;i<pieceOfAI.size();i++)
			{
				pieceToMove=pieceOfAI.get(i);
				listOfMove = pieceToMove.deplacement(board, true);
				for(int j=0;j<listOfMove.size();j++)
				{
					temporaryBoard = (Board) board.clone();
				}
			}
			/*
			 * max_val <- -infini

	     		Pour tous les coups possibles
	          		simuler(coup_actuel)
	          		val <- Min(etat_du_jeu, profondeur)
	     
	          		si val > max_val alors
	               		max_val <- val
	               		meilleur_coup <- coup_actuel
	          		fin si
	     
	          		annuler_coup(coup_actuel)
	     		fin pour
	
	     		jouer(meilleur_coup)
			 */
			
			/*
			 * Parcourir toutes les pieces
			 * Pour chaque piece essayer chaque deplacement possible et calculer le meilleur coup
			 * retenir le meilleur coup de chaque piece
			 * comparer les meilleurs coups et choisir le meilleur coup
			 */
		}
		else
		{
			int depth=5;
		}
		//this.move(pieceChoisie, deplacementChoisi);
	}
	
	/**
	 * 
	 * @return
	 */
	private int min(Board board, int depth)
	{
		int min=0;
		return min;
	}
	
	/**
	 * 
	 * @return
	 */
	private int max(Board board, int depth)
	{
		int max=0;
		return max;
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
		Position positionOfKing = board.getCoordonateOfPiece(board.getKing(this.getColor().Invertcolor()));
		if (board.isCheck(positionOfKing, this.getColor().Invertcolor()))
		{
			if(board.checkVictory(this.getColor()))
				return COEF_VICTORY;
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