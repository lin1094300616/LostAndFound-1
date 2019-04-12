package com.linjie.lostfound.system.service.Imp;

import com.linjie.lostfound.system.dao.LostRepository;
import com.linjie.lostfound.system.model.Lost;
import com.linjie.lostfound.system.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class LostServiceImp implements LostService {
    @Autowired
    LostRepository lostRepository;

    @Override
    public List<Lost> findAll() {
        return lostRepository.findAll();
    }

    /**
     * @Author LINJIE
     * @Description  查询单条
     * @Content: TODO
     * @Date 2019/3/11 21:24
     * @Param
     * @return
     **/
    @Override
    public Lost findById(Long id) {
        Optional<Lost> lostOption = lostRepository.findById(id);
        return lostOption.isPresent() ? lostOption.get() : null;
    }

    @Override
    public void delete(Lost lost) {
        lostRepository.delete(lost);
    }

    @Override
    public void save(Lost lost) {
        lostRepository.save(lost);
    }
}
