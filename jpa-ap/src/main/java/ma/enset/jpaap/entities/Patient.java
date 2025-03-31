package ma.enset.jpaap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.Date;

@Getter
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM", length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    private boolean malade;
    private int score;

}
