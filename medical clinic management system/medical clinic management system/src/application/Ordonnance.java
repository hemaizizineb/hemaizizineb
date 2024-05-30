package application;

public class Ordonnance {
	private int id;
   private String medic;
    private String  duree;
    private String Dosage;
	public Ordonnance(int id, String medic, String duree, String dosage) {
		this.id = id;
		this.medic = medic;
		this.duree = duree;
		Dosage = dosage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMedic() {
		return medic;
	}
	public void setMedic(String medic) {
		this.medic = medic;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getDosage() {
		return Dosage;
	}
	public void setDosage(String dosage) {
		Dosage = dosage;
	}
	
}