package org.example.api.automation;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class OpenWeather {
    String url = "https://home.openweathermap.org/pricing";
    @Test
    public void display(){
       Response response = given().
                           when().
                           get(url);
        System.out.println(response.prettyPrint());
        System.out.println("The response status code is " + response.statusCode());
        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println("The current is shown as " + jsonObject.get("currency"));
        JSONObject jsonWeatherObj = jsonObject.getJSONObject("prices").getJSONObject("weather");
        //System.out.println(jsonWeatherObj.get("startup").getClass());
        Assert.assertEquals(jsonWeatherObj.get("startup"),30,"The startup is not matching");
        System.out.println("The startup value is matching");
    }

}
