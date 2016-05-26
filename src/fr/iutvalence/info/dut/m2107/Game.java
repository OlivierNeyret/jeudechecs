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
	 * Creer une partie a deux joueurs humains
	 */
	public Game()
	{
		this.white = new Player(PieceColor.WHITE);
		this.black = new Player(PieceColor.BLACK);
		this.board = new Board();
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
		this.board = new Board();
	}

	/**
	 * Verifie si un joueur a gagne
	 * 
	 * @return renvoie true si le joueur a gagne, false sinon
	 */
	public boolean checkVictory()
	{
	// TODO - implement Partie.VerifierConditionsVictoire
		return false;
	}

	/**
	 * Renvoie le plateau de la partie
	 * 
	 * @return Le plateau de la partie
	 */
	public Board getBoard()
	{
		// TODO Auto-generated method stub
		return this.board;
	}

	/**
	 * Le deroulement de la partie
	 */
	public void play()
	{
		int numberOfMoves = 0;
		IHM_Player ihm = new IHM_Player(this);
		while (this.checkVictory() == false)
		{
			Position positionPieceToMove, positionOfDestination;
			Piece pieceToMove;
			ArrayList<Position> listOfMove;
			ihm.displayBoard();
			if(numberOfMoves%2==0) //Le tour des blancs
			{
				do
				{
					do
					{
						//Demander la piece a jouer
						System.out.println("Coup des blancs, choisissez une pi�ce � d�placer :");
						positionPieceToMove = ihm.askPosition();
						pieceToMove = this.board.getPieceAtPosition(positionPieceToMove);
					}
					while(pieceToMove.getColor()!=PieceColor.WHITE);
					listOfMove = pieceToMove.deplacement(this.board, true);
					//Afficher les deplacements possibles
					System.out.println(listOfMove);
					//Demander le deplacement
					positionOfDestination = ihm.askPosition();
					//verifier validite du coup
					if(listOfMove.contains(positionOfDestination))
					{
						System.out.println(32);
						this.board.move(pieceToMove, positionOfDestination);
						if (pieceToMove.getType() == PieceType.PAWN && positionOfDestination.getAbscissa() == 0 || positionOfDestination.getAbscissa() == 7)
						{
							this.board.promotion(pieceToMove, ihm.askPiece(pieceToMove));
						}
					}
				}
				while(!listOfMove.contains(positionOfDestination));
			}
			else //Le tour des noirs
			{
				do
				{
					do
					{
						//Demander la piece a jouer
						System.out.println("Coup des noirs, choisissez une pi�ce � d�placer :");
						positionPieceToMove = ihm.askPosition();
						pieceToMove = this.board.getPieceAtPosition(positionPieceToMove);
					}
					while(pieceToMove.getColor()!=PieceColor.BLACK);
					listOfMove = pieceToMove.deplacement(this.board, true);
					//Afficher les deplacements possibles
					System.out.println(listOfMove);
					//Demander le deplacement
					positionOfDestination = ihm.askPosition();
					//verifier validite du coup
					if(listOfMove.contains(positionOfDestination))
					{
						this.board.move(pieceToMove, positionOfDestination);
						if (pieceToMove.getType() == PieceType.PAWN && positionOfDestination.getAbscissa() == 0 || positionOfDestination.getAbscissa() == 7)
						{
							this.board.promotion(pieceToMove, ihm.askPiece(pieceToMove));
						}
					}
				}
				while(!listOfMove.contains(positionOfDestination));
			}
			numberOfMoves++;
			ihm.displayBoard();
		}
	}
}