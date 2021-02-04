package tn.edu.BookStoreSpring.DOA;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_Payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPayment")
    private int idPayment;

    @OneToOne(mappedBy = "payment")
    private User user;

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
