package com.linjie.lostfound.system.service;

import com.linjie.lostfound.system.model.Journalism;
import com.linjie.lostfound.system.model.Lost;


import java.util.List;

public interface JournalismService {
    List<Journalism> findAll();

    Journalism findById(Long id);

    void delete(Journalism journalism);

    void save(Journalism journalism);
}
