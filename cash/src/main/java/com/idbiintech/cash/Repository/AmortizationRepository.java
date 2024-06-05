package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.LoanDetails;

@Repository
public interface AmortizationRepository extends CrudRepository<LoanDetails, Long> {

    @Procedure(name = "dealer.calculateAmortization")
    List<Object[]> calculateAmortization(
        @Param("p_loan_amount") double loanAmount,
        @Param("p_annual_rate") double annualRate,
        @Param("p_months") int months
    );
}
