package application;

public class Fiche_Patient {
	private String NOM,PRENOM;
	private int ID;
	private String OBSERVATION ;
	
	public Fiche_Patient() {}
	public Fiche_Patient(String NOM ,String PRENOM ,int id,String OBSERVATION)
	{
		this.NOM =NOM;
		this.PRENOM = PRENOM;
		this.ID = id;
		this.OBSERVATION =OBSERVATION;
	}
	
	
	
	// geteur et seteur 
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String nOM) {
		NOM = nOM;
	}
	public String getPRENOM() {
		return PRENOM;
	}
	public void setPRENOM(String pRENOM) {
		PRENOM = pRENOM;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOBSERVATION() {
		return OBSERVATION;
	}
	public void setOBSERVATION(String oBSERVATION) {
		OBSERVATION = oBSERVATION;
	}
	
	

}
