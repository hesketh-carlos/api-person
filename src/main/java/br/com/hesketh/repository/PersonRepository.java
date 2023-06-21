package br.com.hesketh.repository;

import br.com.hesketh.entity.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID> {

    boolean existsByDocument(String document);
}
