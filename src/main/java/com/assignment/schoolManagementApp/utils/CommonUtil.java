package com.assignment.schoolManagementApp.utils;

import com.assignment.schoolManagementApp.models.response.GenericRs;

public class CommonUtil {

    public static GenericRs isNotFound(){

        GenericRs response = new GenericRs();
        response.setCode("404");
        response.setStatus("Failed");
        response.setMessage("Failed - The ID is not found ");

        return response;
    }

    public static GenericRs isSuccess(){
        GenericRs response = new GenericRs();
        response.setCode("00");
        response.setStatus("Success");
        response.setMessage("Success");

        return response;
    }
    public static GenericRs isSuccess(Object data){
        GenericRs response = new GenericRs();
        response.setCode("00");
        response.setStatus("Success");
        response.setMessage("Success");
        response.setData(data);

        return response;
    }
}
