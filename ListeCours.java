package gg.sim.mzevallos.projet_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ListeCours {
	private Cours lstCours[] = new Cours[50]; //pour stocker les cours
	private int intNbreElements; //nombre de cours dans le tableau 

	public ListeCours ( String strNomFichier) {
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		Cours objCours;

		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		intNbreElements = 0;
		try {

			while ((strLigne = brFichier.readLine())!= null){
				st = new StringTokenizer(strLigne, ","); // METTRE E DEHORS DE LA BOUCLE !!!
				// remplir le tableau
				objCours = new Cours(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()));
				lstCours[intNbreElements] = objCours;
				intNbreElements += 1;
				assert intNbreElements <= 100 : "erreur: trop de cours.";
			}  

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		triTableau();
		System.out.println("Nombre de cours:" + intNbreElements); //affiche le nbr de cours
	} //Constructeur ListeCours
	
	private void triTableau() {
		boolean tabTrie=false;

		while (!tabTrie){
			tabTrie=true;
			for(int i = 0; i < intNbreElements - 1; i++) {
				if (lstCours[i].getSigle().compareTo(lstCours[i+1].getSigle()) > 0){
					Cours temp = lstCours[i];
					lstCours[i]= lstCours[i+1];
					lstCours[i+1]= temp;
					tabTrie= false;	
				}
			}
		}
	}// triTableau
	
	public Cours[] getLstCours() {
		return lstCours;
	}
	
	public int getNBCours() {
		return intNbreElements;
	}
        
        public Cours trouver(String strSigle){
            
            for(int i = 0; i < lstCours.length; i++){
                if(lstCours[i].getSigle()== strSigle){
                    System.out.println("Cours trouvé: " + lstCours[i].getDescription());
                    return lstCours[i];
                }
            }
            
            return null;
        } // trouver

} // ListeCours
