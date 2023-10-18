/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.project.beans.Developpeur;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author Asmaa
 */
public class DeveloppeurService implements IDao <Developpeur>{

    @Override
  public boolean create(Developpeur D) {
    try {
    String req = "insert into developpeur (id, nom, salaire) values(?,?,?)";
    PreparedStatement ps =
    Connexion.getConnection().prepareStatement(req);
    ps.setInt(1, D.getId());
    ps.setString(2, D.getNom());
    ps.setDouble(3, D.getSalaire());
    if (ps.executeUpdate() == 1) {
    return true;
    }
    } catch (SQLException ex) {
    System.out.println("Erreur de la connexion");
    }
    return false;
    }

    @Override
    public boolean update(Developpeur D) {
        try {
    String req = "update developpeur set nom = ? , salaire = ? where id =?";
    PreparedStatement ps =
    Connexion.getConnection().prepareStatement(req);
    ps.setString(1, D.getNom());
    ps.setDouble(2, D.getSalaire());
    ps.setInt(3, D.getId());
    if (ps.executeUpdate() == 1) {
    return true;
    }
    } catch (SQLException ex) {
    Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
    }
    return false;
    }
    @Override
    public boolean delete(Developpeur D) {
         try {
    String req = "delete from developpeur where id = ?";
    PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    ps.setInt(1, D.getId());
    if (ps.executeUpdate() == 1) {
    return true;
    }
    } catch (SQLException ex) {
    Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
    }
    return false;
    }
    @Override
    public Developpeur getById(int id) {
     Developpeur dev = null;
   try {
    String req = "select * from developpeur where id = ?";
    PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if(rs.next())
    dev = new Developpeur(  rs.getString("nom"), rs.getDouble("salaire"));
    } catch (SQLException ex) {
    System.out.println("Impossible de trouver ce developpeur "+ dev.getNom());
    }
    return dev;
    }
    @Override
    public List<Developpeur> getAll() {
    List<Developpeur> dev = new ArrayList<>();
    try {
    String req = "select * from developpeur ";
    PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    dev.add(new Developpeur( rs.getString("nom"), rs.getDouble("salaire")));
    } 
   
    }   catch (SQLException ex) {
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE, null, ex);
        }
     return dev;
    }
}