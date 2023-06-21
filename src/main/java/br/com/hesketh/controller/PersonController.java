package br.com.hesketh.controller;

import br.com.hesketh.dto.PersonDto;
import br.com.hesketh.entity.PersonModel;
import br.com.hesketh.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/person")
@Tag(name = "Person")
@Slf4j
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @Operation(summary = "Save a person", description = "Endpoint save a person")
    public ResponseEntity<Object> saveOnePerson(@RequestBody @Valid PersonDto personDto) {
        log.info("Mensagem recebida do de API.");

        if(personService.existsByDocument(personDto.getDocument())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: Document is already in use!");
        }

        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);
        personModel.setRegistrationdate(LocalDateTime.now(ZoneId.of("UTC")));
        personModel.setId(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
    }

    @GetMapping
    @Operation(summary = "Consultar dados de pessoa", description = "Endpoint para consulta dados de parametro de erro")
    public ResponseEntity<Page<PersonModel>> getAllPerson(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable ) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePerson(@PathVariable(value="id") UUID id){
        Optional<PersonModel> personOptional = personService.findById(id);
        if(personOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") UUID id){
        Optional<PersonModel> personOptional = personService.findById(id);
        if(personOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("Person deleted sucessfuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable(value="id") UUID id, @RequestBody @Valid PersonDto personDto){
        Optional<PersonModel> personOptional = personService.findById(id);
        if(personOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(personService.save(null));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.");
        }
    }

}
