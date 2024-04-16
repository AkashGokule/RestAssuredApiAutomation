package apiTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	@Test
	public void testPathAndQueryParameters() {
		//https://reqres.in/api/users?page=2
		given()
		   .pathParam("Mypath", "users")    //path parameter
		   .queryParam("page", "2")         //query parameter
		
		.when()
		  .get("https://reqres.in/api/{Mypath}") //only path parameter required in {}
		
		.then()
		  .statusCode(200)
		  .log().all()
		;		
	}
}
