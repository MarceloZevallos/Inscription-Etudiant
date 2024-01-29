/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet_1;

/**
 *
 * @author X_Pet
 */
public class Etudiant {
    
    private int intNumDA ; //pour identification unique de l’étudiant
    private String strPrenomNom;//prenom et nom de l’étudiant
    private EnumProgramme programme;//Programme auquel l’étudiant est inscrit
    private String strDateAdmission; //en format AAAA ou AAAA-MM
    private Cours tabCours[] = new Cours[5];//l’étudiant peut être inscrit à 5 cours au maximum
    private int intNbreCours ; // nombre de cours effectivement suivis par l’étudiant
    
    public Etudiant (int intNumDA, String strPrenomNom, EnumProgramme programme, String strDateAdmission){
        this.intNumDA = intNumDA;
        this.strPrenomNom = strPrenomNom;
        this.programme = programme;
        this.strDateAdmission = strDateAdmission;
    } // Constructeur Etudiant
    
    public String toString() {
        return "Numéro : " + intNumDA + "\nPrénom et Nom : " + strPrenomNom + "\nProgramme : " + programme
                    + "\nDate d’admission : " + strDateAdmission + "\n";
    } // toString
    
    public void afficherListeCours() {
        for(int i = 0; i < tabCours.length; i++){
            if(tabCours.length < 1){
                return;
            } else if(tabCours[i] != null){
                System.out.println("Voici vos cours: ");
                System.out.println(tabCours[i].toString());
                System.out.println();
            }
           
        }
    }// afficherListeCours
    
    public void ajouterCours(Cours c){
        for(int i = 0; i < intNbreCours; i++){
            if(c.getTabEtudiants()[i].getPrenomNom().equals(tabCours[i].getTabEtudiants()[i].getPrenomNom())){
                System.out.println("Ce cours a deja ete choisi");
                return;
            }
        }
        tabCours[intNbreCours] = c;
        intNbreCours++;
        //c.ajouterEtudiant(etu);
       
        System.out.println("Cours ajouté");
        
    }// ajouterCours
    
    public void supprimerCours(Cours c){
        for(int i = 0; i < intNbreCours; i++){
            if(c.equals(tabCours[i])){
                tabCours[i] = null;
                boolean tab=false;

                // enleve l'espace nulle
		while (!tab){
			tab=true;
			//System.out.println(tabTrie);
			for(int j = i+1; j < tabCours.length-1; j++) {
				//System.out.println(i);
				if (tabCours[j] != null){
					Cours temp = tabCours[j];
					tabCours[j]= tabCours[j+1];
					tabCours[j+1]= temp;
					tab= false;	
				}
			}
		}
                intNbreCours--;
                
            }
        }
        System.out.println("Ce cours n'a pas été choisi");
        
    } // supprimer cour
    
    int getNumDA(){
        return intNumDA;
    }
    
    String getPrenomNom(){
        return strPrenomNom;
    }
    
    public EnumProgramme getProgramme() {
        return programme;
    }

    public String getStrDateAdmission() {
        return strDateAdmission;
    }
    
    public Cours[] getTabCours() {
        return tabCours;
    }

    public void setTabCours(Cours tabCours) {
        this.tabCours[intNbreCours] = tabCours;
        intNbreCours++;
    }

    public int getIntNbreCours() {
        return intNbreCours;
    }
    
}//class
