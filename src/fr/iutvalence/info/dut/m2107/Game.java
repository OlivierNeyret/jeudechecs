package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

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
	// private Player white;

	/**
	 * Le joueur qui joue les noirs
	 */
	// private Player black;

	/**
	 * L'IA eventuelle de la partie
	 */
	private AI ai;

	/**
	 * Le plateau de la partie
	 */
	private Board board;

	/**
	 * L'interface homme-machine en console de la partie
	 */
	private IHM_Player ihmGame;

	/**
	 * Creer une partie a deux joueurs humains
	 */
	public Game()
	{
		// this.white = new Player(PieceColor.WHITE);
		// this.black = new Player(PieceColor.BLACK);
		this.ai = null;
		this.board = new Board();
		this.ihmGame = new IHM_Player();
	}

	/**
	 * Creer une partie contre l'ordi
	 * 
	 * @param colorPlayer
	 *            la couleur choisie par le joueur humain
	 * @param difficultyChosen
	 *            la difficulte choisie par le joueur humain
	 * 
	 */
	public Game(PieceColor colorPlayer, Difficulty difficultyChosen)
	{
		if (colorPlayer == PieceColor.WHITE)
		{
			/*
			 * this.white = new Player(PieceColor.WHITE); this.black = new
			 * AI(difficultyChosen);
			 */
			this.ai = new AI(PieceColor.BLACK, difficultyChosen);
		}
		else
		{
			/*
			 * this.black = new Player(PieceColor.BLACK); this.white = new
			 * AI(difficultyChosen);
			 */
			this.ai = new AI(PieceColor.WHITE, difficultyChosen);
		}
		this.ihmGame = new IHM_Player();
		this.board = new Board();
	}

	/**
	 * Renvoie le plateau de la partie
	 * 
	 * @return Le plateau de la partie
	 */
	public Board getBoard()
	{
		return this.board;
	}

	/**
	 * Verifie si le joueur peut joueur dans le cas ou il n'est pas en echec
	 * 
	 * @param board
	 *            Le plateau du jeu
	 * @param playerColor
	 *            Le joueur qui a le trait
	 * @return True s'il peut jouer, False sinon
	 */
	public boolean checkDraw(Board board, PieceColor playerColor)
	{
		ArrayList<Piece> piecesJ = new ArrayList<Piece>();
		piecesJ = board.getPiecePlayer(playerColor);
		for (int i = 0; i < piecesJ.size(); i++)
		{
			if (!(piecesJ.get(i).deplacement(board, false).isEmpty()))
				return false;
		}
		return true;
	}

	/**
	 * Le deroulement de la partie
	 * 
	 * @param colorOfAI
	 *            la couleur de l'IA eventuelle
	 * @return La couleur du joueur qui a gagne la partir
	 */
	public PieceColor play(PieceColor colorOfAI)
	{
		int numberOfMoves = 0;
		while (true)
		{
			PieceColor winner;
			if (numberOfMoves % 2 == 0) // Le tour des blancs
				winner = askCheckMove(PieceColor.WHITE, colorOfAI != PieceColor.WHITE);
			else
				// Le tour des noirs
				winner = askCheckMove(PieceColor.BLACK, colorOfAI != PieceColor.BLACK);
			numberOfMoves++;
			if (winner != null)
				return winner;
		}
	}

	/**
	 * Demande, verifie la validite et effectue le deplacement du joueur
	 * 
	 * @param color
	 *            la couleur du joueur qui doit jouer
	 * @param human
	 *            True si le joueur est humain, False sinon
	 * @return La couleur du joueur gagnant s'il existe, null sinon
	 */
	public PieceColor askCheckMove(PieceColor color, boolean human)
	{
		if (this.checkDraw(this.board, color))
			return PieceColor.NONE;
		if (!human) // On fait jouer l'IA
			ai.aiPlay(this.board);
		else // Le joueur humain joue
		{
			Position positionPieceToMove, positionOfDestination;
			Piece pieceToMove;
			ArrayList<Position> listOfMove;
			this.ihmGame.displayBoard(this.board);
			do
			{
				do
				{
					// Demander la piece a jouer
					System.out.println("Coup des " + color.toString()
							+ ", choisissez une pièce à déplacer :");
					positionPieceToMove = this.ihmGame.askPosition();
					pieceToMove = this.board
							.getPieceAtPosition(positionPieceToMove);
				}
				while (pieceToMove.getColor() != color);
				listOfMove = pieceToMove.deplacement(this.board, true);
				// Afficher les deplacements possibles
				System.out.println(listOfMove);
				// Demander le deplacement
				System.out
						.println("Entrez la destination. Pour changer de pièce, entrez une position non valide.");
				positionOfDestination = this.ihmGame.askPosition();
				// verifier validite du coup
				if (listOfMove.contains(positionOfDestination))
				{
					this.board.move(pieceToMove, positionOfDestination);
					if (pieceToMove.getType() == PieceType.PAWN
							&& (positionOfDestination.getAbscissa() == 0
							|| positionOfDestination.getAbscissa() == 7))
					{
						this.board.promotion(pieceToMove,
								this.ihmGame.askPiece(pieceToMove));
					}
				}
			}
			while (!listOfMove.contains(positionOfDestination));
		}
		if (board.checkVictory(color))
			return color;
		return null;
	}
}