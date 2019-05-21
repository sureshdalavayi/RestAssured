package rESTAssured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class JIRA_Create_Issue_POST {

	public void CreateJIRAissue(String token) {

		given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+token).
		body("{\r\n" + 
				"	\"fields\":{\r\n" + 
				"		\"project\":\r\n" + 
				"		{\r\n" + 
				"			\"key\": \"RES\"\r\n" + 
				"		},\r\n" + 
				"		\"summary\": \"Rest Assured First Issue - Eclipse\",\r\n" + 
				"		\"description\": \"Creating First issue from Eclipse\",\r\n" + 
				"		\"issuetype\":{\r\n" + 
				"			\"name\": \"Bug\"\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}").
		
        when().
        post("/rest/api/2/issue").
        
        then().assertThat().statusCode(201).and().contentType(ContentType.JSON);
        System.out.println("Working as expected");


	}

}
