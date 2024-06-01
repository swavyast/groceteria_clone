package com.groceteria.base.records;

import org.springframework.http.HttpStatus;

import com.groceteria.base.model.GroceteriaAdmin;

public record AdminControllerResponse(String message, HttpStatus status, GroceteriaAdmin adminInstance) {

}
