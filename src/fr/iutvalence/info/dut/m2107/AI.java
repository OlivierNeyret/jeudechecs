package fr.iutvalence.info.dut.m2107;

import java.util.Random;

/**
 * Classe qui gere la facon dont l'intelligence artificielle (IA) va jouer
 * 
 * @author Xavier
 *
 */
public class AI extends Player
{

	/**
	 * Difficulte de l'IA
	 */
private final Difficulty difficulty;

	/**
	 * Cree une IA avec une difficulte donnee
	 * 
	 * @param difficulty
	 *            difficulte de l'IA
	 */
	public AI(Difficulty difficulty)
	{
		super(Color.BLACK);
		this.difficulty = difficulty;
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
	public void move(Piece piece, Position deplacement)
	{
		// TODO - implement IA.deplacer
		//Pas besoin de la redefinir si la methode IAjoue l appel
		throw new UnsupportedOperationException();
	}

	/**
	 * Choix du deplacement a faire
	 * Effectue le deplacement
	 */
	public void aiPlay()
	{
		Piece pieceChoisie;
		Position deplacementChoisi;
		
		if(this.difficulty==Difficulty.EASY)
		{
			//Choisir un deplacement
		}
		else if(this.difficulty==Difficulty.MIDDLE)
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
	public Difficulty getDifficulty()
	{
		return this.difficulty;
	}

}