package atmoterm.zadanie.rekrutacyjne.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Author: Mateusz Rodak
 */

@Entity
public class WartoscOpisowaParametru extends  WartoscParametru{

    @Column(length = 30, name = "wartosc_opisowa ")
    private String wartosc;


    public WartoscOpisowaParametru() {
    }


    public String getWartosc() {
        return wartosc;
    }

    public void setWartosc(String wartosc) {
        this.wartosc = wartosc;
    }


}

