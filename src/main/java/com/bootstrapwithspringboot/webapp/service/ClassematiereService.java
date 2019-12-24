package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.dao.ClasseMatiereDao;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiere;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiereIdentity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassematiereService {

    private ClasseMatiereDao classeMatiereDao;

    public ClasseMatiere save(ClasseMatiere classeMatiere){
        return classeMatiereDao.save(classeMatiere);
    }

    public List<ClasseMatiere> findAll(){
        return classeMatiereDao.findAll();
    }

    public ClasseMatiere getOneById(ClasseMatiereIdentity id){
        return classeMatiereDao.getOne(id);
    }

    public ClasseMatiere update(ClasseMatiere classeMatiere){
        return this.save(classeMatiere);
    }

    public boolean delete(ClasseMatiereIdentity id){
        ClasseMatiere etudiant = getOneById(id);
        try {
            classeMatiereDao.delete(etudiant);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<ClasseMatiere> findAllByClasse(Classe classe){
//        return classeMatiereDao.findAllByClasseMatiereIdentityClasseIsLike(classe);
//        return classeMatiereDao.findAllByClasse_IdMatiereIdentityClasse((long) 1);
        return null;
    }
}
