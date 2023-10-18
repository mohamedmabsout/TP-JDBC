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
import ma.project.beans.Manager;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author Asmaa
 */
public class ManagerService implements IDao <Manager> {
      @Override
public boolean create(Manager M) {
    try {
    String req = "insert into manageer (id, nom, salaire) values(?,?,?)";
    PreparedStatement ps =
    Connexion.getConnection().prepareStatement(req);
    ps.setInt(1, M.getId());
    ps.setString(2, M.getNom());
    ps.setDouble(3, M.getSalaire());
    if (ps.executeUpdate() == 1) {
    return true;
    }
    } catch (SQLException ex) {
    System.out.println("Erreur de la connexion");
    }
    return false;
    }

    @Override
    public boolean update(Manager M) {
        try {
    String req = "update manager set nom = ? , salaire = ? where id =?";
    PreparedStatement ps =
    Connexion.getConnection().prepareStatement(req);
    ps.setString(1, M.getNom());
    ps.setDouble(2, M.getSalaire());
    ps.setInt(3, M.getId());
    if (ps.executeUpdate() == 1) {
    return true;
    }
    } catch (SQLException ex) {
    System.out.println("Erreur de faire la màj");
    }
    return false;
    }
    @Override
    public boolean delete(Manager M) {
         try {
    String req = "delete from manager where id = ?";
    PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    ps.setInt(1, M.getId());
    if (ps.executeUpdate() == 1) {
    return true;
    }
    } catch (SQLException ex) {
   System.out.println("Impossible de supprimer le manager");
    }
    return false;
    }
    
    @Override
    public Manager getById(int id) {
   Manager ma = null;
   try {
    String req = "select * from manager where id = ?";
    PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if(rs.next())
    ma = new Manager(rs.getString("nom"), rs.getDouble("salaire"));
    } catch (SQLException ex) {
    System.out.println("Impossible de trouver ce manager "+ ma.getNom());
    }
  

    return ma;
    }
    @Override
    public List<Manager> getAll() {
    List<Manager> ma = new ArrayList<>();
    try {
    String req = "select * from manager ";
    PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    ma.add(new Manager( rs.getString("nom"), rs.getDouble("salaire")));
    } 
   
    }   catch (SQLException ex) {
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE, null, ex);
        }
     return ma;
    }
}
