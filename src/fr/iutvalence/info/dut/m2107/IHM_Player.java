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
		System.out.println(this.game.getPlateau().toString());
	}

	/**
	 * Demande une position a un joueur
	 * 
	 * @return La position rentree par le joueur
	 */
	public Position askPosition()
	{
		boolean test=false;
		Position resultat = null;
		System.out.println("Saisisser le numero de ligne :");
		int ligne = this.scanner.nextInt();
		System.out.println("Saisisser le numero de colonne :");
		int colonne = this.scanner.nextInt();
		while (!test){
			try
			{
				resultat = new Position(ligne,colonne);
				test=true;
			} catch (PositionOutOfBoardException e)
			{
				
			}
		}
		return resultat;
	}
}