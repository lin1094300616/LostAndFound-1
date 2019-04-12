package com.linjie.lostfound.system.service.Imp;

import com.linjie.lostfound.system.dao.JournalismRepository;
import com.linjie.lostfound.system.model.Journalism;
import com.linjie.lostfound.system.service.JournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalismServiceImp implements JournalismService {
    @Autowired
    JournalismRepository journalismRepository;
    @Override
    public List<Journalism> findAll() {
        return journalismRepository.findAll();
    }

    @Override
    public Journalism findById(Long id) {
        Optional<Journalism> journalismOption = journalismRepository.findById(id);
        return journalismOption.isPresent() ? journalismOption.get() : null;
    }

    @Override
    public void delete(Journalism journalism) {
        journalismRepository.delete(journalism);
    }

    @Override
    public void save(Journalism journalism) {
        journalismRepository.save(journalism);
    }
}
