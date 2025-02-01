package epam.tasks.apitasks;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;



public class Task5 {
	@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
    }

	 @Test(priority=1)
	    public void getListOfEmployees() {
	        HashMap<String,Object> response = given()
	                .when()
	                .get("api/v1/employees")
	                .then()
	                .statusCode(200)
	                .contentType("application/json")
	                .extract().jsonPath().get("");

	        @SuppressWarnings("unchecked")
			List<String> employeesData = (List<String>) response.get("data");

	        System.out.println("Number of Employees"+ employeesData.size());
	    }

	 @Test(priority=2)
	    public void creatingAnEmployeeWithPost() {
	        String input ="{\r\n"
	                + "	\"name\": \"testTask\",\r\n"
	                + "	\"salary\": \"123\",\r\n"
	                + "	\"age\": \"24\"\r\n"
	                + "}";

	        given()
	                .body(input)
	                .when()
	                .post("api/v1/create")
	                .then()
	                .statusCode(201)
	                .contentType("application/json")
	                .extract().response();

	        HashMap<String,Object> response = given()
	                .when()
	                .get("api/v1/employees")
	                .then()
	                .statusCode(200)
	                .contentType("application/json")
	                .extract().jsonPath().get("");

	        @SuppressWarnings("unchecked")
			List<String> employeesData = (List<String>) response.get("data");

	        System.out.println("Number of Employees increased by 1"+ employeesData.size());
	    }

	 @Test(priority=3)
	    public void getDetailsOfNewlyCreatedEmployee() {

	        Response res =given().pathParam("id","25")
	                .when()
	                .get("api/v1/employee/{id}")
	                .then()
	                .statusCode(200)
	                .contentType("application/json")
	                .extract().response();

	        HashMap<String, String> hm= res.jsonPath().get("data");

	        Assert.assertEquals(hm.get("id"), "25");
	        Assert.assertEquals(hm.get("name"), "testTas");
	        Assert.assertEquals(hm.get("salary"), "123");
	        Assert.assertEquals(hm.get("age"), "24");

	    }

	    @Test(priority=4)
	    public void updateDetailsOfNewlyCreatedEmployee() {

	        String input = "{\r\n"
	                + "	\"name\": \"testTask\",\r\n"
	                + "	\"salary\": \"123456\",\r\n"
	                + "	\"age\": \"25\"\r\n"
	                + "}";

	        Response res =given().pathParam("id","25")
	                .body(input)
	                .when()
	                .put("api/v1/update/{id}")
	                .then()
	                .statusCode(200)
	                .contentType("application/json")
	                .extract().response();
	    }

	    @Test(priority=5)
	    public void getUpdatedDetailsOfNewlyCreatedEmployee() {

	        Response res =given().pathParam("id","25")
	                .when()
	                .get("api/v1/employee/{id}")
	                .then()
	                .statusCode(200)
	                .contentType("application/json")
	                .extract().response();

	        HashMap<String, String> hm= res.jsonPath().get("data");

	        Assert.assertEquals(hm.get("id"), "25");
	        Assert.assertEquals(hm.get("name"), "testTask");
	        Assert.assertEquals(hm.get("salary"), "123456");
	        Assert.assertEquals(hm.get("age"), "25");
	    }





}
