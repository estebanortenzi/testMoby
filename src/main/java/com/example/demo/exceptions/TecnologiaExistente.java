package com.example.demo.exceptions;

public class TecnologiaExistente extends RuntimeException{

    public TecnologiaExistente (String message){
        super(message);
    }
}
