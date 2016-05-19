package fr.iutvalence.info.dut.m2107;

import java.util.Scanner;

/**
 * L'interface avec laquelle le joueur agira. Une interface par partie
 * 
 * @author olivier
 *
 */

public class IHM_Joueur
{
	/**
	 * La partie correspondant a l ihm
	 */
	private Partie partie;

	/**
	 * Permet de lire les entrees clavier
	 */
	private Scanner scanner;

	/**
	 * Creer l ihm de de la partie
	 * 
	 * @param partie
	 */
	public IHM_Joueur(Partie partie)
	{
		this.partie = partie;
		this.scanner = new Scanner(System.in);
		System.out.println("Initialisation de l'interface homme-machine.");
	}

	/**
	 * Afficher le plateau sous forme textuelle
	 */
	public void displayBoard()
	{
		System.out.println(this.partie.getPlateau().toString());
	}

	/**
	 * Demande une position a un joueur
	 * 
	 * @return La position rentree par le joueur
	 */
	public Position askPosition()
	{
		Position resultat;
		System.out.println("Saisisser le numero de ligne :");
		int ligne = scanner.nextInt();
		System.out.println("Saisisser le numero de colonne :");
		int colonne = scanner.nextInt();
		resultat = new Position(ligne,colonne);
		return resultat;
	}
}