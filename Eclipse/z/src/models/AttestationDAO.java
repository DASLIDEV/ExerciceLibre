package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttestationDAO {
	
	public void save(Attestation attestation){
		if(attestation.getIdAttestation() != 0) {
			try {
				PreparedStatement update = Database.connect.prepareStatement(
						"UPDATE attestation SET idEtudiant = ?, idConvention = ?, message = ? WHERE idAttestation = ?");
				update.setInt(1, attestation.getIdEtudiant());
				update.setInt(2, attestation.getIdConvention());
				update.setString(3, attestation.getMessage());
				update.setInt(4, attestation.getIdAttestation());
				update.executeUpdate();
				System.out.println("Attestation updated.");
			} catch (SQLException e) {
				System.out.println("Attestation  not updated.");
				e.printStackTrace();
			}
		}
		else {
			try {
				PreparedStatement create = Database.connect.prepareStatement(
						"INSERT INTO attestation(idEtudiant, idConvention, message) "
						+ "VALUES(?, ?, ?)");
				create.setInt(1, attestation.getIdEtudiant());
				create.setInt(2, attestation.getIdConvention());
				create.setString(3, attestation.getMessage());
				create.executeUpdate();
				System.out.println("Attestation saved.");
			} catch (SQLException e) {
				System.out.println("Attestation not saved.");
				e.printStackTrace();
			}
		}
	}
	public Attestation getById(int id) {
		
		Attestation attestation = new Attestation();
		try {
			PreparedStatement get = Database.connect.prepareStatement("SELECT * FROM attestation "
					+ "WHERE idAttestation = ?");
			get.setInt(1, id);
			ResultSet result = get.executeQuery();
			if(result.next()) {
				attestation.setIdAttestation(result.getInt(1));
				attestation.setIdEtudiant(result.getInt(2));
				attestation.setIdConvention(result.getInt(3));
				attestation.setMessage(result.getString(4));
			}
			System.out.println("Got attestation");
		} catch (SQLException e) {
			System.out.println("Attestation not found");
			e.printStackTrace();
		}
		return attestation;
	}
	
	public ArrayList<Attestation> getAll() {
		ArrayList<Attestation> attestations = new ArrayList<>();
		try {
			PreparedStatement get = Database.connect.prepareStatement("SELECT * FROM attestation");
			ResultSet result = get.executeQuery();
			while(result.next()) {
				Attestation attestation = new Attestation();
				attestation.setIdAttestation(result.getInt(1));
				attestation.setIdEtudiant(result.getInt(2));
				attestation.setIdConvention(result.getInt(3));
				attestation.setMessage(result.getString(4));
				attestations.add(attestation);
			}
			System.out.println("Got all the attestations");
		} catch (SQLException e) {
			System.out.println("Attestations not found");
			e.printStackTrace();
		}
		return attestations;
	}
}
