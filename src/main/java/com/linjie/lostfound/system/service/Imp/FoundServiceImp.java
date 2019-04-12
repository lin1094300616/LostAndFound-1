package com.linjie.lostfound.system.service.Imp;

import com.linjie.lostfound.system.dao.FoundRepository;
import com.linjie.lostfound.system.model.Found;

import com.linjie.lostfound.system.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoundServiceImp implements FoundService {
    @Autowired
    FoundRepository foundRepository;
    @Override
    public List<Found> findAll() {
        return foundRepository.findAll();
    }

    @Override
    public Found findById(Long id) {
        Optional<Found> foundOption = foundRepository.findById(id);
        return foundOption.isPresent() ? foundOption.get() : null;
    }

    @Override
    public void delete(Found found) {
        foundRepository.delete(found);
    }

    @Override
    public void save(Found found) {
        foundRepository.save(found);
    }
}
