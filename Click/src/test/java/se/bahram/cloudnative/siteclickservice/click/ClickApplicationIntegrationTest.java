package se.bahram.cloudnative.siteclickservice.click;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import se.bahram.cloudnative.siteclickservice.click.models.Click;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

//@Testcontainers
class ClickApplicationIntegrationTest {


    private GenericContainer clickServiceContainer =
            new GenericContainer(DockerImageName.parse("click-service:1.0"))
                    .waitingFor(
                            Wait.forLogMessage(".*Service is Started.*", 1)
                    )
                    .withExposedPorts(9091);



    private RestTemplate restTemplate = new RestTemplate();

    @BeforeEach
    void setUp() {
        clickServiceContainer.start();
    }

    //@Test
    void shouldGet200WhenRequestIsCorrect() {
        Integer mappedPort = clickServiceContainer.getMappedPort(9091);
        String host = clickServiceContainer.getHost();
        String endPointUrl = "http://" + host + ":" + mappedPort + "/api/v1/";
        ResponseEntity<Click> response = restTemplate.postForEntity(
                endPointUrl,
                Click.builder()
                        .clientCode("1234")
                        .hostUrl("bahram.se")
                        .adCode("b232a7")
                        .actualClickTime(new Date())
                        .build(),
                Click.class,
                Map.of()
        );
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @AfterEach
    void tearDown() {
        clickServiceContainer.stop();
    }
}