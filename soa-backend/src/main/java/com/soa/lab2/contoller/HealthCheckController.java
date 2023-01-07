package com.soa.lab2.contoller;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping()
@AllArgsConstructor
public class HealthCheckController {
    private DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate = new RestTemplate();



    @GetMapping("/discovery-client")
    public String discoveryPing() throws RestClientException,
            ServiceUnavailableException {
        URI service = serviceUrl()
                .map(s -> s.resolve("/ping"))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate.getForEntity(service, String.class)
                .getBody();
    }
    @GetMapping("/ping")
    public ResponseEntity ping() {
        return ResponseEntity.ok("Test health");
    }

    private Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("main-soa")
                .stream()
                .findFirst()
                .map(ServiceInstance::getUri);
    }
}
