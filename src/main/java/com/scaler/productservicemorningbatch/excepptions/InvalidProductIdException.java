package com.scaler.productservicemorningbatch.excepptions;

public class InvalidProductIdException extends Exception {
    public InvalidProductIdException(String message) {
        super(message);
    }
}
