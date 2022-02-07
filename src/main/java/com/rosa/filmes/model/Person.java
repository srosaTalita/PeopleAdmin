package com.rosa.filmes.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Getter @Setter
    private String firstName;
    
    @Column(nullable = false)
    @Getter @Setter
    private String lastName;

    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String cpf;
    
    @Getter @Setter
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}

