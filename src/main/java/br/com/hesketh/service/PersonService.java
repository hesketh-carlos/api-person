package br.com.hesketh.service;

import br.com.hesketh.dto.PersonDto;
import br.com.hesketh.entity.PersonModel;
import br.com.hesketh.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public PersonModel save(PersonModel personModel) {
        return personRepository.save(personModel);
    }

    public boolean existsByDocument(String document){
        return personRepository.existsByDocument(document);
    }

    public Page<PersonModel> findAll(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    public Optional<PersonModel> findById(UUID id){
        return personRepository.findById(id);
    }

    public void delete(PersonModel personModel){
        personRepository.delete(personModel);
    }

}
