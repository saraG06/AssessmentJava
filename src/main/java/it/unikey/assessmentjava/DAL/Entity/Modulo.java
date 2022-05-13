package it.unikey.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "id_modulo", example= "1", required = true)
    Long id_modulo;

    @Column(name = "argomenti")
    @ApiModelProperty(notes= "argomenti", example= "2", required = true)
    private String argomenti;

    @Column(name = "data_inizio_modulo")
    @ApiModelProperty(notes= "data_inizio_modulo", example= "3", required = true)
    private LocalDate data_inizio_modulo;

    @Column(name = "data_fine")
    @ApiModelProperty(notes= "data_fine_modulo", example= "4", required = true)
    private LocalDate data_fine_modulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "docente", example= "5", required = true)
    private Docente docente;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "academymodulo", example= "6", required = true)
    private Academy academymodulo;

    public Long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(Long id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getArgomenti() {
        return argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    public LocalDate getData_inizio_modulo() {
        return data_inizio_modulo;
    }

    public void setData_inizio_modulo(LocalDate data_inizio_modulo) {
        this.data_inizio_modulo = data_inizio_modulo;
    }

    public LocalDate getData_fine_modulo() {
        return data_fine_modulo;
    }

    public void setData_fine_modulo(LocalDate data_fine_modulo) {
        this.data_fine_modulo = data_fine_modulo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Academy getAcademymodulo() {
        return academymodulo;
    }

    public void setAcademymodulo(Academy academymodulo) {
        this.academymodulo = academymodulo;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id_modulo=" + id_modulo +
                ", argomenti='" + argomenti + '\'' +
                ", data_inizio_modulo=" + data_inizio_modulo +
                ", data_fine_modulo=" + data_fine_modulo +
                ", docente=" + docente +
                '}';
    }
}
