package ir.mapsa.springatm.controllers;

import ir.mapsa.springatm.mappers.PersonMapper;
import ir.mapsa.springatm.entities.Person;
import ir.mapsa.springatm.services.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController(value = "/person")
@AllArgsConstructor
public class PersonController {

    private IPersonService service;
    private final PersonMapper mapper;

    @PostMapping(value = "/save")
    public ResponseEntity<Void> createPerson(@RequestBody @Valid Person person){
        service.save(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Person>> findAllPerson(){
       return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findById/{personId}")
    public ResponseEntity<Person> findById(@PathVariable(value = "personId") Long id){
       return new ResponseEntity<>(service.findById(id).get(),HttpStatus.OK);

    }


}
