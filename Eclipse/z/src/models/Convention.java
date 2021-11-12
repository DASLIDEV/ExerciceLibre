package models;

public class Convention {
	private int idConvention;
	private String nom;
	private int nbHeur;
	
	public Convention() {
	}
	
	public Convention(int idConvention, String nom, int nbHeur) {
		this.idConvention = idConvention;
		this.nom = nom;
		this.nbHeur = nbHeur;
	}

	public int getIdConvention() {
		return idConvention;
	}

	public void setIdConvention(int idConvention) {
		this.idConvention = idConvention;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbHeur() {
		return nbHeur;
	}

	public void setNbHeur(int nbHeur) {
		this.nbHeur = nbHeur;
	}
	
}

