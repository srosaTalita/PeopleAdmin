package com.rosa.filmes.controller;

import java.util.List;
import com.rosa.filmes.model.Person;
import com.rosa.filmes.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoas")
public class PersonController {
    
    private PersonRepository repository;
    
    public PersonController(PersonRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public String read(Model req, String nome)
    {
        List<Person> list;
        // if(nome == null || nome == "")
        list = (List<Person>)repository.findAll();
        // else
        //     list = (List<Person>)repository.findByNome(nome);

        req.addAttribute("clientes", list);
        return "clientes-list";
    }

    @GetMapping("/cadastro")
    public String create(){
        return "clientes-create";
    }

    @GetMapping("/editar/{id}")
    public String update(@PathVariable int id, Model req){
        Person model = repository.findById(id).get();
        req.addAttribute("cliente", model);
        return "clientes-edit";
    }

    @PostMapping("/salvar")
    public String salvar(Person model){
        repository.save(model);
        return "redirect:/clientes";
    }

    @GetMapping("/deletar/{id}")
    public String delete(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/clientes";
    }
}
