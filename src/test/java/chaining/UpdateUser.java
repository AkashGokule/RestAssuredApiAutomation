package chaining;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class UpdateUser {

	@Test
	public void test_updateUser(ITestContext context) {
		
		JSONObject data=new JSONObject();
		data.put("first_name", "Tushar");
		data.put("last_name", "jadhav");
		data.put("email", "Tushar@123");
		
    	
		int id =(int) context.getAttribute("user_id");
		//int id =(int) context.getSuite().getAttribute("user_id");  //suite lavel
		
		given()
    	    .contentType("application/json")
    	    .pathParam("id", id)
    	    .body(data.toString())
    	 
    	.when()
    	    .put("https://reqres.in/api/users/{id}")
	
		.then() 
		    .statusCode(200)
	        .log().all(); 
	
	}
}
