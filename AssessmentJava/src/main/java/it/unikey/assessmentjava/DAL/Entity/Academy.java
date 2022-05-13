package it.unikey.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private LocalDate dataInizio;
    @Column
    private LocalDate dataFine;
    @OneToMany(mappedBy = "academy",cascade = CascadeType.PERSIST)
    private List<Modulo> listaModuli;
    @OneToMany(mappedBy = "academy",cascade = CascadeType.PERSIST)
    private List<Discente> listaDiscenti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public List<Modulo> getListaModuli() {
        return listaModuli;
    }

    public void setListaModuli(List<Modulo> listaModuli) {
        this.listaModuli = listaModuli;
    }

    public List<Discente> getListaDiscenti() {
        return listaDiscenti;
    }

    public void setListaDiscenti(List<Discente> listaDiscenti) {
        this.listaDiscenti = listaDiscenti;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", listaModuli=" + listaModuli +
                ", listaDiscenti=" + listaDiscenti +
                '}';
    }
}
