package com.afiliates.demo.entities;


import com.afiliates.demo.model.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Afiliates")
@Table (name = "afiliates")
public class AfiliateEntity {


    @Id
    @GeneratedValue
    @Column
    private long idNumber;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private States state;

    @OneToMany(mappedBy = "afiliate", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Purchase> purchases;

}
