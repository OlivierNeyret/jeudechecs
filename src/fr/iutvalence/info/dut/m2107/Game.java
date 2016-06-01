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
	
	@SuppressWarnings("unused")
	private Player white;
	/**
	 * Le joueur qui joue les noirs
	 */

	@SuppressWarnings("unused")
	private Player black;
	/**
	 * Le plateau de la partie
	 */
	private Board board;
	
	/**
	 * L'interface-homme-machine en console de la partie
	 */
	private IHM_Player ihmGame;

	/**
	 * Creer une partie a deux joueurs humains
	 */
	public Game()
	{
		this.white = new Player(PieceColor.WHITE);
		this.black = new Player(PieceColor.BLACK);
		this.board = new Board();
		this.ihmGame = new IHM_Player();
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
	public Game(PieceColor couleurJoueur, Difficulty difficulteChoisie)
	{
		if (couleurJoueur == PieceColor.WHITE)
		{
			this.white = new Player(PieceColor.WHITE);
			this.black = new AI(difficulteChoisie);
		} else
		{
			this.black = new Player(PieceColor.BLACK);
			this.white = new AI(difficulteChoisie);
		}
		this.ihmGame = new IHM_Player();
		this.board = new Board();
	}

	/**
	 * Renvoie le plateau de la partie
	 * @return Le plateau de la partie
	 */
	public Board getBoard()
	{
		return this.board;
	}
	
	/**
	 * Verifie si le joueur peut joueur dans le cas ou il n'est pas en echec
	 * @param board Le plateau du jeu
	 * @param playerColor Le joueur qui a le trait
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
	 * @param nbOfHumanPlayer le nombre de joueur humain
	 * @return La couleur du joueur qui a gagne la partir
	 */
	public PieceColor play(int nbOfHumanPlayer)
	{
		int numberOfMoves = 0;
		while (true)
		{
			Position positionPieceToMove, positionOfDestination;
			Piece pieceToMove;
			ArrayList<Position> listOfMove;
			this.ihmGame.displayBoard(this.board);
			if(numberOfMoves%2==0) //Le tour des blancs
			{
				if(this.checkDraw(this.board, PieceColor.WHITE))
					return PieceColor.NONE;
				do
				{
					do
					{
						//Demander la piece a jouer
						System.out.println("Coup des blancs, choisissez une pièce à déplacer :");
						positionPieceToMove = this.ihmGame.askPosition();
						pieceToMove = this.board.getPieceAtPosition(positionPieceToMove);
					}
					while(pieceToMove.getColor()!=PieceColor.WHITE);
					listOfMove = pieceToMove.deplacement(this.board, true);
					//Afficher les deplacements possibles
					System.out.println(listOfMove);
					//Demander le deplacement
					System.out.println("Entrez la destination. Pour changer de pièce, entrez une position non valide.");
					positionOfDestination = this.ihmGame.askPosition();
					//verifier validite du coup
					if(listOfMove.contains(positionOfDestination))
					{
						this.board.move(pieceToMove, positionOfDestination);
						if (pieceToMove.getType() == PieceType.PAWN && positionOfDestination.getAbscissa() == 0 || positionOfDestination.getAbscissa() == 7)
						{
							this.board.promotion(pieceToMove, this.ihmGame.askPiece(pieceToMove));
						}
					}
				}
				while(!listOfMove.contains(positionOfDestination));
				if (board.checkVictory(PieceColor.WHITE))
						return PieceColor.WHITE;
			}
			
			else //Le tour des noirs
			{
				if(this.checkDraw(board, PieceColor.BLACK))
					return PieceColor.NONE;
				do
				{
					do
					{
						//Demander la piece a jouer
						System.out.println("Coup des noirs, choisissez une pièce à déplacer :");
						positionPieceToMove = this.ihmGame.askPosition();
						pieceToMove = this.board.getPieceAtPosition(positionPieceToMove);
					}
					while(pieceToMove.getColor()!=PieceColor.BLACK);
					listOfMove = pieceToMove.deplacement(this.board, true);
					//Afficher les deplacements possibles
					System.out.println(listOfMove);
					//Demander le deplacement
					positionOfDestination = this.ihmGame.askPosition();
					//verifier validite du coup
					if(listOfMove.contains(positionOfDestination))
					{
						this.board.move(pieceToMove, positionOfDestination);
						if (pieceToMove.getType() == PieceType.PAWN && positionOfDestination.getAbscissa() == 0 || positionOfDestination.getAbscissa() == 7)
						{
							this.board.promotion(pieceToMove, this.ihmGame.askPiece(pieceToMove));
						}
					}
				}
				while(!listOfMove.contains(positionOfDestination));
				if (board.checkVictory(PieceColor.BLACK))
					return PieceColor.BLACK;
			}
			numberOfMoves++;
		}
	}
}