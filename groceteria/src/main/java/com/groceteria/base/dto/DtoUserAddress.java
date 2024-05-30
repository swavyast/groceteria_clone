package com.groceteria.base.dto;

import lombok.Data;

@Data
public class DtoUserAddress {

    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String country;
    private Integer pincode;

}
