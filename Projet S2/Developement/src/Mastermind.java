/**
* Classe Mastermind
* 
*@author 
*@version 1.0
*
*/



public class Mastermind
{	

			// Teste des classes 
	public static void main(String[] args)
	{
		Joueur j1 = new Joueur("Jacquie");

		Partie partie = new Partie(j1,5);
		// Joueur choisit les paramètres
			// nombre de pion dans la cbS -> par défaut 4 sinon il faut utiliser setNombrePion
			// Choisit les couleurs disponibles
			// -> Ajouter les couleurs
		partie.setNombrePion(4);



			// Le joueur choisit les couleurs disponibles dans la partie 
		/*Couleur[] couleur = new Couleur[5];
		for (int i = 0; i <= 4; i++)
		{ 
			couleur[i] = new Couleur("bleu");
		}
		partie.setCouleursDisp(couleur);
		partie.toString();*/
		//System.out.println(partie);
		//partie.choixCombi();


				// Le joueur choisit les pions dans sa combinaisons.
		// Un truc beaucoup mieux que ça !

		String entres = "";
		/*System.out.println("Entre les couleurs de ta combinaison: ");
		for ( int i =0 ; i < partie.getNombrePion() ; i++ ) 
		{
			System.out.println(i + " couleur: ");
			entres = Clavier.readString();
		}
		*/
		//partie.getCombiJoueur()

		//System.out.println("Entre les couleurs de ta combinaison: ");

			

			// Craquage du code par l'ordinateur
		boolean trouve=false;
		/*while (!trouve)
		{
			trouve = partie.combiEquivalente(); //--> Fait que l'ordinateur propose une combi et teste si c'est vrai.
			// Affiche les propositions déjà proposés.
			partie.affichage();
		}*/
		partie.initCombi();
		System.out.println(partie.affichage());

		System.out.println("FIn nein");

		
	}
}