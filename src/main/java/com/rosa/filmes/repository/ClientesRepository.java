// package com.rosa.filmes.repository;

// import java.util.List;

// import com.rosa.filmes.model.Clientes;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.repository.PagingAndSortingRepository;

// public interface ClientesRepository<Clientes> extends PagingAndSortingRepository<Clientes, Integer>{
//     @Override
//     default Iterable<Clientes> findAll() {
//         return findAll(Sort.by(Sort.Direction.ASC, "id")); // ordena a listagem com base no id
//     }

//     List<Clientes> findByNome(String nome);
// }
