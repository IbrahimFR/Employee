package com.epam.employee.repo.dao;

import com.epam.employee.repo.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyDaoImp extends JpaRepository<Currency,Long> {
    Currency findAllByBase(String base);
}
