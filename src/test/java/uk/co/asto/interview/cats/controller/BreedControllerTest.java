package uk.co.asto.interview.cats.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.asto.interview.cats.CatFactApiApplication;
import uk.co.asto.interview.cats.model.BreedDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = { CatFactApiApplication.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BreedControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnHttp200OnSuccess() throws Exception {
        ResponseEntity<List<BreedDTO>> response = this.restTemplate.exchange(
                "/breeds",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BreedDTO>>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}