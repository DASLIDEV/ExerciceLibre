package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Attestation;
import models.AttestationDAO;
import models.Convention;
import models.ConventionDAO;
import models.Database;
import models.Etudiant;
import models.EtudiantDAO;

@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Formulaire() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Database.connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EtudiantDAO etudiantDAO = new EtudiantDAO();
		ArrayList<Etudiant> etudiants = etudiantDAO.getAll();
		ConventionDAO conventionDAO = new ConventionDAO();
		ArrayList<Convention> conventions = conventionDAO.getAll();
		AttestationDAO attestationDAO = new AttestationDAO();
		String message = "";
		
		Boolean saved = false;
		Boolean conv = false;
		
		//Generate Attestation
		if(request.getParameter("generateAttestation") != null) {
			
			int idEtudiant = Integer.valueOf(request.getParameter("inputEtudiant"));
			Etudiant etudiant = etudiantDAO.getById(idEtudiant);
			Convention convention = conventionDAO.getById(etudiant.getIdConvention());
			
			message = "Bonjour "+ etudiant.getNom()+ " " + etudiant.getPrenom() + ",\n\n\n"
					+ "Vous avez suivi " + convention.getNbHeur()+ " heures de formation chez FormationPlus.\n"
					+ "Pouvez-vous nous retourner ce mail avec la pièce jointe signée.\n\n\n"
					+ "Cordialement,\n"
					+ "FormationPlus";
			
			conv = true;
			request.setAttribute("convention", convention);
			request.setAttribute("etudiant", etudiant);
		}
		
		//Save Attestation
		if(request.getParameter("saveAttestation") != null) {
			
			int idEtudiant = Integer.valueOf(request.getParameter("inputEtudiant"));
			Etudiant etudiant = etudiantDAO.getById(idEtudiant);
			Convention convention = conventionDAO.getById(etudiant.getIdConvention());
			String inputMessage= (String)request.getParameter("inputMessage");
			
			//Create the attestation and save it
			Attestation attestation = new Attestation();
			attestation.setIdEtudiant(etudiant.getIdEtudiant());
			attestation.setIdConvention(convention.getIdConvention());
			attestation.setMessage(inputMessage);
			attestationDAO.save(attestation);
			saved = true;
		}
		
		request.setAttribute("conventions", conventions);
		request.setAttribute("etudiants", etudiants);
		request.setAttribute("message", message);
		
		request.setAttribute("saved", saved);
		request.setAttribute("conv", conv);
		
		request.getRequestDispatcher("formulaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
