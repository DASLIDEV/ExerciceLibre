package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EtudiantDAO {
	public Etudiant getById(int id) {
		Etudiant etudiant = new Etudiant();
		try {
			PreparedStatement get = Database.connect.prepareStatement("SELECT * FROM etudiant "
					+ "WHERE idEtudiant = ?");
			get.setInt(1, id);
			ResultSet result = get.executeQuery();
			if(result.next()) {
				etudiant.setIdEtudiant(result.getInt(1));
				etudiant.setNom(result.getString(2));
				etudiant.setPrenom(result.getString(3));
				etudiant.setMail(result.getString(4));
				etudiant.setIdConvention(result.getInt(5));
			}
			System.out.println("Got student");
		} catch (SQLException e) {
			System.out.println("Student not found");
			e.printStackTrace();
		}
		return etudiant;
	}
	
	public ArrayList<Etudiant> getAll() {
		ArrayList<Etudiant> etudiants = new ArrayList<>();
		try {
			PreparedStatement get = Database.connect.prepareStatement("SELECT * FROM etudiant");
			ResultSet result = get.executeQuery();
			while(result.next()) {
				Etudiant etudiant = new Etudiant();
				etudiant.setIdEtudiant(result.getInt(1));
				etudiant.setNom(result.getString(2));
				etudiant.setPrenom(result.getString(3));
				etudiant.setMail(result.getString(4));
				etudiant.setIdConvention(result.getInt(5));
				etudiants.add(etudiant);
			}
			System.out.println("Got all the students");
		} catch (SQLException e) {
			System.out.println("Students not found");
			e.printStackTrace();
		}
		return etudiants;
	}
}
