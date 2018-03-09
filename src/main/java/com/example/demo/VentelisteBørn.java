package com.example.demo;

public class VentelisteBørn {
    private String Navn;
    private String Efternavn;
    private String Adresse;
    private int Telefonnummer;
    private String Kontaktperson;

    public VentelisteBørn(String navn, String efternavn, String adresse, int telefonnummer, String kontaktperson) {
        Navn = navn;
        Efternavn = efternavn;
        Adresse = adresse;
        Telefonnummer = telefonnummer;
        Kontaktperson = kontaktperson;
    }

        public String getNavn(){
            return Navn;
        }

        public void setNavn(String navn) {
        Navn = navn;
        }

        public String getEfternavn() {
            return Efternavn;
        }

        public void setEfternavn(String efternavn) {
        Efternavn = efternavn;
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

    }
}
