package com.idbiintech.cash.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.cash.DTO.ResponseUIVO;

import jakarta.websocket.server.PathParam;

@CrossOrigin
@RestController
public class AmortizationController {
	
	
	@PostMapping("/calculateinterest")
	public ResponseEntity<ResponseUIVO> calculateinterest(@PathVariable String interest, @PathVariable String tenure, @PathVariable String loanamount ) 
	{
		
		
		try 
		{
			
		}
		catch(Exception ex)
		{
			
		}
		
		return null;
		

	}
	

}
