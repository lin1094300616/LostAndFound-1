package com.linjie.lostfound.system.service.Imp;

import com.linjie.lostfound.system.dao.NoticeRepository;
import com.linjie.lostfound.system.model.Lost;
import com.linjie.lostfound.system.model.Notice;
import com.linjie.lostfound.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImp implements NoticeService {
    @Autowired
    NoticeRepository noticeRepository;
    @Override
    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice findById(Long id) {
        Optional<Notice> noticeOption = noticeRepository.findById(id);
        return noticeOption.isPresent() ? noticeOption.get() : null;
    }

    @Override
    public void delete(Notice notice) {
        noticeRepository.delete(notice);
    }

    @Override
    public void save(Notice notice) {
        noticeRepository.save(notice);
    }




}
