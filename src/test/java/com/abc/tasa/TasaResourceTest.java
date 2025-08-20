package com.abc.tasa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class TasaResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/tipo-cambio")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}