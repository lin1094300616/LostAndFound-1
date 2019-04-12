package com.linjie.lostfound.system.service;

import com.linjie.lostfound.system.model.Lost;
import com.linjie.lostfound.system.model.Notice;
import com.linjie.lostfound.system.model.Thank;

import java.util.List;

public interface ThankService {
    List<Thank> findAll();

    Thank findById(Long id);

    void delete(Thank thank);

    void save(Thank thank);
}
