/**
* Classe Partie
* 
*@author 
*@version 1.0
*
*/
package Jeu;
import Libs.*;
import CPU.Answer;
import CPU.Code;
import CPU.implementations.BasicStrategy;

public class Partie
{
	private Joueur joueur;
	private Combinaison combinaison;
	//private BasicStrategy ordinateur;
	private int nbToursMax;
	private Combinaison[] combi_Enregistrer;
	private Combinaison[] combi_indice;
	private int numero_tour;
/** 
*Constructeur de la classe Partie
*@param pseudo Pseudo du joueur
*@param nbToursMax nombres d'essais possibles pour le joueur.
*/

	public Partie(Joueur joueur,int nbToursMax)
	{
		this.combi_Enregistrer = new Combinaison[nbToursMax];
		this.combi_indice = new Combinaison[nbToursMax];
		this.joueur = new Joueur("Joueur1");
		this.nbToursMax = nbToursMax;
		this.numero_tour = 0;
		//this.ordinateur = new Ordinateur();
	}

/**
 * Constructeur de la classe partie sans paramètres
 */
	public Partie()
	{
		this.joueur = new Joueur("Joueur1");
		this.nbToursMax = 8;
		//this.ordinateur = new BasicStrategy();
	}

/**
 * Changer la combinaison secr�te
 */
	public void setCombiJoueur()
	{
		
		this.combinaison = this.joueur.getCombi();
		System.out.println("jjjjjjjj"+this.combinaison);
	}

	public int getNbPion()
	{
		return this.joueur.getCombi().getNombrePion();
	}
/** 
*- Test l'equivalence de la derni�re combi r�cup
 - renvoi vrai si les meme
 - ajoute une combi de pion indice pour lesquels pions sont bien plac�s
*@return Retourne Vrai si la combinaison à été trouvé Faux si non.
*/
	public boolean testEquivalence() {
		/* - Test l'equivalence de la derni�re combi r�cup
		   - renvoi vrai si les meme
		   - ajoute une combi de pion indice pour lesquels pions sont bien plac�s
		  */
		int nb_pion = this.combinaison.getNombrePion();
		this.combi_indice[this.numero_tour] = new Combinaison();
		//this.combi_indice[this.numero_tour] = new Combinaison(Couleur.RED,Couleur.RED,Couleur.RED,Couleur.RED);
		
		boolean retour = false;
		
		if ( this.combi_Enregistrer[this.numero_tour].equals(this.combinaison)){
			retour = true;
			this.combi_indice[this.numero_tour] = new Combinaison(Couleur.RED,Couleur.RED,Couleur.RED,Couleur.RED);
		}
		else
		{
			int nb_bien_placeCouleur = this.combinaison.getNbBienPlaceCouleur(this.combi_Enregistrer[this.numero_tour]);
			int nb_mauvaise_couleur = this.combinaison.nb_mauvaise_couleur(this.combi_Enregistrer[this.numero_tour]);
			
			//--> nb_indice_rouge = nb_bien_placeCouleur
			int nb_indice_blanc = nb_pion -(nb_bien_placeCouleur  + nb_mauvaise_couleur);
			
			for (int i = 0; i < nb_indice_blanc;i++) {
				this.combi_indice[this.numero_tour].setPionCombinaison(i, new PionIndice(Couleur.WHITE));
			}
			
			for (int i= 0; i< nb_bien_placeCouleur;i++){
				this.combi_indice[this.numero_tour].setPionCombinaison(i+nb_indice_blanc, new PionIndice(Couleur.RED));
			}
			
		}
		
		
		return retour;
		
	}
	
	
	/** 
	*- Recup�re la solution de l'ordi et l'ajoute dans les anciennes combi
	*
	*/
	public void combiOrdinateur() {
		/* Recup�re la solution de l'ordi et l'ajoute dans les anciennes combi
		 */
		//this.combi_test[ this.combi_test.lenght() ] = this.ordinateur.getCombiCreer(); ?
		Combinaison comb_test = new Combinaison( this.joueur.getCombi().getNombrePion());
		comb_test.test();
		
		this.combi_Enregistrer[ this.numero_tour] = comb_test;

		
		 
	}

public void setNbPion(int nb) {
	this.joueur.setNbPion(nb);
	
}

public Joueur getJoueur()
{
	return this.joueur;
}


/** 
*    - afficher la combi du joueur
*    - afficher toutes les combi de l'ordi
*	 -afficher nb d'essais
*	 -( afficher score)
*	 - affiche les indices
*/
public void affichage() {
	/* afficher la combi du joueur
	 - afficher toutes les combi de l'ordi
	 -afficher nb d'essais
	 -( afficher score)
	 -affiche les indices
	 
	*/ 
	System.out.println("+ - - - Tour "+ this.numero_tour+ " - - - +\n");
	System.out.println("- - - -  "+ this.combinaison.toString()+"  - - - - -\n");
	String chaine ="";
	
	for (int i =0; i<= this.numero_tour;i++)
	{

		chaine = chaine+ i + " -- " + this.combi_Enregistrer[i] + "    " + this.combi_indice[i] +"\n";
	}
	System.out.println(chaine);
	if (testEquivalence()){
		System.out.println("Perdu : L'ordinateur � trouver votre code !");
	}
	else {
		System.out.println("Appuyez sur une touche pour continuer...");
	}
	
	
	}

	public void increTour(){
		this.numero_tour=numero_tour+1;
	}


}