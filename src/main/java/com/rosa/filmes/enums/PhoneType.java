package com.rosa.filmes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PhoneType{
    
    HOME("Telefone"), MOBILE("Celular"), COMERCIAL("Telefone Comercial");
    
    @Getter 
    private final String description;
}
