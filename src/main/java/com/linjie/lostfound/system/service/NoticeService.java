package com.linjie.lostfound.system.service;



import com.linjie.lostfound.system.model.Notice;
import java.util.List;

public interface NoticeService {

    List<Notice> findAll();

    Notice findById(Long id);

    void delete(Notice notice);

    void save(Notice notice);
}
