package StepDefinitions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestNGReport {
	
Response response;
	
	@DataProvider(name="values")
	public Object[][] dataForGet(){
		Object[][] data = new Object[2][3];
		data[0][0]="2020";
		data[0][1]="11";
		data[0][2]="30";
		
		data[1][0]="2020";
		data[1][1]="12";
		data[1][2]="15";
		return data;
	}
	
	@Test
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange() {
		RestAssured.baseURI="https://api.ratesapi.io";
	}

	@Test(dataProvider="values")
	@When("posted with future date information")
	public void posted_with_future_date_information(String year, String month, String date) {
		response = RestAssured.get("/api/"+year+"-"+month+"-"+date);
	}

	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
		int StatusCode = response.getStatusCode();
	    System.out.println("Response Code : "+StatusCode);
		
	}
}
