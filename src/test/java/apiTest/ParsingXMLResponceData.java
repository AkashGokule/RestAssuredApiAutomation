package apiTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingXMLResponceData {
	
	
	@Test(priority = 1)
	public void verifyJsonfield() {
		Boolean status=false;
		//approch 1
//		given()
//		   
//		 .when()
//		   .get("https://reqres.in/api/users?page=2")//enter url 
//		   
//		  .then()
//		  .statusCode(200)
//		  .header("Content-Type","application/xml; charset=utf-8")
//		  .body("maintag.smalltag",equals("value"))
//		  .body("parenttagname.smalltag.smalltag[index].lasttagname", equals("lasttagvalue"));
//		
		//approch 2
//		Response res = given()
//		   
//		 .when()
//		   .get("https://reqres.in/api/users?page=2")//enter url 
		   
}
	
}
