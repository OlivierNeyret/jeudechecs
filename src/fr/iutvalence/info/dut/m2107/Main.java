package fr.iutvalence.info.dut.m2107;

/**
 * Point d'entree de l'application.
 * Lancement de l'interface homme-machine.
 * Lancement d'une partie selon le mode choisi.
 * @author olivier
 */

public class Main
{
	/**
	 * L'application de jeu d'echecs par Doge Game Company
	 * Projet IUT Informatique de Valence Semestre 2
	 * Groupe 3.3 : Olivier Neyret, Paul Pasquiou, Xavier Bret, Julien Jacob, Raphael Luciano
	 * @param args
	 */
	public static void main (String[] args)
	{
	    System.out.println("Doge Chess Company presents ChessGame! such chess, very wow");
	    Partie jeu = new Partie();
	    jeu.jouer();
	}
}