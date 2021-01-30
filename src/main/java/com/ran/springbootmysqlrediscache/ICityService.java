package com.ran.springbootmysqlrediscache;

import java.util.List;

public interface ICityService {

    List<City> findAll();

    City findById(Long id, String name);
}