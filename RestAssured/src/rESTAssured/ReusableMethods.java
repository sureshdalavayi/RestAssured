package rESTAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {
	
	public static JsonPath rawToJson(Response R) {
		
		String response=R.asString();
		JsonPath x=new JsonPath(response);

		return x;
		
	}
	
	public static String GetToken() {
		
	RestAssured.baseURI="http://localhost:8080";
    
    Response Res=given().
    		header("Content-Type","application/json").
    		body("{ \"username\": \"suresh3190\", \"password\": \"Jira@3190\" }").
 
            when().
            post("/rest/auth/1/session").
            
            then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
            extract().response();
    		JsonPath JP=ReusableMethods.rawToJson(Res);
    		String token=JP.get("session.value");
			return token;

	}
}
