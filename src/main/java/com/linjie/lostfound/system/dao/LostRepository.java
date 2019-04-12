package com.linjie.lostfound.system.dao;

import com.linjie.lostfound.system.model.Lost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostRepository extends JpaRepository<Lost,Long> {
}
