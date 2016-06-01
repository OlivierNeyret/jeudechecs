package fr.iutvalence.info.dut.m2107;

/**
 * Point d'entree de l'application.
 * Lancement de l'interface homme-machine.
 * Lancement d'une partie selon le mode choisi.
 * @author olivier
 */

public class ChessGame
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
	    IHM_Player ihmMain = new IHM_Player();
	    int nbOfHumanPlayer = ihmMain.askMode();
	    Game game;
	    PieceColor winner;
		if(nbOfHumanPlayer==1)
		{
			PieceColor colorChosen = ihmMain.askColor();
			Difficulty diff = ihmMain.askDifficulty();
			game = new Game(colorChosen,diff);
		}
		else
		{
			game = new Game();
		}
	    //Window zFen = new Window(game.getBoard());
	    winner = game.play(nbOfHumanPlayer);
	    if (winner == PieceColor.NONE) System.out.println("Match nul !");
	    System.out.println("Les "+winner.toString()+"s ont gagn�s !");
	}
}