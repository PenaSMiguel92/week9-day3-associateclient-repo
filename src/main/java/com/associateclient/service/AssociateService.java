package com.associateclient.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.associateclient.entity.Associate;

@Service
public class AssociateService {
    private RestTemplate restTemplate;

    public AssociateService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String saveAssociate(Associate associate) {
        HttpEntity<Associate> entity = new HttpEntity<>(associate);
        return restTemplate.exchange("http://localhost:8005/AddAssociate", HttpMethod.POST, entity, String.class)
                .getBody();
    }
    
    public List<Associate> getAssociate() {
        return restTemplate.exchange("http://localhost:8005/ShowAssociate", HttpMethod.GET, null, List.class)
                .getBody();
    }

}
