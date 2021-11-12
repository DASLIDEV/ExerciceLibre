package models;

public class Attestation {
	private int idAttestation;
	private	int idEtudiant;
	private int idConvention;
	private String message;
	
	public Attestation() {
	}
	
	public Attestation(int idAttestation, int idEtudiant, int idConvention, String message) {
		this.idAttestation = idAttestation;
		this.idEtudiant = idEtudiant;
		this.idConvention = idConvention;
		this.message = message;
	}

	public int getIdAttestation() {
		return idAttestation;
	}

	public void setIdAttestation(int idAttestation) {
		this.idAttestation = idAttestation;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public int getIdConvention() {
		return idConvention;
	}

	public void setIdConvention(int idConvention) {
		this.idConvention = idConvention;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
