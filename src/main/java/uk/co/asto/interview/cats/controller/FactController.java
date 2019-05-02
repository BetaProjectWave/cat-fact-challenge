package uk.co.asto.interview.cats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.co.asto.interview.cats.model.FactDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/facts")
public class FactController {
    private static final Logger LOG = LoggerFactory.getLogger(FactController.class.getSimpleName());

    private final RestTemplate restTemplate;

    @Autowired
    public FactController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<FactDTO>> getCatFacts() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/facts?limit=1000", Map.class);

        List<FactDTO> facts = new ArrayList<FactDTO>();

        for (Map entry : (List<Map>) response.getBody().get("data")) {
            facts.add(new FactDTO((String) entry.get("fact")));
        }

        return ResponseEntity.ok().body(facts);
    }
}
