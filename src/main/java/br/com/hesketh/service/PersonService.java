package br.com.hesketh.service;

import br.com.hesketh.dto.PersonDto;
import br.com.hesketh.entity.Person;
import br.com.hesketh.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person savePerson(PersonDto personDto) {
        Person person = Person.builder()
                        .name(personDto.getName()).build();
        return personRepository.saveAndFlush(person);
    }
}
