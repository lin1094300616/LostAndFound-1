package com.linjie.lostfound.system.service;

import com.linjie.lostfound.system.model.Lost;

import java.util.List;

public interface LostService {
    List<Lost> findAll();

    Lost findById(Long id);

    void delete(Lost lost);

    void save(Lost lost);
}
