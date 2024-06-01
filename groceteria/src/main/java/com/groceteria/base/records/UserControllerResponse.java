package com.groceteria.base.records;

import org.springframework.http.HttpStatus;

import com.groceteria.base.model.GroceteriaUser;

public record UserControllerResponse(String message, HttpStatus status, GroceteriaUser userInstance) {

}