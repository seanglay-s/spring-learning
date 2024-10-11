package com.example.library_management_system.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus statusCode, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("statusCode", statusCode.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, statusCode);
    }
}
