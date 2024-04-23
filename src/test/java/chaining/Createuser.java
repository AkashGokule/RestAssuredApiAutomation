package chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Createuser {

	@Test
	public void test_CreateUser(ITestContext context) {
		
		JSONObject data=new JSONObject();
		data.put("first_name", "Akash");
		data.put("last_name", "Gokule");
		data.put("email", "Akash@123");
		
		int id = given()
	    	    .contentType("application/json")
	    	    .body(data.toString())
	    	 
	    	.when()
	    	    .post("https://reqres.in/api/users")
	    	    .jsonPath().getInt("id");
		context.setAttribute("user_id", id);
		//context.getSuite().setAttribute("user_id", id);
	}
	
	
	
}
