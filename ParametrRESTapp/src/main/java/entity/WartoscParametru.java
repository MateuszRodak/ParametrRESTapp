package atmoterm.zadanie.rekrutacyjne.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Mateusz Rodak
 */

@Entity
public abstract class WartoscParametru {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Date dataOd;
    protected Date dataDo;

    @Column(name = "parametr_id")
    protected Long parametrId;

    //protected Parametr parametr;


    public Long getParametrId() {
        return parametrId;
    }

    public void setParametrId(Long parametrId) {
        this.parametrId = parametrId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }
}
