package uk.co.asto.interview.cats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.co.asto.interview.cats.model.BreedDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/breeds")
public class BreedController {
    private static final Logger LOG = LoggerFactory.getLogger(BreedController.class);

    private final RestTemplate restTemplate;

    @Autowired
    public BreedController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<List<BreedDTO>> getCatBreeds() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/breeds", Map.class);

        List<BreedDTO> breeds = new ArrayList<>();

        for (Map entry : (List<Map>) response.getBody().get("data")) {
            breeds.add(new BreedDTO(
                    (String) entry.get("breed"),
                    (String) entry.get("country"),
                    (String) entry.get("origin"),
                    (String) entry.get("coat"),
                    (String) entry.get("pattern")));
        }

        return ResponseEntity.ok().body(breeds);
    }
}
