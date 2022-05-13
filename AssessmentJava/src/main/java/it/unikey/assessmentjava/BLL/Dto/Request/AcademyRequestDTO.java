package it.unikey.assessmentjava.BLL.Dto.Request;

import java.time.LocalDate;
import java.util.List;

public class AcademyRequestDTO {

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloRequestDTO> moduloRequestDTOList;
    private List<DiscenteRequestDTO> discenteRequestDTOList;

    public AcademyRequestDTO(String nome, LocalDate dataInizio, LocalDate dataFine, List<ModuloRequestDTO> moduloRequestDTOList, List<DiscenteRequestDTO> discenteRequestDTOList) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.moduloRequestDTOList = moduloRequestDTOList;
        this.discenteRequestDTOList = discenteRequestDTOList;
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

    public List<ModuloRequestDTO> getModuloRequestDTOList() {
        return moduloRequestDTOList;
    }

    public void setModuloRequestDTOList(List<ModuloRequestDTO> moduloRequestDTOList) {
        this.moduloRequestDTOList = moduloRequestDTOList;
    }

    public List<DiscenteRequestDTO> getDiscenteRequestDTOList() {
        return discenteRequestDTOList;
    }

    public void setDiscenteRequestDTOList(List<DiscenteRequestDTO> discenteRequestDTOList) {
        this.discenteRequestDTOList = discenteRequestDTOList;
    }

    @Override
    public String toString() {
        return "AcademyRequestDTO{" +
                "nome='" + nome + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", moduloRequestDTOList=" + moduloRequestDTOList +
                ", discenteRequestDTOList=" + discenteRequestDTOList +
                '}';
    }
}
