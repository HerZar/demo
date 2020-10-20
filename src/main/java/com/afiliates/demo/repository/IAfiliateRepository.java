package com.afiliates.demo.repository;

import com.afiliates.demo.entities.AfiliateEntity;
import com.afiliates.demo.model.Afiliate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAfiliateRepository extends JpaRepository<AfiliateEntity, Long> {

}
