// package com.rosa.filmes.api;

// import java.util.List;
// import com.rosa.filmes.model.Clientes;
// import com.rosa.filmes.repository.ClientesRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/clientes")
// public class ClientesApi {

//     @Autowired //substitui o construtor na injeção de dependências
//     private ClientesRepository repository;
    
//     @GetMapping
//     public List<Clientes> read(String nome){
//         if(nome != null)
//             return (List<Clientes>)repository.findByNome(nome);
//         return (List<Clientes>)repository.findAll();
//     }

//     @PostMapping
//     public String salvar(@RequestBody Clientes model){
//         repository.save(model);
//         return "Salvo com sucesso!";
//     }

//     @DeleteMapping("/{id}")
//     public String delete(@PathVariable int id){
//         repository.deleteById(id);
//         return "Deletado com sucesso!";
//     }

//     @PutMapping("/{id}")
//     public String update(@PathVariable int id, @RequestBody Clientes model){
//         if(model.getId() == id){
//             repository.save(model);
//             return "Atualizado com sucesso!";
//         }
//         return "Ids diferentes -_-";
//     }

// }
