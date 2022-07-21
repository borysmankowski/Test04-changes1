package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lekarze {

    private int idLekarza;
    private String nazwisko;
    private String imie;
    private String specjalnosc;
    private Date dataUrodzenia;
    private String nip;
    private String pesel;
    private List<Wizyty> listaWizytLekarze;

    public Lekarze(int idLekarza, String nazwisko, String imie, String specjalnosc, Date dataUrodzenia, String nip, String pesel) {
        this.idLekarza = idLekarza;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.specjalnosc = specjalnosc;
        this.dataUrodzenia = dataUrodzenia;
        this.nip = nip;
        this.pesel = pesel;
        this.listaWizytLekarze = listaWizytLekarze;
    }

    public void addWizytaLekarz(Wizyty wizyta) {
        listaWizytLekarze.add(wizyta);
    }

    public int getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(int idLekarza) {
        this.idLekarza = idLekarza;
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

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public List<Wizyty> getListaWizytLekarze() {
        return listaWizytLekarze;
    }

    public void setListaWizytLekarze(List<Wizyty> listaWizytLekarze) {
        this.listaWizytLekarze = listaWizytLekarze;
    }

    @Override
    public String toString() {
        return "Lekarz{" +
                "idLekarza=" + idLekarza +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", specjalnosc='" + specjalnosc + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
