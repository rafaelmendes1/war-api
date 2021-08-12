package com.rafaelmendes1.warapi.service;

import com.rafaelmendes1.warapi.dto.request.PersonDTO;
import com.rafaelmendes1.warapi.dto.response.MessageResponseDTO;
import com.rafaelmendes1.warapi.entities.Person;
import com.rafaelmendes1.warapi.mapper.PersonMapper;
import com.rafaelmendes1.warapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
