package com.ran.springbootmysqlrediscache;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "cities")
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
//    @Cacheable
    public List<City> findAll() {
        System.out.println("CityService :findAll() {}");
        return (List<City>) repository.findAll();
    }

    @Override
    @Cacheable(key = "#id+'__'+#name")
    public City findById(Long id, String name) {
        System.out.println("CityService :findById() {}:"+id);
        return Optional.ofNullable(repository.findById(id)).get().orElse(null);
    }
}