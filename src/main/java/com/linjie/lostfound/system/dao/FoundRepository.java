package com.linjie.lostfound.system.dao;

import com.linjie.lostfound.system.model.Found;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundRepository extends JpaRepository<Found,Long> {
}
