package com.afiliates.demo.servicesImpl;

import com.afiliates.demo.entities.AfiliateEntity;
import com.afiliates.demo.model.Afiliate;
import com.afiliates.demo.repository.IAfiliateRepository;
import com.afiliates.demo.services.IAfiliateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AfiliateServiceImpl implements IAfiliateService<Afiliate> {

    @Autowired
    IAfiliateRepository afiliateRepo;

    @Override
    public List<Afiliate> findAll() {

        List<Afiliate> list =  this.afiliateRepo.findAll().stream().map(
                    (e)->{
                        Afiliate a = new Afiliate();
                        BeanUtils.copyProperties(e, a);
                        return a;
                }).collect(Collectors.toList());

        return list;

    }

    @Override
    public Afiliate findById(Long idKey) {

        AfiliateEntity entity = this.afiliateRepo.findById(idKey).get();
        Afiliate a = new Afiliate();
        BeanUtils.copyProperties(entity, a);
        return a;

    }

    @Override
    public void save(Afiliate model) {

        AfiliateEntity afiliateEntity = new AfiliateEntity();
        BeanUtils.copyProperties(model, afiliateEntity);
        this.afiliateRepo.save(afiliateEntity);

    }

    @Override
    public void delete(Long idKey) {

        this.afiliateRepo.deleteById(idKey);

    }
}