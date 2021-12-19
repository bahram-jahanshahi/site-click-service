package se.bahram.cloudnative.siteclickservice.click.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.bahram.cloudnative.siteclickservice.click.models.Click;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClickControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @DisplayName("Should Get 200 When Request Is Correct")
    @Test
    public void shouldGet200WhenRequestIsCorrect() {
        ResponseEntity<Click> response = testRestTemplate
                .postForEntity(
                        "/api/v1/",
                        Click.builder()
                                .clientCode("1234")
                                .hostUrl("bahram.se")
                                .adCode("b232a7")
                                .actualClickTime(new Date())
                                .build(),
                        Click.class,
                        Map.of()
                );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @DisplayName("Should Get 400 When Request Is Not Correct")
    @Test
    public void shouldGet400WhenRequestIsNoCorrect() {
        ResponseEntity<Click> response = testRestTemplate
                .postForEntity(
                        "/api/v1/",
                        Click.builder().build(),
                        Click.class,
                        Map.of()
                );
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


}