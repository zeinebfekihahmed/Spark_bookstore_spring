package tn.edu.BookStoreSpring.DOA;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_Reclamation")
public class Reclamation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdReclamation")
    private int idReclamation;

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }
}
