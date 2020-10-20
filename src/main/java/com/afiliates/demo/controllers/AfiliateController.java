package com.afiliates.demo.controllers;


import com.afiliates.demo.entities.AfiliateEntity;
import com.afiliates.demo.model.Afiliate;
import com.afiliates.demo.services.IAfiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("afiliates")
public class AfiliateController {

    @Autowired
    IAfiliateService<Afiliate> afiliateService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        List<Afiliate> afiliates = afiliateService.findAll();
        if (afiliates == null || afiliates.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(afiliates);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable ("id") long idkey){

        return null;
    }

}
