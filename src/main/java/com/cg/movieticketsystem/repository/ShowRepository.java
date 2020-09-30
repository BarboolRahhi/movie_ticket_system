package com.cg.movieticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movieticketsystem.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

}
