package com.bootstrapwithspringboot.webapp.api;

import com.bootstrapwithspringboot.webapp.dao.ClasseDao;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantCtrl {

    private EtudiantService etudiantService;
    private ClasseDao classeDao;

    @PostMapping("/add")
    public ResponseEntity<Etudiant> add(@Valid @RequestBody Etudiant etudiant,
                                        @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob,
                                        @PathParam("classeid") long classeid) {
            try{

                etudiant.setDateDeNaissance(dob);
                etudiant.setClasse(classeDao.getOne(classeid));
                return new ResponseEntity(etudiantService.save(etudiant), HttpStatus.OK);
            }
            catch( Exception e){
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<Etudiant>> getAll(){
        try {
            return new ResponseEntity(etudiantService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{matricule}")
    public ResponseEntity<Etudiant> getOne(@PathVariable String matricule){
        try{
            return new ResponseEntity(etudiantService.getOneById(matricule), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{matricule}")
    public ResponseEntity<Etudiant> update(@Valid @RequestBody Etudiant etudiant,
                                           @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob,
                                           @PathParam("classeid") long classeid){
        try{
            etudiant.setDateDeNaissance(dob);
            etudiant.setClasse(classeDao.getOne(classeid));
            return new ResponseEntity(etudiantService.update(etudiant), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{matricule}")
    public ResponseEntity<Boolean> delete(@PathVariable String matricule){
        try{

            return new ResponseEntity(etudiantService.delete(matricule), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
