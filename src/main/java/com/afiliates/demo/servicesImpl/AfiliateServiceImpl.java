package com.afiliates.demo.servicesImpl;

import com.afiliates.demo.controllers.AfiliateController;
import com.afiliates.demo.entities.AfiliateEntity;
import com.afiliates.demo.model.Afiliate;
import com.afiliates.demo.repository.IAfiliateRepository;
import com.afiliates.demo.services.IAfiliateService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AfiliateServiceImpl implements IAfiliateService<Afiliate> {

    private static final Logger logger = Logger.getLogger(AfiliateServiceImpl.class);

    @Autowired
    IAfiliateRepository afiliateRepo;

    @Override
    public List<Afiliate> findAll() {
        List<Afiliate> list = null;
        try {
            list = this.afiliateRepo.findAll().stream().map(
                    (e) -> {
                        Afiliate a = new Afiliate();
                        BeanUtils.copyProperties(e, a);
                        return a;
                    }).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }

    @Override
    public Afiliate findById(Long idKey) {
        Afiliate afil = null;
        try {
            AfiliateEntity entity = this.afiliateRepo.findById(idKey).get();
            afil = new Afiliate();
            BeanUtils.copyProperties(entity, afil);
        } catch(NoSuchElementException nsee){
            logger.info(nsee.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return afil;
    }

    @Override
    public Afiliate save(Afiliate model) {
        AfiliateEntity afiliateEntity = new AfiliateEntity();
        BeanUtils.copyProperties(model, afiliateEntity);
        afiliateEntity = this.afiliateRepo.save(afiliateEntity);
        model.setIdNumber(afiliateEntity.getIdNumber());
        return model;
    }

    @Override
    public void delete(Long idKey) {
        try {
            this.afiliateRepo.deleteById(idKey);
        }catch (EmptyResultDataAccessException erdae){
            logger.info(erdae.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }
}
