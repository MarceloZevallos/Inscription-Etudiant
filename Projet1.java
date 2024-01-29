/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gg.sim.mzevallos.projet_1;

import java.io.IOException;


/**
 *
 * @author X_Pet
 */
public class /*Inscription*/ Projet1 {

    public static void main(String[] args) throws IOException {
        System.out.println("Projet 1 fait par Marcelo Zevallos!");
        boolean continuer = true;
        ListeCours lc = new ListeCours("cours.txt");
        ListeEtudiant le = new ListeEtudiant("etudiants.txt");
        
        MenuPrincipal menu = new MenuPrincipal();
        
        while(continuer){
            menu.demarrerMenuPrincipal(lc, le);
        }
    }
}
