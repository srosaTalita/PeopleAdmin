package com.rosa.filmes.model;

import javax.persistence.*;

import com.rosa.filmes.enums.PhoneType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;
    
    @Getter @Setter
    @Column(nullable = false)
    private String number;
}
