package helpers;

//import static org.AssertJUnit.assertEquals;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import resources.Utils;

public class ReusableMethods {

	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
	
	/*public void getweatherDetails(int postcode) throws ParseException, java.text.ParseException, IOException{

		 {
			 
		 String getResponse;
	RestAssured.baseURI=Utils.getGlobalValue("url");
	getResponse = given().when().queryParam("postal_code",postcode).queryParam("key",Utils.getGlobalValue("api_key")).get(Utils.getGlobalValue("url")).then().assertThat().log().all().statusCode(200).extract().response().asString();
		
	JsonPath js1=helpers.ReusableMethods. rawToJson(getResponse);
	String actualTemp =js1.getString("data.high_temp[0]");
	
	Assert.assertNotNull(actualTemp);
		 }*/
	 public void getweatherDetails(int postcode) throws ParseException, java.text.ParseException, IOException{

		 {
		        RestAssured.baseURI = Utils.getGlobalValue("url");
		        RequestSpecification httpRequest = RestAssured.given().baseUri(Utils.getGlobalValue("url")).param("key", Utils.getGlobalValue("api_key")).param("postal_code", postcode);
		        Response response = httpRequest.get();
		        System.out.println(response.asString());
		        int count = 0;

		        List<Map<String, String>> jsonResponse = response.jsonPath().getList("data");
		        int statusCode = response.getStatusCode();

		           // Assert that correct status code is returned.
		        assertEquals(200,statusCode);
		        for (Map<String, String> var : jsonResponse) {
		            Date date=new SimpleDateFormat("yyyy-MM-dd").parse((String.valueOf(var.get("datetime"))));
		            Calendar c = Calendar.getInstance();
		           c.setTime((java.util.Date) date);
		            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		            String dayWeekText = new SimpleDateFormat("EEEE").format(date);
		            if (dayWeekText.equals("Monday") || dayWeekText.equals("Friday")) {
		                if ((Float.parseFloat(String.valueOf(var.get("low_temp"))) > 12) &&
		                        (Float.parseFloat(String.valueOf(var.get("high_temp"))) < 30)) {
		                    if((Float.parseFloat(String.valueOf(var.get("wind_spd"))) > 3) &&
		                        (Float.parseFloat(String.valueOf(var.get("wind_spd"))) <=12)) {
		                        if ((Float.parseFloat(String.valueOf(var.get("uv")))) <= 12) {
		                            System.out.println("==========================");
		                            System.out.println("LowTemp: "+Float.parseFloat(String.valueOf(var.get("low_temp"))));
		                            System.out.println("HighTemp: "+Float.parseFloat(String.valueOf(var.get("high_temp"))));
		                            System.out.println("WindSpeed: "+Float.parseFloat(String.valueOf(var.get("wind_spd"))));
		                            System.out.println("UV: "+Float.parseFloat(String.valueOf(var.get("uv"))));
		                            System.out.println("Date: "+String.valueOf(var.get("datetime")));
		                            System.out.println("Day: "+dayWeekText);

		                            //  postcode[count]  = String.valueOf(var.get("low_temp"));
		                        }
		                    }
		                }

		            }

		        }

		    }
	 }
}
