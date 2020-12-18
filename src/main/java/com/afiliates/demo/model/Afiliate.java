package com.afiliates.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Afiliate {

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
