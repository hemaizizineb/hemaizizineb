package application;

public class Certificat {
    private String nomPat;
    private String prenomPat;
    private String avisDoc;
    private int age;

    public Certificat(String nomPat,  String prenomPat, String avisDoc, int age) {
        this.nomPat = nomPat;
        this.prenomPat = prenomPat;
        this.avisDoc = avisDoc;
        this.age = age;
    }

    // Getters
    public String getNomPat() {
        return nomPat;
    }

   
    public String getPrenomPat() {
        return prenomPat;
    }


    public String getAvisDoc() {
        return avisDoc;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setNomPat(String nomPat) {
        this.nomPat = nomPat;
    }


    public void setPrenomPat(String prenomPat) {
        this.prenomPat = prenomPat;
    }

   
    public void setAvisDoc(String avisDoc) {
        this.avisDoc = avisDoc;
    }

    public void setAge(int age) {
        this.age = age;
    }



}