package com.rosa.filmes.api;

import java.util.List;
import com.rosa.filmes.model.Phone;
import com.rosa.filmes.repository.TipoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipoCliente")
public class TipoClienteApi {
    
    @Autowired
    private TipoClienteRepository repository;

    @GetMapping
    public List<Phone> read(){
        return (List<Phone>)repository.findAll();
    }

    @PostMapping
    public String create(@RequestBody Phone model){
        repository.save(model);
        return "Salvo com sucesso!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Phone model){
        if(model.getId() == id){
            repository.save(model);
            return "Atualizado com sucesso!";
        }
        return "Ids são diferentes!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        repository.deleteById(id);
        return "Deletado com sucesso!";
    }
}
