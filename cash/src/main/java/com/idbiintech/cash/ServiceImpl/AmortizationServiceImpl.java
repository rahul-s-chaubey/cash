package com.idbiintech.cash.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idbiintech.cash.Repository.AmortizationRepository;
import com.idbiintech.cash.Service.AmortizationService;


@Service
public class AmortizationServiceImpl implements AmortizationService{

	 @Autowired
	    private AmortizationRepository loanRepository;

	@Override
	 @Transactional
	public List<Object[]> getAmortizationSchedule(double loanAmount, double annualRate, int months) {
		  return loanRepository.calculateAmortization(loanAmount, annualRate, months);
    }


}