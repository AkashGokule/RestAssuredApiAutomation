package apiTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.testng.annotations.Test;

public class LoggDemo {
	@Test(priority = 1)
	public void getLogg() {
		
		given()
		
		 .when()
		   .get("https://reqres.in/api/users?page=2")
		
		 .then()
		   .statusCode(200)
		   //.log().all()
		   //.log().body()
		   //.log().cookies()
		   .log().headers()
	;}
		
}
