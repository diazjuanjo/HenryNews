package com.henry.base.controller;

import com.henry.base.model.response.ApiWeatherResponse;
import com.henry.base.service.ApiCallService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/api")
@RestController
public class ApiCallController {

    @Autowired
    ApiCallService apiCallService;

    @GetMapping
    @Operation(summary = "Endpoints for API weather")
    public Object callApi() {
        try{
            ApiWeatherResponse apiWeatherResponse = apiCallService.callAPI();
            if (apiWeatherResponse.getLocation() == null){
                return apiCallService.callAPI2();
            }
            return apiWeatherResponse;
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

}
