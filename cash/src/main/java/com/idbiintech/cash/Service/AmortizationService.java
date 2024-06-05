package com.idbiintech.cash.Service;

import java.util.List;

import com.idbiintech.cash.DTO.DealerManagerDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Entity.DealerMaster;

public interface AmortizationService {

	 public List<Object[]> getAmortizationSchedule(double loanAmount, double annualRate, int months);
}
