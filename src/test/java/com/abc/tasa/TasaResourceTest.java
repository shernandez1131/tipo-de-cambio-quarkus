package com.abc.tasa;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class TasaResourceTest {

    @Test
    void testTipoCambioEndpoint() {
        given()
                .queryParam("dni", "12345678")
                .when().get("/tipo-cambio")
                .then()
                .statusCode(200);
    }
}