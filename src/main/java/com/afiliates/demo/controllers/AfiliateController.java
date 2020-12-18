package com.afiliates.demo.controllers;


import com.afiliates.demo.entities.AfiliateEntity;
import com.afiliates.demo.model.Afiliate;
import com.afiliates.demo.model.States;
import com.afiliates.demo.services.IAfiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    public ResponseEntity<?> getById(@PathVariable ("id") Long idkey){

        if (idkey != null) {
            Afiliate afiliate = afiliateService.findById(idkey);
            if (afiliate != null ){
                return ResponseEntity.ok(afiliate);
            }
        }
        return null;
    }


    @RequestMapping(value = "/inventar", method = RequestMethod.GET)
    public ResponseEntity<?> getById(){

        States state = States.ACTIVE;
        for (long i = 0 ; i<10;i++){
            Afiliate a = new Afiliate(i, "name1"+i, "lastname"+i,"123456"+i, "email@"+i+".com","address"+i, state , new Date(), new Date());
            afiliateService.save(a);
        }
        return new ResponseEntity (HttpStatus.OK);
    }
}
