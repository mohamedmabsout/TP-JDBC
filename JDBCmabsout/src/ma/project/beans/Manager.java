/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.beans;

/**
 *
 * @author hp
 */
public class Manager extends Personne {

    
    public Manager(String nom, double salaire) {
        super(nom, salaire);
    }
    public void afficher() {
        System.out.println("Nom : " + nom + ", Salaire : " + salaire);
    }
    
}

    

