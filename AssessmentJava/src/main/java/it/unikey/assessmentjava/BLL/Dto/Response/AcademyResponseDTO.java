package it.unikey.assessmentjava.BLL.Dto.Response;

import java.time.LocalDate;
import java.util.List;

public class AcademyResponseDTO {

    private Long id;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloResponseDTO> moduloResponseDTOList;
    private List<DiscenteResponseDTO> discenteResponseDTOList;

    public AcademyResponseDTO(Long id, String nome, LocalDate dataInizio, LocalDate dataFine) {
        this.id = id;
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

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

    public List<ModuloResponseDTO> getModuloResponseDTOList() {
        return moduloResponseDTOList;
    }

    public void setModuloResponseDTOList(List<ModuloResponseDTO> moduloResponseDTOList) {
        this.moduloResponseDTOList = moduloResponseDTOList;
    }

    public List<DiscenteResponseDTO> getDiscenteResponseDTOList() {
        return discenteResponseDTOList;
    }

    public void setDiscenteResponseDTOList(List<DiscenteResponseDTO> discenteResponseDTOList) {
        this.discenteResponseDTOList = discenteResponseDTOList;
    }

    @Override
    public String toString() {
        return "AcademyResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
