package atmoterm.zadanie.rekrutacyjne.entity;

import atmoterm.zadanie.rekrutacyjne.enums.Jednostka;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Author: Mateusz Rodak
 */

@Entity
public class WartoscLiczbowaParametru extends WartoscParametru {

    @Column(name = "wartosc_liczbowa")
    private BigDecimal wartosc;

    @Enumerated(EnumType.STRING)
    private Jednostka jednostka;

    //@ManyToOne
    //private Parametr parametr;


    public WartoscLiczbowaParametru() {
    }

    public BigDecimal getWartosc() {
        return wartosc;
    }

    public void setWartosc(BigDecimal wartosc) {
        this.wartosc = wartosc;
    }

    public Jednostka getJednostka() {
        return jednostka;
    }

    public void setJednostka(Jednostka jednostka) {
        this.jednostka = jednostka;
    }
}
