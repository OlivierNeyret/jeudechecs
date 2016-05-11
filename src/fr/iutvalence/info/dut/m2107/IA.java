package fr.iutvalence.info.dut.m2107;

import java.util.Random;

/**
 * Classe qui gere la fa�on dont l'intelligence artificielle (IA) va jouer
 * 
 * @author Xavier
 *
 */
public class IA extends Joueur
{

	/**
	 * Difficulte de l'IA
	 */
	private final Difficulte difficulte;

	/**
	 * Cree une IA avec une difficulte donnee
	 * 
	 * @param difficulte
	 *            difficulte de l'IA
	 */
	public IA(Difficulte difficulte)
	{
		super(Couleur.Noir);
		this.difficulte = difficulte;
	}

	/**
	 * Redefinition de Joueur.deplacer dans laquelle l'IA choisira le
	 * deplacement en fonction de la difficult� et de l'�tat de la partie
	 * 
	 * @param piece
	 *            La piece a deplacer
	 * @param deplacement
	 *            Le deplacement que la piece doit effectuer
	 */
	public void deplacer(Piece piece, Position deplacement)
	{
		// TODO - implement IA.deplacer
		//Pas besoin de la redefinir si la methode IAjoue l appel
		throw new UnsupportedOperationException();
	}

	/**
	 * Choix du deplacement a faire
	 * Effectue le deplacement
	 */
	public void IAjoue()
	{
		Piece pieceChoisie;
		Position deplacementChoisi;
		
		if(this.difficulte==Difficulte.Facile)
		{
			Random rand = new Random();
			int nombre = rand.nextInt(16+1);
			//pieceChoisie = this.pieceDeIA[nombre];
			//Choisir un deplacement
		}
		else if(this.difficulte==Difficulte.Moyen)
		{
			/*
			 * Parcourir toutes les pi�ces
			 * Pour chaque piece essayer chaque deplacement possible et calculer le meilleur coup
			 * retenir le meilleur coup de chaque piece
			 * comparer les meilleurs coups et choisir le meilleur coup
			 */
		}
		else
		{
			
		}

		
		//this.deplacer(pieceChoisie, deplacementChoisi);
	}
	
	/**
	 * @return renvoie la difficulte de l'IA
	 */
	public Difficulte getDifficulte()
	{
		return this.difficulte;
	}

}