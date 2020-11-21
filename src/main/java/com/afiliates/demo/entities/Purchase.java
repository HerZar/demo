package com.afiliates.demo.entities;


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
@Entity
@Table(name = "purchases")
public class Purchase {

    public Purchase(long id, Date date) {
        this.id = id;
        this.date = date;
    }

    @Id
    @GeneratedValue
    @Column
    long id;

    @Column
    Date date;

    AfiliateEntity afiliate;

}
