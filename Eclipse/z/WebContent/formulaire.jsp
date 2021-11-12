<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.Etudiant" %>
<%@ page import="models.Convention" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap css -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

</head>
<body>
 <div class="container">
	<%
	if((Boolean)request.getAttribute("saved") == true){
	%>
		<div class="alert alert-success" role="alert">L'attestation a été sauvegardé</div>
	<%}
	%>
	<form method="POST" class="text-center" style="margin-top: 50px">
		<div class="form-group">
	     	<label for="inputEtudiant">Choisissez un étudiant:</label>
	        <select name="inputEtudiant" class="form-control mx-10" style="margin: 0 auto; width: 300px;" id="inputEtudiant">
	        <%
	        	Etudiant etudiant = (Etudiant)request.getAttribute("etudiant");
	        	if((Boolean)request.getAttribute("conv") == true){
			%>
				<option value="<%=etudiant.getIdEtudiant() %>"><%=etudiant.getNom()%> <%=etudiant.getPrenom()%></option>
			<%}%>
			<%
	         	ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>)request.getAttribute("etudiants");
	         	for(Etudiant et: etudiants){
	         	%>
	         		<option value="<%=et.getIdEtudiant() %>"><%=et.getNom()%> <%=et.getPrenom()%></option>
	         	<%} %>
	        </select>
	     </div>
	     <%	Convention convention = (Convention)request.getAttribute("convention");
			if((Boolean)request.getAttribute("conv") == true){
			%>
				<div class="form-group">
					<div>
						<label for="inputEtudiant">Convention:</label>
					</div>
					<input type="text" value="<%=convention.getNom() %>" readonly>
				</div>
			<%}
		 %>
	     <div class="form-group text-center mb-10">
	         <button name="generateAttestation" class="btn btn-primary" type="submit">
	             Génerer l'attestation
	         </button>
	     </div>
	     <div class="text-center">
	     	<label for="inputMessage">Attestation:</label>
	     </div>
	     <div class="text-center">
			 <% String message = (String)request.getAttribute("message");%>
			 <textarea id="inputMessage" name="inputMessage" rows="15" cols="100"><%=message%></textarea>
	     </div>
	     <div class="form-group text-center">
	         <button name="saveAttestation" class="btn btn-primary" type="submit" style="margin-top: 20px">
	             Sauvegarder l'attestation
	         </button>
	     </div>
	 </form>
 </div>
</body>
</html>