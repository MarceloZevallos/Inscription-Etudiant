/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet_1;

/**
 *
 * @author X_Pet
 */
public class Cours {
    
    private String strSigle; //sigle du cours ex : 420-202-RE
    private String strDescription; //description du cours ex: Structure de données
    private Etudiant[]tabEtudiants; //tableau de références d’objets Etudiants inscrits //au cours
    private int intNbreEtudiants; //nombre d’étudiants inscrits au cours
    private int intNbreMax; //nombre maximum d’étudiants pour le cours.
    
    public Cours(String strSigle, String strDescription, int intNbreEtudiants, int intNbreMax ){
        this.strSigle = strSigle;
        this.strDescription = strDescription;
        this.intNbreEtudiants = intNbreEtudiants;
        this.intNbreMax = intNbreMax;
        this.tabEtudiants = new Etudiant[intNbreMax];
    } // Constructeur Cours
    
    public String toString(){
        return "Sigle : " + strSigle + "\nCours : " + strDescription + "\nnombre d'étudiant : " + intNbreEtudiants
                    + "\nnombre maximum d'étudiant: " + intNbreMax + "\n";
    }// toString
    
    public void afficherListeEtudiant(){
        for(int i = 0; i < intNbreEtudiants; i++){
            if(tabEtudiants.length == 0){
                break;
            }
            System.out.println("Voici les étudiants du cour: ");
            System.out.println(tabEtudiants[i].toString());
            System.out.println();
        }
    }// afficherListeEtudiant
    
    // On ajoute l'étudiant au cour
    public void ajouterEtudiant(Etudiant etu){
        for(int i = 0; i < intNbreMax; i++){
            try{
                if(etu.getTabCours()[i].getSigle().equals(tabEtudiants[i].getTabCours()[i].getSigle())){
                    System.out.println("Ce cours a deja ete choisi");
                    return;
                } 
            } catch(Exception e){
                //System.out.println("null");
            }
            
        }
        tabEtudiants[intNbreEtudiants] = etu;
        intNbreEtudiants++;
        System.out.println("Etudiant ajouté");
        
    } // ajouterEtudiant
    
    public void supprimerEtudiant(Etudiant etu){
        for(int i = 0; i < intNbreMax; i++){
            if(etu.equals(tabEtudiants[i])){
                tabEtudiants[i] = null;
                boolean tabTrie = false;
                
                // on enlève l'espace nulle
                while (!tabTrie){
			tabTrie=true;
			//System.out.println(tabTrie);
			for(int j = 0; j < tabEtudiants.length-1; j++) {
				//System.out.println(i);
				if (tabEtudiants[j] == null && tabEtudiants[j + 1] != null){
					tabEtudiants[j]= tabEtudiants[j+1];
				}
			}
		}
                intNbreEtudiants--;
                return;
            }
        }
    System.out.println("Ce cours n'a pas été choisi");
    } // supprimerEtudiant
    
    String getSigle(){
        return strSigle;
    }

    public void setSigle(String strSigle) {
        this.strSigle = strSigle;
    }
    
    String getDescription(){
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
    int getNbrMax(){
        return intNbreMax;
    }
    
    int getNbrEtu(){
        return intNbreEtudiants;
    }
    
    public void setIntNbreEtudiants(int intNbreEtudiants) {
        this.intNbreEtudiants = intNbreEtudiants;
    }

    public Etudiant[] getTabEtudiants() {
        return tabEtudiants;
    }
    
}//Cours
