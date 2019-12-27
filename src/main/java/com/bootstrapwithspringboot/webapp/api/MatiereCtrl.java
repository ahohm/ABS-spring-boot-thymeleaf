package com.bootstrapwithspringboot.webapp.api;

import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.ClasseService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matiere")
@AllArgsConstructor
public class MatiereCtrl {

    private MatiereService matiereService;
    private ClasseService classeService;

    @PostMapping("/add")
    public ResponseEntity<Matiere> add(@Valid @RequestBody Matiere matiere){
        try{
            return new ResponseEntity(matiereService.save(matiere), HttpStatus.OK);
        }
        catch( Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<Matiere>> getAll(){
        try {
            return new ResponseEntity(matiereService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getOne(@PathVariable long id){
        try{
            return new ResponseEntity(matiereService.getOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matiere> update(@PathVariable long id, @RequestBody Matiere matiere){
        try{
            matiere.setId(id);
            return new ResponseEntity(matiereService.update(matiere), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        try{
            matiereService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byclasse/{id}")
    public ResponseEntity<List<Matiere>> getAllByMatiere(@PathVariable long id){
        try {
            return new ResponseEntity(matiereService.findByClasse(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}




