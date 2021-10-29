package com.GregV3.SpringBootV3.service;

import com.GregV3.SpringBootV3.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ConsumingRestApiService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Car> ListeDesVoitures() {
        return restTemplate.getForObject("http://localhost:9091/Cars",List.class);
    }
    public Car AfficherUneBelleVoiture(int id){
        return restTemplate.getForObject("http://localhost:9091/Cars/" + id, Car.class);
    }
    public Boolean SupprimerLaCaisse(int id) {
        restTemplate.delete("http://localhost:9091/Cars/{id}",id);
        return true;
    }
    public Car RentreLaCaisseDansLeGarage(Car newCar) {
        return restTemplate.postForObject("http://localhost:9091/Cars/add/", newCar, Car.class);
    }
    public Car OnVaPimperTaCaisse(Car updateCar, int id) {
        restTemplate.put("http://localhost:9091/Cars/" + id,updateCar,Car.class);
        return updateCar;
    }
}
