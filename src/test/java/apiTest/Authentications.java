package apiTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Authentications {

	@Test
	public void test_BasicsAuth(){
		
		given()
		   .auth().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
    public void test_DigestsAuth(){
		
		given()
		   .auth().digest("postman", "passwor")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
    public void test_PreemtiveAuth(){
		
		given()
		   .auth().preemptive().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
}   
