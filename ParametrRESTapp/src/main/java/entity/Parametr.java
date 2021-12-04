package atmoterm.zadanie.rekrutacyjne.entity;


import javax.persistence.*;
import java.util.List;

/**
 * Author: Mateusz Rodak
 */

@Entity
public class Parametr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String name;


    private String description;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parametr_id")
    private List<WartoscLiczbowaParametru> wartoscLiczbowaParametrus;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parametr_id")
    private List<WartoscOpisowaParametru> wartoscOpisowaParametrus;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
