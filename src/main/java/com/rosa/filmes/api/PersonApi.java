package com.rosa.filmes.api;

import java.util.List;

import javax.validation.Valid;

import com.rosa.filmes.dto.request.PersonDTO;
import com.rosa.filmes.dto.response.MessageResponseDTO;
import com.rosa.filmes.service.PersonNotFoundException;
import com.rosa.filmes.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonApi {

    private PersonService personService;

    @Autowired
    public PersonApi(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable int id) throws PersonNotFoundException{
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateByID(@PathVariable int id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updateByID(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) throws PersonNotFoundException{
        personService.delete(id);
    }
}
