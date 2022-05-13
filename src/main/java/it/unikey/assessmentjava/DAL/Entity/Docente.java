package it.unikey.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "id_docente", example= "1", required = true)
    Long id_docente;

    @Column(name = "nome")
    @ApiModelProperty(notes= "nome_docente", example= "2", required = true)
    private String nome;

    @OneToMany(mappedBy = "docente")
    @ApiModelProperty(notes= "moduli", example= "3", required = true)
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
