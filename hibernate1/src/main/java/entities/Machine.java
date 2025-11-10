package entities;

import jakarta.persistence.*;

@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String marque;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public Machine() {}

    public Machine(String reference, String marque, Salle salle) {
        this.reference = reference;
        this.marque = marque;
        this.salle = salle;
    }

    public Long getId() { return id; }
    public String getReference() { return reference; }
    public String getMarque() { return marque; }
    public Salle getSalle() { return salle; }

    public void setReference(String reference) { this.reference = reference; }
    public void setMarque(String marque) { this.marque = marque; }
    public void setSalle(Salle salle) { this.salle = salle; }
}
