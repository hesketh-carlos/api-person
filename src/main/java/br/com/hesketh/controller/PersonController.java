package br.com.hesketh.controller;

import br.com.hesketh.dto.PersonDto;
import br.com.hesketh.entity.Person;
import br.com.hesketh.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@Tag(name = "Person")
@Slf4j
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/person")
    @Operation(summary = "Consultar dados de pessoa",
            description = "Endpoint para consulta dados de parametro de erro")
    public ResponseEntity<List<Person>> findAllPerson() {
        log.info("Mensagem recebida do de API.");
        List<Person> personList = personService.findAll();
        if (personList.size() > 0 ) {
            return ResponseEntity.ok(personList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/person")
    @Operation(summary = "Save a person",
            description = "Endpoint save a person")
    public ResponseEntity<String> saveOnePerson(@RequestBody PersonDto personDto) {
        log.info("Mensagem recebida do de API.");
        personService.savePerson(personDto);
       return ResponseEntity.ok().body("Sucesso");
    }


}
