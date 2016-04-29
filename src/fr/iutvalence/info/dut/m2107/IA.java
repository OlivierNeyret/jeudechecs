package fr.iutvalence.info.dut.m2107;

/**
 * Classe qui gere la façon dont l'intelligence artificielle (IA) va jouer
 * @author Xavier
 *
 */
public class IA extends Joueur {

	/**
	 * Difficulte de l'IA 
	 */
	private final Difficulte difficulte;
	
	/**
	 * Cree une IA avec une difficulte donnee
	 * @param difficulte difficulte de l'IA
	 */
	public IA(Difficulte difficulte)
	{
		super();
		this.difficulte = difficulte;
	}




	/**
	 * Redefinition de Joueur.deplacer dans laquelle l'IA choisira le deplacement en
	 * fonction de la difficulté et de l'état de la partie
	 * @param piece La piece a deplacer
	 * @param deplacement Le deplacement que la piece doit effectuer
	 */
	public void deplacer(Piece piece, Deplacement deplacement) {
		// TODO - implement IA.deplacer
		throw new UnsupportedOperationException();
	}




	/**
	 * @return renvoie la difficulte de l'IA
	 */
	public Difficulte getDifficulte()
	{
		return this.difficulte;
	}
	
}