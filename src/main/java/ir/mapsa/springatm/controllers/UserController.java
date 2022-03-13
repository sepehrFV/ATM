package ir.mapsa.springatm.controllers;

import ir.mapsa.springatm.mappers.UserMapper;
import ir.mapsa.springatm.entities.User;
import ir.mapsa.springatm.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private IUserService service;
    private final UserMapper mapper;

    @GetMapping(value = "/page")
    public String page(){
        return "This is user page";
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody @Valid User user){
        service.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> findAllPerson(){
       return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/byId/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/byId/{userId}")
    public ResponseEntity<User> findById(@PathVariable(value = "userId") Long id){
       return new ResponseEntity<>(service.findById(id).get(),HttpStatus.OK);

    }


}
