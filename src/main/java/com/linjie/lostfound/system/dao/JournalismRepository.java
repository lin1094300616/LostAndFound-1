package com.linjie.lostfound.system.dao;

import com.linjie.lostfound.system.model.Journalism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalismRepository extends JpaRepository<Journalism,Long> {
}
