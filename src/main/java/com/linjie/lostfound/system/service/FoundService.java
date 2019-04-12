package com.linjie.lostfound.system.service;

import com.linjie.lostfound.system.model.Found;
import com.linjie.lostfound.system.model.Lost;

import java.util.List;

public interface FoundService {
    List<Found> findAll();

    Found findById(Long id);

    void delete(Found found);

    void save(Found foud);
}
