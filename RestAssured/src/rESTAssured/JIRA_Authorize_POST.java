package rESTAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JIRA_Authorize_POST {
	
	public static void main(String args[]) {
		
		JIRA_Authorize_POST JAP=new JIRA_Authorize_POST();
		JAP.GetAuthorizeToken();
		
	}

	public void GetAuthorizeToken() {
		
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
	    		System.out.println(token);
	            System.out.println("Working as expected");
		
	}


}
