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
	 * La partie correspondant a l ihm
	 */
	private Game game;

	/**
	 * Permet de lire les entrees clavier
	 */
	private Scanner scanner;

	/**
	 * Creer l ihm de de la partie
	 * 
	 * @param game
	 */
	public IHM_Player(Game game)
	{
		this.game = game;
		this.scanner = new Scanner(System.in);
		System.out.println("Initialisation de l'interface homme-machine.");
	}

	/**
	 * Afficher le plateau sous forme textuelle
	 */
	public void displayBoard()
	{
		System.out.println(this.game.getBoard().toString());
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
			System.out.println("Saisisser le numero de ligne :");
			int ligne = this.scanner.nextInt();
			System.out.println("Saisisser le numero de colonne :");
			int colonne = this.scanner.nextInt();
			try
			{
				result = new Position(ligne, colonne);
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
		Color color = piece.getColor();
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
}