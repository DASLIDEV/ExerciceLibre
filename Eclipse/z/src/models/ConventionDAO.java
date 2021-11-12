package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConventionDAO {
	
	public Convention getById(int id) {
		Convention convention = new Convention();
		try {
			PreparedStatement get = Database.connect.prepareStatement("SELECT * FROM Convention "
					+ "WHERE idConvention = ?");
			get.setInt(1, id);
			ResultSet result = get.executeQuery();
			if(result.next()) {
				convention.setIdConvention(result.getInt(1));
				convention.setNom(result.getString(2));
				convention.setNbHeur(result.getInt(3));
			}
			System.out.println("Got convention");
		} catch (SQLException e) {
			System.out.println("Convention not found");
			e.printStackTrace();
		}
		return convention;
	}
	
	public ArrayList<Convention> getAll() {
		ArrayList<Convention> conventions = new ArrayList<>();
		try {
			PreparedStatement get = Database.connect.prepareStatement("SELECT * FROM convention");
			ResultSet result = get.executeQuery();
			while(result.next()) {
				Convention convention = new Convention();
				convention.setIdConvention(result.getInt(1));
				convention.setNom(result.getString(2));
				convention.setNbHeur(result.getInt(3));
				conventions.add(convention);
			}
			System.out.println("Got all the conventions");
		} catch (SQLException e) {
			System.out.println("Conventions not found");
			e.printStackTrace();
		}
		return conventions;
	}
}
