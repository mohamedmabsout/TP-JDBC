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
public class Personne {
    protected int id;
    protected String nom;
    protected double salaire;

    public Personne( String nom, double salaire) {
        
        this.nom = nom;
        this.salaire = salaire;
    }

    public Personne() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
 

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
     public void afficher() {
        System.out.println("Nom : " + nom + ", Salaire : " + salaire);
    }

    
    
}
