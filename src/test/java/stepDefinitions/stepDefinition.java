package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import helpers.ReusableMethods;

import static org.junit.Assert.*;
import io.restassured.RestAssured;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;
import io.restassured.path.json.JsonPath;

public class stepDefinition
{
	
	//Request request;
	Response resspec;
	ReusableMethods reUse=new ReusableMethods();
	//String api_key="bc4f783b053748cdaf2db205c475fa4d";
	//String url="https://api.weatherbit.io/v2.0/forecast/daily?city=Raleigh,NC&key=bc4f783b053748cdaf2db205c475fa4d";
	 String getResponse;
	 @Given("I like to surf in any of two beaches {int} of Sydney")
	 public void i_like_to_surf_in_any_of_two_beaches_of_sydney(Integer postcode) throws IOException, ParseException {
	    
		 reUse.getweatherDetails(postcode)	;
			
	}
	@Given("I only like to surf on <Monday & Friday> in next {int} days")
	public void i_only_like_to_surf_on_monday_friday_in_next_days(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		//JsonPath js1 =new JsonPath(getResponse);
	/*	JsonPath js1=helpers.ReusableMethods. rawToJson(getResponse);
		String actualTemp =js1.getString("data.high_temp[0]");
		
		Assert.assertNotNull(actualTemp);*/
	    
	}
	@When("I look up the the weather forecast for the next {int} days with POSTAL CODES")
	public void i_look_up_the_the_weather_forecast_for_the_next_days_with_postal_codes(Integer int1) {
	    
	}
	@Then("I check to if see the temperature is between <{int}°C and {int}°C>")
	public void i_check_to_if_see_the_temperature_is_between_c_and_c(Integer int1, Integer int2) {
	   
	}
	@Then("I check wind speed to be between {int} and {int}")
	public void i_check_wind_speed_to_be_between_and(Integer int1, Integer int2) {
	    
	}
	@Then("I check to see if UV index is <= {int}")
	public void i_check_to_see_if_uv_index_is(Integer int1) {
	   
	}
	@Then("I Pick best suitable spot out of top two spots based upon suitable weather forecast for the day")
	public void i_pick_best_suitable_spot_out_of_top_two_spots_based_upon_suitable_weather_forecast_for_the_day() {
	    
	}


	
}