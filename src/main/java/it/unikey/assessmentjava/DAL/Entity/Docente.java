package it.unikey.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_docente;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "docente")
    private List<Modulo> moduli;

    public Long getId_docente() {
        return id_docente;
    }

    public void setId_docente(Long id_docente) {
        this.id_docente = id_docente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Modulo> getModuli() {
        return moduli;
    }

    public void setModuli(List<Modulo> moduli) {
        this.moduli = moduli;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "id_academy=" + id_docente +
                ", nome='" + nome + '\'' +
                ", moduli=" + moduli +
                '}';
    }
}
