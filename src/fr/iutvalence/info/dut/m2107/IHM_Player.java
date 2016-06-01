package fr.iutvalence.info.dut.m2107;

import java.util.Scanner;

/**
 * L'interface avec laquelle le joueur agira. Une interface par partie
 * 
 * @author olivier
 *
 */

public class IHM_Player
{
	/**
	 * Permet de lire les entrees clavier
	 */
	private Scanner scanner;

	/**
	 * Cree une ihm
	 */
	public IHM_Player()
	{
		this.scanner = new Scanner(System.in);
		System.out.println("Initialisation de l'interface homme-machine.");
	}

	/**
	 * Afficher le plateau sous forme textuelle
	 * @param board Le plateau a afficher
	 */
	public void displayBoard(Board board)
	{
		System.out.println(board.toString());
	}

	/**
	 * Demande une position a un joueur
	 * 
	 * @return La position rentree par le joueur
	 */
	public Position askPosition()
	{
		boolean test = false;
		Position result = null;
		while (!test)
		{
			System.out.println("Saisisser le numero de colonne :");
			int line = this.scanner.nextInt();
			System.out.println("Saisisser le numero de ligne :");
			int column = this.scanner.nextInt();
			try
			{
				result = new Position(line, column);
				System.out.println(result);
				test = true;
			} catch (PositionOutOfBoardException e)
			{

			}
		}
		return result;
	}
	
	/**
	 * Demande au joueur en quelle piece doit etre promu le pion
	 * @param piece La piece a promouvoir
	 * @return La nouvelle piece
	 */
	public Piece askPiece(Piece piece)
	{
		PieceColor color = piece.getColor();
		int choix = 0;
		System.out.println("En quelle pièce souhaitez-vous promouvoir ce pion ?");
		do
		{
			System.out.println("1:Reine  2:Tour  3:Cavalier  4:Fou");
			choix = this.scanner.nextInt();
		}while(choix > 0 && choix <= 4);
		switch (choix)
		{
			case 1:
				return new Queen(color);
			case 2:
				return new Rook(color);
			case 3:
				return new Knight(color);
			case 4:
				return new Bishop(color);           
		}
		return null;
	}
	
	/**
	 * Demande le mode de jeu choisi
	 * @return 1 pour un joueur, 2 pour deux joueurs
	 */
	public int askMode()
	{
		int nbOfHumanPlayer=0;
		do
		{
			System.out.println("Choisissez le mode de jeu :");
			System.out.println("1 : Jouer contre l'ordi");
			System.out.println("2 : Jouer contre un autre joueur humain");
			nbOfHumanPlayer = this.scanner.nextInt();
		}
		while(nbOfHumanPlayer != 1 && nbOfHumanPlayer != 2);
		return nbOfHumanPlayer;
	}
	
	/**
	 * Demande la couleur que souhaite le joueur
	 * @return la couleur choisie
	 */
	public PieceColor askColor()
	{
		PieceColor colorChosen;
		int color;
		do
		{
			System.out.println("Choisissez votre couleur :");
			System.out.println("0 : Jouer les blancs");
			System.out.println("1 : Jouer les noirs");
			color = this.scanner.nextInt();
		}
		while(color != 0 && color != 1);
		if(color == 0) colorChosen = PieceColor.WHITE;
		else colorChosen = PieceColor.BLACK;
		return colorChosen;
	}

	/**
	 * Demande la difficulte que souhaite le joueur
	 * @return la difficulte choisie
	 */
	public Difficulty askDifficulty()
	{
		Difficulty diffChosen;
		int diff;
		do
		{
			System.out.println("Choisissez la difficulte de l'adversaire :");
			System.out.println("1 : Facile");
			System.out.println("2 : Moyen");
			System.out.println("3 : Difficile");
			diff = this.scanner.nextInt();
		}
		while(diff != 1 && diff != 2 && diff != 3);
		if(diff == 1) diffChosen = Difficulty.EASY;
		else if (diff == 2) diffChosen = Difficulty.MIDDLE;
		else diffChosen = Difficulty.DIFFICULT;
		return diffChosen;
	}
}