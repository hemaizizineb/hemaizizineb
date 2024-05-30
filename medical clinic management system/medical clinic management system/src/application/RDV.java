package application;

public class RDV {
	private int id;
	private int id_pat;
	private String statut,heure,heure_fin,date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pat() {
		return id_pat;
	}
	public void setId_pat(int id_pat) {
		this.id_pat = id_pat;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public RDV(int id, int id_pat, String statut, String heure, String heure_fin, String date) {
		this.id = id;
		this.id_pat = id_pat;
		this.statut = statut;
		this.heure = heure;
		this.heure_fin = heure_fin;
		this.date = date;
	}
	
}