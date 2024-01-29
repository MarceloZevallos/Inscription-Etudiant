package gg.sim.mzevallos.projet_1;

import java.io.*;
import java.util.*;

public class ListeEtudiant {

	private Etudiant lstEtudiants[] = new Etudiant[100]; // pour stocker les �tudiants
	private int intNbreElements; // nombre d��tudiants dans le tableau

	public ListeEtudiant (String strNomFichier) {
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		Etudiant objEtudiant;

		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		intNbreElements = 0;
		try {

			while ((strLigne = brFichier.readLine())!= null){
				//System.out.println(strLigne);
				st = new StringTokenizer(strLigne, ",");
				// remplir le tableau
				objEtudiant = new Etudiant(Integer.parseInt(st.nextToken().trim()), st.nextToken().trim(), EnumProgramme.getEnum(st.nextToken()), st.nextToken());
				inserer(objEtudiant);
			}  

		} catch (Exception e) {
			System.out.println(e.toString());
			//e.printStackTrace();
		}
		
		System.out.println("Nombre d'étudiants:" + intNbreElements); // affiche nbr etu
	} // Construccteur ListeEtudiant
	
	private void inserer (Etudiant objEtudiant) { 
		int intPlaceInsertion = 0;
		boolean booPlaceTrouve = false;
		int intNumDA = objEtudiant.getNumDA();
		
		assert intNbreElements < 100 : "erreur: trop d'étudiants";

		while ( intPlaceInsertion < intNbreElements && !booPlaceTrouve) {
			// v�rifier si c'est l'endroit pour ins�rer sinon avancer
			if ( intNumDA < lstEtudiants[intPlaceInsertion].getNumDA()) {
				booPlaceTrouve= true ;
			}
			else {
				intPlaceInsertion++;
			}
		}

		// d�caler en commen�ant par la fin
		for( int j = intNbreElements-1; j>= intPlaceInsertion; j--){
			lstEtudiants[j+1]= lstEtudiants[j];
		}

		// ajouter la valeur au bon endroit
		lstEtudiants[intPlaceInsertion]= objEtudiant;

		intNbreElements++;		
	}// inserer
        
        public Etudiant trouver(int intNumDA){
            
            for(int i = 0; i < lstEtudiants.length; i++){
                if(lstEtudiants[i].getNumDA() == intNumDA){
                    System.out.println("Utilisateur trouvé: " + lstEtudiants[i].getPrenomNom());
                    return lstEtudiants[i];
                }
            }
            
            System.out.println("Désolé, mais l'utilisateur donné n'existe pas.");
            return null;
        }// trouver étudiant
        
        int getNbrEtu(){
            return intNbreElements;
        }
        
        Etudiant[] getLstEtu(){
            return lstEtudiants;
        }
        
}// ListeEtudiant

