/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.projet_1;

import java.io.IOException;

/**
 *
 * @author X_Pet
 */
public class MenuPrincipal {
    
    public void demarrerMenuPrincipal(ListeCours lstCours, ListeEtudiant lstEtudiant) throws IOException{
        
        // Menu
        System.out.println("\n-----------------{ MENU PRINCIPAL }------------------\n\n" 
                + "1. Lister les cours encore disponibles\n"
                + "2. Lister les étudiants inscrits à un cours donné\n"
                + "3. Lister les cours d'un étudiant\n"
                + "4. Modification d'une inscription\n"
                + "5. Quitter");
        
        int choix = (int) Utilitaires.lireEntier("Entrez votre choix: ");
        System.out.println();
        
        // liste des choix
        switch(choix){
            case 1:
                listerCoursDisponibles(lstCours);
                break;
            case 2:
                listerEtudiant(lstCours, lstEtudiant);
                break;
            case 3:
                listerCours(lstCours, lstEtudiant);
                break;
            case 4: 
                afficherSousMenu(lstCours, lstEtudiant);
                break;
            case 5:
                quitter();
        }
        
    }// Demarrer menu principal
    
    private void listerCoursDisponibles(ListeCours lstCours){
        
        for(int i = 0; i < lstCours.getNBCours(); i++){
            // cherche les cours qui sont pas plein
            if(lstCours.getLstCours()[i].getNbrEtu() < lstCours.getLstCours()[i].getNbrMax()){
                System.out.println(lstCours.getLstCours()[i].toString());
            }
 
        }
        
    }
    
    private void listerEtudiant(ListeCours lstCours, ListeEtudiant lstEtudiant){
        String choix =  Utilitaires.lireString("Entrez le numéro du cours: ");
        
        // [i] cherche les cours
        for(int i = 0; i < lstCours.getNBCours(); i++){
            
            // [i] cherche le sigle demandé
            if(lstCours.getLstCours()[i].getSigle().equals(choix)){
                if(lstCours.getLstCours()[i].getNbrEtu() == 0){
                    System.out.println("Aucun étudiant n'est inscrit au cour: " + lstCours.getLstCours()[i].getSigle());
                    return;
                }
                lstCours.getLstCours()[i].afficherListeEtudiant();
                return;
            }    
        }
        
        System.out.println("Désolé, ce cours n'existe pas.");

    }
    
    private void listerCours(ListeCours lstCours, ListeEtudiant lstEtudiant){
        int choix = (int) Utilitaires.lireEntier("Entrez votre numéro de DA: ");
        String nom;
        
        // si l'étudiant n'est pas dans le systeme 
        try{
            nom = lstEtudiant.trouver(choix).getPrenomNom();
        } catch(Exception e){
            System.out.println("\nL'étudiant donné n'existe pas.\n" + "-----------------------------------------------------\n");
            return;
        }

        // [i] cherche le cour demandé
        for(int i = 0; i < lstCours.getNBCours(); i++){
            
            // [i] cherche les cours de l'étudiant
                if(lstEtudiant.getLstEtu()[i].getPrenomNom().equals(nom)) {

                        lstEtudiant.getLstEtu()[i].afficherListeCours();
                        return;
                    
                }
        }
        
        System.out.println("L'étudiant: " + nom + " n'est pas inscrit à un cours");
        
        
    } // listerCours
    
    private void afficherSousMenu(ListeCours lstCours, ListeEtudiant lstEtudiant){
        // Sous menu
        System.out.println("\n-----------------------------------------------------\n"
                        + "1 - Annulation\n"
                        + "2 - Inscription\n"
                        + "-----------------------------------------------------\n");
                int choix = (int) Utilitaires.lireEntier("Entrez votre choix: ");
                System.out.println();
                
                if(choix == 1){
                    annulerCours(lstCours, lstEtudiant);
                } else if(choix == 2){
                    ajouterCours(lstCours, lstEtudiant);
                }
    } // afficherSousMenu
    
    private void annulerCours(ListeCours lstCours, ListeEtudiant lstEtudiant){
        
        // On demande le DA et le sisgle du cours
        int DA = (int) Utilitaires.lireEntier("Entrez votre numéro de DA: ");
        String cours =  Utilitaires.lireString("Entrez le sigle du cours: ");
        System.out.println();
        String nom;
        
        // Vérifie si le DA existe
        try{
            nom = lstEtudiant.trouver(DA).getPrenomNom();
        } catch(Exception e){
            System.out.println("Erreur, veuillez mettre une valeur cohérente");   
            return;
        }
        
        // [i] cherche le sigle du cour
        for(int i = 0; i < lstCours.getNBCours(); i++){
            
            // [i] vérifie que le cour existe
            if(lstCours.getLstCours()[i].getSigle().equals(cours)){
                
                // [j] cherche les etudiants dans le cour
                for(int j = 0; j < lstEtudiant.getNbrEtu(); j++){
                    
                    // [i] vérifie si l`étudiant est inscrit
                    if(lstEtudiant.getLstEtu()[j].getPrenomNom().equals(nom)){
                        lstEtudiant.getLstEtu()[j].supprimerCours(lstCours.getLstCours()[i]);
                        lstCours.getLstCours()[i].supprimerEtudiant(lstEtudiant.getLstEtu()[j]);
                        System.out.println("Cours " + lstCours.getLstCours()[i].getDescription() + " supprimé");
                        return;
                    }

                }
                System.out.println("Cet etudiant n'est pas inscrit au cour.");
                return;
            } 
        System.out.println("Ce cours n'existe pas");
            
        }
        
    } // annuler cour
    
    private void ajouterCours(ListeCours lstCours, ListeEtudiant lstEtudiant){
        
        // On demande le DA et le sisgle du cours
        int DA = (int) Utilitaires.lireEntier("Entrez votre numéro de DA: ");
        String cours =  Utilitaires.lireString("Entrez le numéro du cours: ");
        System.out.println();
        String nom;
        String sigle;
        String description;
        
        // Vérifie si le DA existe
        try{
            nom = lstEtudiant.trouver(DA).getPrenomNom();
        } catch(Exception e){
            System.out.println("Erreur, veuillez mettre une valeur cohérente");   
            return;
        }

        // [i] cherche le sigle du cour
        for(int i = 0; i < lstCours.getNBCours(); i++){
            
            // [i] vérifie que le cour existe
            if(lstCours.getLstCours()[i].getSigle().equals(cours)){

                    // [i] vérifie si le cour n'est pas plein
                    if(lstCours.getLstCours()[i].getNbrEtu() < lstCours.getLstCours()[i].getNbrMax()){
                        
                        // [w] cherche l'étudiant
                        for(int w = 0; w < lstEtudiant.getNbrEtu(); w++){
                            
                            // [w] si c'est l'étudiant
                            if(lstEtudiant.getLstEtu()[w].getPrenomNom().equals(nom)) {
                                // w = etudiant, j = etudiants du cour, i = cour
                                
                                lstEtudiant.getLstEtu()[w].getProgramme();
                                lstEtudiant.getLstEtu()[w].getStrDateAdmission();
                                
                                sigle = lstCours.getLstCours()[i].getSigle();
                                description = lstCours.getLstCours()[i].getDescription();
                                
                                for(int j = 0; j < lstCours.getLstCours()[i].getNbrEtu(); j++){
                                    // voir si l'etudiant est deja inscrit
                                    if(lstCours.getLstCours()[i].getTabEtudiants()[j].getPrenomNom().equals(nom)){
                                        System.out.println("Vous êtes déja inscrit à ce cours.");
                                        return;
                                    }
                                }    
                                lstCours.getLstCours()[i].ajouterEtudiant(lstEtudiant.getLstEtu()[w]); 
                                lstEtudiant.getLstEtu()[w].ajouterCours(lstCours.getLstCours()[i]);

                                lstCours.getLstCours()[i].setSigle(sigle);
                                lstCours.getLstCours()[i].setStrDescription(description);
                                
                                System.out.println("Inscription au cour:" + lstCours.getLstCours()[i].getDescription() 
                                        + " fait avec succèss!" 
                                        + "\n-----------------------------------------------------\n");
                                return;
                            }
                        }
                    } else{
                        System.out.println("Désolé, ce cours est plein.");
                        break;
                    }
                    
            }
        }
        System.out.println("Ce cour n'existe pas");
        
    } // ajouter cour
    
    private boolean quitter(){
        System.out.println();
        System.out.println("Au revoir!");
        System.exit(0);
        return false;
    } // quitter
    
}//class
