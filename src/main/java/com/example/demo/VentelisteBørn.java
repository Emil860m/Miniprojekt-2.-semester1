package com.example.demo;

public class VentelisteBørn {
    private String Navn;
    private String Adresse;
    private int Telefonnummer;
    private String Kontaktperson;
    private String Kontaktperson2;
    private int id;

    public VentelisteBørn(String navn, String adresse, int telefonnummer, String kontaktperson, String kontaktperson2) {
        Navn = navn;
        Adresse = adresse;
        Telefonnummer = telefonnummer;
        Kontaktperson = kontaktperson;
        Kontaktperson2 = kontaktperson2;

    }

    public String getNavn(){
            return Navn;
        }

        public void setNavn(String navn) {
        Navn = navn;
        }


        public String getAdresse() {
            return Adresse;
        }

        public void setAdresse(String adresse) {
        Adresse = adresse;
        }

        public int getTelefonnummer() {
            return Telefonnummer;
        }

        public void setTelefonnummer(int telefonnummer) {
        Telefonnummer = telefonnummer;
        }

        public String getKontaktperson() {
            return Kontaktperson;
        }

        public void setKontaktperson(String kontaktperson) {
        Kontaktperson = kontaktperson;
        }

    public String getKontaktperson2() {
        return Kontaktperson2;
    }

    public void setKontaktperson2(String kontaktperson2) {
        Kontaktperson2 = kontaktperson2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

