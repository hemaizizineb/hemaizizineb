package application;



public class Patient {
	private int id ,poid 	,taille	 ,	num_tel;
	private String nom,prenom,sexe, adress, bd;
	public Patient(int id ,int poid, int taille,  int num_tel, String nom,
			String prenom, String sexe, String adress, String date) {
		
		this.id = id;
		this.poid = poid;
		this.taille = taille;
		this.num_tel = num_tel;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.adress = adress;
		this.bd = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(int num_tel) {
		this.num_tel = num_tel;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	
}
