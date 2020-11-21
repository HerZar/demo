package com.afiliates.demo.model;

import com.afiliates.demo.entities.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Afiliate {

    @NotNull
    @NotEmpty
    private long idNumber;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastName;

    private String phoneNumber;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    private String address;

    private States state;

    private List<Purchase> purchases;

}
