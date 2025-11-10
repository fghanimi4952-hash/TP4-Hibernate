package entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nom;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Machine> machines = new ArrayList<>();

    public Salle() {}

    public Salle(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getNom() { return nom; }
    public List<Machine> getMachines() { return machines; }

    public void setCode(String code) { this.code = code; }
    public void setNom(String nom) { this.nom = nom; }
}
