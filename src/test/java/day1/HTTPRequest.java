package day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HTTPRequest {
	
	int id;
	@Test
	public void gtetUsers() {
		
		
		given()
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	
	@Test
	(priority=2)
	public void createUser() {
		
		HashMap data=new HashMap();
			
		data.put("name", "vamsi");
		data.put("job", "Tester");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
	
		.jsonPath().getInt("id");
		
		
	//.then()
		//.statusCode(201)
		//.log().all();
		
		
	}
	@Test
	(priority=3,dependsOnMethods= {"createUser"})
	public void updateUser()
	{
		HashMap data=new HashMap();
		
		data.put("name", "vamshi");
		data.put("job", "developer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users/"+id)
	
		
		
		.then()
		.statusCode(201)
		.log().all();
		
}
	/*@Test
	(priority=4)
	public void delateUser() {
		
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
		
		
	}*/

	
	}


