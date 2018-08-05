package com.example.distance.utils.result;

public class ErrorResult extends Result {

    public ErrorResult(String message){
        this.status=0;
        this.message=message;
        this.data=0;
    }

    public ErrorResult(){
        this.status=0;
        this.message="error";
        this.data=0;
    }
}