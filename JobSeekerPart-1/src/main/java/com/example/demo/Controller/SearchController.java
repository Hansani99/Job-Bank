package com.example.demo.Controller;

import com.example.demo.vo.EmployerRespponse;
import com.example.demo.vo.SearchRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class SearchController {
    private final String SEARCH_URL = "http://localhost:8080/employer/search/jobs";
    private final String FIND_URL = "http://localhost:8080/employer/find/job";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/search/jobs")
    public ResponseEntity<EmployerRespponse> searchJobs(@RequestBody SearchRequestVO searchRequest) {
        EmployerRespponse employerRespponse = restTemplate.postForObject(SEARCH_URL, searchRequest, EmployerRespponse.class);
        return ResponseEntity.of(Optional.of(employerRespponse));

    }

    @PostMapping("/find/job")
    public ResponseEntity<EmployerRespponse> findJob(@RequestBody SearchRequestVO searchRequest) {
        EmployerRespponse employerRespponse = restTemplate.postForObject(FIND_URL, searchRequest, EmployerRespponse.class);
        return ResponseEntity.of(Optional.of(employerRespponse));

    }
}
