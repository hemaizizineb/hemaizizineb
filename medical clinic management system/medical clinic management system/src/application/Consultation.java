package application;
public class Consultation {
    private int id,idc;
	    public int getIdc() {
			return idc;
		}

		public void setIdc(int idc) {
			this.idc = idc;
		}

		private String date;
	    private String observations;
	    
	    public Consultation(int id , int idc ,String date, String observations ) {
	    	this.id=id;
	    	this.idc=idc;
	        this.date = date;
	        this.observations = observations;
	    }
	    
	    // Getters et setters
	   
	    
	    public String getDate() {
	        return date;
	    }

	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setDate(String date) {
	        this.date = date;
	    }
	    // Méthode pour obtenir les observations de la consultation
	    public String getObservations() {
	        return observations;
	    }

	    public void setObservations(String observations) {
	        this.observations = observations;
	    }
	    
		

        



}
