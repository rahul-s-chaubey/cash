package com.idbiintech.cash.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.cash.Service.AmortizationService;

@CrossOrigin
@RestController
public class AmortizationController {

	@Autowired
	private AmortizationService loanService;

	 @GetMapping("/amortization/{LOAN_AMOUNT}/{LOAN_INTEREST}/{LOAN_DURATION}")
	    public List<Object[]> getAmortizationSchedule(
	    		@PathVariable("LOAN_AMOUNT") double loanAmount,
	    		@PathVariable("LOAN_INTEREST") double annualRate,
	    		@PathVariable("LOAN_DURATION") int months
	    ) {
	        return loanService.getAmortizationSchedule(loanAmount, annualRate, months);
	    }
}
