package uk.co.asto.interview.cats.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.asto.interview.cats.CatFactApiApplication;
import uk.co.asto.interview.cats.model.FactDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = { CatFactApiApplication.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnHttp200OnSuccess() throws Exception {
        ResponseEntity<List<FactDTO>> response = this.restTemplate.exchange(
                "/facts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FactDTO>>() {}
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnAllFactsWithNoFilter() throws Exception {
        final Integer unfilteredFactsCount = 332;

        ResponseEntity<List<FactDTO>> response = this.restTemplate.exchange(
                "/facts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FactDTO>>() {});

        assertThat(response.getBody()).hasSize(unfilteredFactsCount);
    }

    @Test
    public void shouldReturnFilteredFactsWithQueryParameter() throws Exception {
        final Integer filteredFactsCount = 11;
        final String queryParameter = "Egypt";

        ResponseEntity<List<FactDTO>> response = this.restTemplate.exchange(
                String.format("/facts?q=%s", queryParameter),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FactDTO>>() {});

        assertThat(response.getBody()).hasSize(filteredFactsCount);
    }

    @Test
    public void shouldReturnSpecifiedFactsWithNoFilter() throws Exception {
        final Integer limitAmount = 5;

        ResponseEntity<List<FactDTO>> response = this.restTemplate.exchange(
                String.format("/facts?limit=%d", limitAmount),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FactDTO>>() {});

        assertThat(response.getBody()).hasSize(limitAmount);
    }

    @Test
    public void shouldReturnSpecifiedFactsWithQueryFilter() throws Exception {
        final Integer limitAmount = 2;
        final String queryParameter = "Egypt";

        ResponseEntity<List<FactDTO>> response = this.restTemplate.exchange(
                String.format("/facts?q=%s&limit=%d", queryParameter, limitAmount),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FactDTO>>() {});

        assertThat(response.getBody()).hasSize(limitAmount);
    }
}