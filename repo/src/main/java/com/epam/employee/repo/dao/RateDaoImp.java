package com.epam.repo.dao;

import com.epam.repo.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateDaoImp extends JpaRepository<Rate,Long> {

}