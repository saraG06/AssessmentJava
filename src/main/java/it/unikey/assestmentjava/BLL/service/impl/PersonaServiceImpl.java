package it.unikey.assestmentjava.BLL.service.impl;

import it.unikey.assestmentjava.BLL.dto.request.PersonaRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.PersonaResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.implementation.*;
import it.unikey.assestmentjava.BLL.service.abstraction.PersonaService;
import it.unikey.assestmentjava.DAL.entity.Persona;
import it.unikey.assestmentjava.DAL.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

        private final PersonaRepository personaRepository;
        private final PersonaRequestMapper personaRequestMapper;
        private final PersonaResponseMapper personaResponseMapper;

        @Override
        public void save(PersonaRequestDTO personaRequestDTO) {
            Persona p = personaRequestMapper.asEntity(personaRequestDTO);
            personaRepository.save(p);
        }

        @Override
        public PersonaResponseDTO findById(Long id) {
            Persona p = personaRepository.getById(id);
            if(p != null){
                return personaResponseMapper.asDTO(p);
            }else{
                throw new NullPointerException();
            }
        }

        @Override
        public void deleteById(Long id) {
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
            }else{
                throw new NullPointerException();
            }
        }

        @Override
        public List<PersonaResponseDTO> findAll() {
            List<Persona> list = personaRepository.findAll();
            return personaResponseMapper.asDTOList(list);
        }
}
