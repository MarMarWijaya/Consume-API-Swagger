
package com.example.demo.services;

import com.example.demo.entities.Person;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonRestService {
    
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8086/api/delete/{id}";
    
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${api.uri}")
    private String uri;
    
    //getAll
    public List<Person> getAll(){
        List<Person> result;
        ResponseEntity<List<Person>> response = restTemplate.exchange(
                uri, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Person>>() {
                });
        result = response.getBody();
        return result;
    }
    
    //save
    public void save(Person person){
        restTemplate.postForObject(uri, person, Person.class);
    }
    
    public void deleteById(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);  
        restTemplate.delete(uri+"/delete/{id}", Person.class, params);
    }
    
    //getById
    public Person getById(String id){
        Person result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri+"/{id}", Person.class, param);
        return result;
    }
    
    public List<Person> getMaleGender(String gender){
        List<Person> result;
        ResponseEntity<List<Person>> response = restTemplate.exchange(
                uri + "/male", 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Person>>(){});
        result = response.getBody();
        return result;
    }
    
    public List<Person> getFemaleGender(String gender){
        List<Person> result;
        ResponseEntity<List<Person>> response = restTemplate.exchange(
                uri + "/female", 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Person>>(){});
        result = response.getBody();
        return result;
    }
    
}
