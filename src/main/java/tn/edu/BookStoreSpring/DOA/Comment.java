package tn.edu.BookStoreSpring.DOA;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_Comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdComment")
    private int idComment;

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }
}
