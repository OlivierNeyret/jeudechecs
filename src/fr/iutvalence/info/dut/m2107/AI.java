package fr.iutvalence.info.dut.m2107;

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
	 * Coefficient du fou
	 */
	private final static int COEF_BISHOP = 3;
	/**
	 * Coefficient du cavalier
	 */
	private final static int COEF_KNIGHT = 3;
	/**
	 * Coefficient de la tour
	 */
	private final static int COEF_ROOK = 5;
	/**
	 * Coefficient de la reine
	 */
	private final static int COEF_QUEEN = 10;
	/**
	 * Coefficient du nombre de mouvement
	 */
	private final static int COEF_NBOFMOVE = 1;
	/**
	 * Coefficient en cas d'echec
	 */
	private final static int COEF_CHESS = 20;
	/**
	 * Coefficient en cas de victoire
	 */
	private final static int COEF_VICTORY = 1000;
	
	/**
	 * Difficulte de l'IA
	 */
	private final Difficulty difficulty;

	/**
	 * Cree une IA avec une difficulte donnee
	 * @param color La couleur de l'IA
	 * @param difficulty
	 *            difficulte de l'IA
	 */
	public AI(PieceColor color, Difficulty difficulty)
	{
		super(color);
		this.difficulty = difficulty;
	}

	/**
	 * Choix du deplacement a faire
	 * Effectue le deplacement
	 * @param board Le plateau de la partie en cours
	 */
	public void aiPlay(Board board)
	{
		int depth;
		int alpha = -COEF_VICTORY;
		int beta = COEF_VICTORY;
		Piece pieceChosen=null;
		Position moveChosen=null;
		
		if(this.difficulty==Difficulty.EASY)
			depth=2;
		else if(this.difficulty==Difficulty.MIDDLE)
			depth=3;
		else
			depth=4;
		
		int currentValue;
		int maxValue = -COEF_VICTORY;
		Board temporaryBoard;
		Piece currentPiece;
		Position currentMove;
		ArrayList<Position> listOfMove;

		ArrayList<Piece> pieceOfAI = board.getPiecePlayer(this.getColor());
		//On parcourt toute les possibilitees de coups
		for(int i=0;i<pieceOfAI.size();i++)
		{
			currentPiece=pieceOfAI.get(i);
			listOfMove = currentPiece.deplacement(board, true);
			for(int j=0;j<listOfMove.size();j++)
			{
				currentMove = listOfMove.get(j);
				temporaryBoard = board.emulateMove(currentPiece, currentMove);
				//currentValue = this.minI(temporaryBoard,depth-1);
				currentValue = this.alphabeta(temporaryBoard, false, depth, alpha, beta);
				if(currentValue>maxValue)
				{
					maxValue=currentValue;
					pieceChosen=currentPiece;
					moveChosen=currentMove;
				}
			}
		}
		board.move(pieceChosen, moveChosen);
	}
	
	/**
	 * Donne la valeur du coup
	 * @param board le plateau apres le coup
	 * @param turnAI true si c'est le tour de l'ai
	 * @param depth la profondeur souhaite
	 * @param alpha la valeur minimum encadrant val
	 * @param beta la valeur maximum encadrant val
	 * @return la valeur du coup
	 */
	public int alphabeta(Board board, boolean turnAI, int depth, int alpha, int beta)
	{
		if(depth==0 || board.checkVictory(this.getColor())) //On verifie uniquement si l'ia a gagne car un joueur ne peut pas perdre volontairement
			return this.evaluate(board);
		int val;
		Board temporaryBoard;
		Piece currentPiece;
		ArrayList<Position> listOfMove;
		if (!turnAI)
		{
			val = COEF_VICTORY;
			ArrayList<Piece> pieceOfAI = board.getPiecePlayer(this.getColor());
			//On parcourt toute les possibilitees de coups
			for(int i=0;i<pieceOfAI.size();i++)
			{
				currentPiece=pieceOfAI.get(i);
				listOfMove = currentPiece.deplacement(board, true);
				for(int j=0;j<listOfMove.size();j++)
				{
					Position currentMove = listOfMove.get(j);
					temporaryBoard = board.emulateMove(currentPiece, currentMove);
					val = Math.min(val,this.alphabeta(temporaryBoard, !turnAI, depth-1, alpha, beta));
					if(alpha>=val)
						return val;
					beta=Math.min(beta, val);
				}
			}	
		}
		else
		{
			val = -COEF_VICTORY;
			ArrayList<Piece> pieceOfAI = board.getPiecePlayer(this.getColor());
			//On parcourt toute les possibilitees de coups
			for(int i=0;i<pieceOfAI.size();i++)
			{
				currentPiece=pieceOfAI.get(i);
				listOfMove = currentPiece.deplacement(board, true);
				for(int j=0;j<listOfMove.size();j++)
				{
					Position currentMove = listOfMove.get(j);
					temporaryBoard = board.emulateMove(currentPiece, currentMove);
					val = Math.max(val,this.alphabeta(temporaryBoard, !turnAI, depth-1, alpha, beta));
					if(val>=beta)
						return val;
					alpha=Math.max(alpha, val);
				}
			}
		}
		return val;
	}
	
	/**
	 * Cherche le noeud a valeur minimum parmi les noeuds fils du coup passe en parametre
	 * @param board Le plateau apres le coup simule
	 * @param depth La profondeur actuelle de l'arbre
	 * @return La valeur (a travers la methode evaluate) du noeud choisi
	 */
	private int minI(Board board, int depth)
	{
		if(depth==0 || board.checkVictory(this.getColor())) //On verifie uniquement si l'ia a gagne car un joueur ne peut pas perdre volontairement
			return this.evaluate(board);
		
		int min=COEF_VICTORY;
		int currentValue;		
		Board temporaryBoard;
		Piece currentPiece;
		ArrayList<Position> listOfMove;
		
		ArrayList<Piece> pieceOfAI = board.getPiecePlayer(this.getColor());
		//On parcourt toute les possibilitees de coups
		for(int i=0;i<pieceOfAI.size();i++)
		{
			currentPiece=pieceOfAI.get(i);
			listOfMove = currentPiece.deplacement(board, true);
			for(int j=0;j<listOfMove.size();j++)
			{
				Position currentMove = listOfMove.get(j);
				temporaryBoard = board.emulateMove(currentPiece, currentMove);
				currentValue = this.maxI(temporaryBoard,depth-1);
				if(currentValue<min)
					min=currentValue;	
			}
		}
		return min;
	}
	
	/**
	 * Cherche le noeud a valeur maximum parmi les noeuds fils du coup passe en parametre
	 * @param board Le plateau apres le coup simule
	 * @param depth La profondeur de l'arbre
	 * @return La valeur (a travers la methode evaluate) du noeud choisi
	 */
	private int maxI(Board board, int depth)
	{
		if(depth==0 || board.checkVictory(this.getColor())) //On verifie uniquement si l'ia a gagne car un joueur ne peut pas perdre volontairement
			return this.evaluate(board);

		int max =  -COEF_VICTORY;
		int currentValue;		
		Board temporaryBoard;
		Piece currentPiece;
		ArrayList<Position> listOfMove;
		
		ArrayList<Piece> pieceOfAI = board.getPiecePlayer(this.getColor());
		//On parcourt toute les possibilitees de coups
		for(int i=0;i<pieceOfAI.size();i++)
		{
			currentPiece=pieceOfAI.get(i);
			listOfMove = currentPiece.deplacement(board, true);
			for(int j=0;j<listOfMove.size();j++)
			{
				Position currentMove = listOfMove.get(j);
				temporaryBoard = board.emulateMove(currentPiece, currentMove);
				currentValue = this.minI(temporaryBoard, depth-1);
				if(currentValue>max)
					max=currentValue;
			}
		}
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
		Position positionOfKing = board.getCoordonateOfPiece(board.getKing(this.getColor().invertColor()));
		if (board.isCheck(positionOfKing, this.getColor().invertColor()))
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
				else if (currentPiece.getColor()==this.getColor().invertColor())
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