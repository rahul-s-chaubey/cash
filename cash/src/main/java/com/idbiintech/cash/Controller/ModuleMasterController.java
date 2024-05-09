package com.idbiintech.cash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.cash.DTO.ModuleManagerResponseDTO;
import com.idbiintech.cash.DTO.ModulesDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.ServiceImpl.ModuleMasterRestServiceImpl;

@CrossOrigin
@RestController
public class ModuleMasterController {

	@Autowired
	ModuleMasterRestServiceImpl ModuleMasterRestServiceImpl;
	
	//Get All Modules List 
		@GetMapping("/getallmodulelist")
		public ResponseEntity<ModuleManagerResponseDTO> getallmodule() {
			
			ModuleManagerResponseDTO modulesdto = new ModuleManagerResponseDTO();
			ResponseUIVO responseUIVO=null;
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
			try {

			  
				modulesdto = ModuleMasterRestServiceImpl.getallmodule();
			
				status = HttpStatus.OK;
			
		}catch (Exception ex) {
			ex.printStackTrace();
		
		}

		
			return ResponseEntity.status(status).body(modulesdto);

		}
		
}
