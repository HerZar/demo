package com.afiliates.demo.controllers;


import com.afiliates.demo.model.Afiliate;
import com.afiliates.demo.model.States;
import com.afiliates.demo.services.IAfiliateService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin()
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
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long idkey){

        if (idkey != null) {
            afiliateService.delete(idkey);
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> sabeOrUpdateAfiliate(@RequestBody Afiliate afil){

        if (afil != null) {
            afil = afiliateService.save(afil);
            return ResponseEntity.ok(afil);
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/inventar", method = RequestMethod.GET)
    public ResponseEntity<?> inventar(){

        States state = States.ACTIVE;
        for (long i = 0 ; i<10;i++){
            Afiliate a = new Afiliate(0,
                    Faker.instance().name().name(),
                    Faker.instance().name().lastName(),
                    Faker.instance().phoneNumber().phoneNumber(),
                    Faker.instance().internet().emailAddress(),
                    Faker.instance().address().fullAddress(),
                    state ,
                    new Date(),
                    new Date());
            afiliateService.save(a);
        }
        return new ResponseEntity (HttpStatus.OK);
    }
}
