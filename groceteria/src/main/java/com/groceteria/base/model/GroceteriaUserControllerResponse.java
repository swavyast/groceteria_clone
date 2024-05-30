package com.groceteria.base.model;

import org.springframework.http.HttpStatus;

public record GroceteriaUserControllerResponse(String message, HttpStatus status, GroceteriaUser userInstance) {

}