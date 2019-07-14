package api;

import DTO.CurrencyValues;
import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static endpoints.EndPoints.PRIVATBANK_P24API_PUBINFO;
import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    public void privateBankTest(){
        CurrencyValues[] currencyValues =
        given()
                .contentType(ContentType.JSON)    // Header
                .queryParam("json")
                .queryParam("exchange")         //adding param to URL
                .queryParam("coursid", 5)
                .log().all()
        .when().get(PRIVATBANK_P24API_PUBINFO)
        .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response().getBody().as(CurrencyValues[].class);

        for (CurrencyValues currencyElement : currencyValues ) {
            System.out.println("Cur " + currencyElement.ccy + " to " + currencyElement.base_ccy + " has for buy " + currencyElement.buy + " and for sale " + currencyElement.sale);
        }

    }
}
