package com.rosa.filmes.service;

import com.rosa.filmes.dto.response.MessageResponseDTO;
import com.rosa.filmes.mapper.PersonMapper;
import com.rosa.filmes.model.Person;
import java.util.List;
import java.util.stream.Collectors;
import com.rosa.filmes.dto.request.PersonDTO;
import com.rosa.filmes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PersonService {
 
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.personDTOtoPerson(personDTO);
        Person savedperson = personRepository.save(personToSave);
        return createMessageResponse(savedperson.getId(), "Created person with ID");
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
        .map(personMapper::personTopersonDTO)
        .collect(Collectors.toList());
    }

    public PersonDTO findById(int id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                        .orElseThrow(()-> new PersonNotFoundException(id));
        return personMapper.personTopersonDTO(person);
    }

    public void delete(int id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }
    
    public MessageResponseDTO updateByID(int id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.personDTOtoPerson(personDTO);
        Person updatedperson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedperson.getId(), "Updated person with ID");
    }
    
    private Person verifyIfExists(int id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
    
    private MessageResponseDTO createMessageResponse(int id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
