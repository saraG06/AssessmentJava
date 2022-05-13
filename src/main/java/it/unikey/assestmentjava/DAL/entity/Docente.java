package it.unikey.assestmentjava.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
    private Persona persona;
    @OneToMany(mappedBy = "docente")
    private List<Modulo> moduli;

}
