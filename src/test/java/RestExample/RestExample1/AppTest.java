package RestExample.RestExample1;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void GetProductsDetails() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println(response.getStatusLine());
		System.out.println(response.asString());
		response = httpreq.get("");
		// Postive case
		int statusCode = response.getStatusCode();
		Assert.assertEquals("The status Code", statusCode, 200);
		System.out.println(statusCode);

	}

	@Test
	public void GetProductsDetailsHeaderResponse() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		Headers header = response.headers();

		for (Header headersec : header) {
			System.out.println("value " + headersec.getName() + " " + ":" + headersec.getValue());
		}
	}

	@Test
	public void GetProductsDetailsHeaderResponseoneAtaTime() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		String header = response.header("Server");
		System.out.println(header);
		String header1 = response.header("Content-Type");
		System.out.println(header1);

	}

	@Test
	public void GetProductsDetailsResponseBody() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		ResponseBody resbody = response.getBody();

		System.out.println(resbody.asString());

	}

	@Test
	public void GetProductsDetailsResponseBodyvalidation() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");

		ResponseBody resbody = response.getBody();

		String response1 = resbody.asString();
		Assert.assertEquals(response1.toLowerCase().contains("1"), true);

	}

	@Test

	public void GetProductsJsonPath() {

		RestAssured.baseURI = "https://dummyjson.com/products/1";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");

		response = httpreq.get("");
		JsonPath jsonpath = response.jsonPath();

		String id = jsonpath.get("title");
		System.out.println(id);

	}

	@Test
	public void GetProductsDetailsqueryparam() {

		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.queryParam("id", "1").get("/products");
		ResponseBody body = response.body();
		ResponseBody resbody = response.getBody();
		String response1 = resbody.asString();
		JsonPath jpath = new JsonPath(response1);
		String title = jpath.getString("title");
		System.out.println(title);

	}

	@Test
	public void B_POST() throws IOException {
		RestAssured.baseURI = "https://dummyjson.com/products";

		byte[] b = Files.readAllBytes(Paths.get("src/resources/java/json/widgrt.json"));
		String Post_data = new String(b);

		Response response = given().contentType(ContentType.JSON).body(Post_data)

				.when().post("/add")

				.then().log().all().assertThat().statusCode(200).extract().response();

	}

	@Test
	public void putRequest() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/resources/java/json/widgrt.json"));

		// convert byte array to string
		String bdy = new String(b);

		// base URL
		RestAssured.given()

				.baseUri("https://dummyjson.com").contentType(ContentType.JSON).body(bdy)

				// adding post method
				.when().put("/products/1").then().log().all()

				// verify status code as 201
				.assertThat().statusCode(200);

	}

	// Delete Request
	// @Test
	public void deleteRequest() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/resources/java/json/widgrt.json"));

		// convert byte array to string
		String bdy = new String(b);

		// base URL
		RestAssured.given()

				.baseUri("https://dummyjson.com").contentType(ContentType.JSON).body(bdy)

				// adding post method
				.when().delete("/products/1").then().log().all()

				// verify status code as 201
				.assertThat().statusCode(200);
	}

}
