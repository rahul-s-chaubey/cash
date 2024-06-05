package com.idbiintech.cash.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.cash.DTO.SchemeDTO;
import com.idbiintech.cash.Service.SchemeMasterService;

@CrossOrigin
@RestController
public class SchemeController {
	
	@Autowired
	SchemeMasterService schememasterservice;

	
	@GetMapping("/getschemedata/{caste_name}/{income_bracket}")
	public List<SchemeDTO> getscheme(@PathVariable("caste_name") String casteName,
			@PathVariable("income_bracket") String incomeBracket) {
		
		
		List<SchemeDTO> schememaster = new ArrayList<>();
		
		
		schememaster = schememasterservice.getschemedata(casteName, incomeBracket);
		
		
		return schememaster;
		
	}
}
