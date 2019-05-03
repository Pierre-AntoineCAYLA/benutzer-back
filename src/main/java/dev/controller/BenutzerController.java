package dev.controller;

import dev.model.Benutzer;
import dev.repository.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benutzer")
@CrossOrigin
public class BenutzerController {

    @Autowired
    private BenutzerRepository benutzerRepository;
  
    @GetMapping
    public List<Benutzer> getBenutzers(){
        return this.benutzerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Benutzer getBenutzerById(@PathVariable Integer id) throws Exception {
        if (this.benutzerRepository.findByid(id) == null) {
            throw new Exception();
        }
        return this.benutzerRepository.findByid(id);
    }
    
    @GetMapping("/{email}")
    public Benutzer getBenutzerByEmail(@PathVariable String email) throws Exception{
        if (this.benutzerRepository.findByEmail(email) == null) {
            throw new Exception();
        }
        return this.benutzerRepository.findByEmail(email);
    }
    
    @PostMapping
    public void postBenutzer(@RequestBody Benutzer benutzer){
        this.benutzerRepository.save(benutzer);
    }

    @DeleteMapping("/{id}")
    public void deleteBenutzer(@PathVariable Integer id) throws Exception{
        if (this.benutzerRepository.findByid(id) == null) {
            throw new Exception();
        }

        this.benutzerRepository.delete(id);
    }

    @PutMapping("/{id}")
    public void updateBenutzer(@PathVariable Integer id, @RequestBody Benutzer benutzer) throws Exception {
        if (this.benutzerRepository.findOne(id) == null) {
            throw new Exception();
        }
    }
}
