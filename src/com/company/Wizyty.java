package com.company;

import java.util.Date;

public class Wizyty {
    private Lekarze lekarze;
    private Pacjenci pacjenci;
    private Date dataWizyty;


    public Wizyty(Lekarze lekarze, Pacjenci pacjenci, Date dataWizyty) {
        this.lekarze = lekarze;
        this.pacjenci = pacjenci;
        this.dataWizyty = dataWizyty;
    }

    public Lekarze getLekarze() {
        return lekarze;
    }

    public void setLekarze(Lekarze lekarze) {
        this.lekarze = lekarze;
    }

    public Pacjenci getPacjenci() {
        return pacjenci;
    }

    public void setPacjenci(Pacjenci pacjenci) {
        this.pacjenci = pacjenci;
    }

    public Date getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(Date dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    @Override
    public String toString() {
        return "Wizyty{" +
                "lekarze=" + lekarze +
                ", pacjenci=" + pacjenci +
                ", dataWizyty=" + dataWizyty +
                '}';
    }
}

