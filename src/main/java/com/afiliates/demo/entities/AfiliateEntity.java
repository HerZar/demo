package com.afiliates.demo.entities;


import com.afiliates.demo.model.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Afiliates")
@Table (name = "afiliates")
public class AfiliateEntity {

    @Id
    @GeneratedValue
    private long idNumber;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String address;

    private States state;

    private Date startDate;

    private Date endDate;

}
