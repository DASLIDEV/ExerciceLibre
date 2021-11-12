package models;

public class Etudiant {
	private int idEtudiant;
	private String nom;
	private String prenom;
	private String mail;
	private int idConvention;
	
	public Etudiant(int idEtudiant, String nom, String prenom, String mail, int idConvention) {
		super();
		this.idEtudiant = idEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.idConvention = idConvention;
	}

	public Etudiant() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getIdConvention() {
		return idConvention;
	}

	public void setIdConvention(int idConvention) {
		this.idConvention = idConvention;
	}
}
