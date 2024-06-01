package com.groceteria.base.records;

import org.springframework.http.HttpStatus;

import com.groceteria.base.model.GroceteriaVendor;

public record VendorControllerResponse(String message, HttpStatus status, GroceteriaVendor vendorInstance) {

}
