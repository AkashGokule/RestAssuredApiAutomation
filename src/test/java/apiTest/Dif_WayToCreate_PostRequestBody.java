package apiTest;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Dif_WayToCreate_PostRequestBody {
int id;
	//1) post request body using hasmap
	@Test
	public void testpost_using_hashmap() {
		HashMap data=new HashMap();
		data.put("name", "Akash gokule");
    	data.put("job", "Automation tester");
    	
    	given()
    	    .contentType("application/json")
    	    .body(data)
    	 
    	.when()
    	    .post("https://reqres.in/api/users")
    	    
    	.then()
    	 .statusCode(201)
 	     .log().all();
	}
	@Test
	public void testpost_using_jsonlibrary() {
		JSONObject data=new JSONObject();
    	data.put("email", "Akash@123");
    	data.put("first_name", "Akash");
    	data.put("last_name", "Gokule");
    	
    	id=given()
    	    .contentType("application/json")
    	    .body(data.toString())
    	 
    	.when()
    	    .post("https://reqres.in/api/users")
    	    .jsonPath().getInt("id");
//    	.then()
//    	 .statusCode(201)
// 	     .log().all(); 
    	
	}
	@Test
	public void testpost_using_pojoClass() {
		PojoClass data=new PojoClass();
    	data.setEmail("Akash@123");
    	data.setFirst_name("Akash");
    	data.setLast_name("Gokule");
    	String coursearr[]= {"c","c++"};
    	data.setCourse(coursearr);
    	
    	id=given()
    	    .contentType("application/json")
    	    .body(data)
    	 
    	.when()
    	    .post("https://reqres.in/api/users")
    	    .jsonPath().getInt("id");
//    	.then()
//    	 .statusCode(201)
// 	     .log().all(); 
	}
	@Test
	public void testpost_using_externaljsonFile() throws FileNotFoundException {
		
    	File f=new File(".\\Body.json");
    	FileReader fr=new FileReader(f); 
    	JSONTokener jt=new JSONTokener(fr);
    	JSONObject data=new JSONObject(jt);
    	
    	id=given()
    	    .contentType("application/json")
    	    .body(data.toString())
    	 
    	.when()
    	    .post("https://reqres.in/api/users")
    	    .jsonPath().getInt("id");
//    	.then()
//    	 .statusCode(201)
// 	     .log().all(); 
	}
	
	
	
	@Test(priority = 4)
	public void deleteUser() {
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/"+id)
		
		.then()
		  .statusCode(204)
		  .log().all()
		;
		
	}
}
