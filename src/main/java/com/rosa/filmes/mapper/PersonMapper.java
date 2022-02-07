package com.rosa.filmes.mapper;

import com.rosa.filmes.dto.request.PersonDTO;
import com.rosa.filmes.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper{
    
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person personDTOtoPerson(PersonDTO personDTO);
    
    PersonDTO personTopersonDTO(Person person);
}
