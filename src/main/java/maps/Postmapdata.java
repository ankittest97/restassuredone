package maps;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Jsonpayload;
public class Postmapdata {

	//String baseURI;
	
	public static void  main(String[] args) {
		
	
	// validate if add place api is working as expected
	
//there are 3 methods we are using those should be wrapped under API
	//given - all input details what you need for an API
	//WHEN - submit the actual API (all http request get,post ,put ,delete will be here)
	//Then - validate the response
	
	//1st you have to set BaseURI
	RestAssured.baseURI="https://rahulshettyacademy.com";
	//firstgive query parameters , then headers , 
	String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body(Jsonpayload.AddPlace())
	//now you need to submit your API with post http method on this resource
	.when().post("/maps/api/place/update/json")
	//after it submits  we need to validate the response
	.then().log().all().assertThat().statusCode(200)
	
	//now we need to validate if response contains "scope": "APP",
	.body("scope",equalTo("APP")) //EQUALtO is coming from hamcrest package
	.header("server", "Apache/2.4.52 (Ubuntu)")  //need to validate whether response is coming from correct server
	//Add place --> update place with new address --> get place to validate if new address is present
	.extract().response().asString(); //with this I want to get response as string but need to catch somewhere
	
	//to print the respnse either user log
	System.out.println(response);
	
	//now we want to extract the response and do further validation
	//so how to extract json , there is a clas called JsonPath // it is a class which take string as input and converts to json
	JsonPath js = new JsonPath(response); //for parsing json //it wil take input as string i.e. response
	String placeid = js.getString("place_id"); //we are storing placeid value in a string placeid is in responce and we need to make use of that
	
	System.out.println(placeid);
	
	String newaddress = "70 avenue";
	
	//now we want to use put http method //update
	given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\""+newaddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	.when().put("/maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	//Get place
	//In get http method everything should be passed as a url only nothing is there in body
	
	String getPlaceresponse = given().log().all().queryParam("key","qaclick123")
	.queryParam("place_id", placeid)
	.when().get("/maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	JsonPath js1 = new JsonPath(getPlaceresponse);
	String actualaddress = js1.getString("address");
	System.out.println(actualaddress);
	
	Assert.assertEquals(actualaddress, newaddress);
	
	
}

}

