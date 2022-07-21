package com.company;
import java.util.Date;
import java.util.List;

public class Pacjenci {

    private int idPacjenta;
    private String nazwisko;
    private String imie;
    private String pesel;
    private Date dataUrodzenia;
    private List<Wizyty> listaWizytPacjenci;

    public Pacjenci(int idPacjenta, String nazwisko, String imie, String pesel, Date dataUrodzenia) {
        this.idPacjenta = idPacjenta;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }

    public void addWizytaPacjenci(Wizyty wizyta) {
        listaWizytPacjenci.add(wizyta);
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public List<Wizyty> getListaWizytPacjenci() {
        return listaWizytPacjenci;
    }

    public void setListaWizytPacjenci(List<Wizyty> listaWizytPacjenci) {
        this.listaWizytPacjenci = listaWizytPacjenci;
    }

    public int getIdPacjenta() {
        return idPacjenta;
    }

    @Override
    public String toString() {
        return "Pacjenci{" +
                "idPacjenta=" + idPacjenta +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", wizyty=" +
                ", lekarze=" +
                '}';
    }
}
