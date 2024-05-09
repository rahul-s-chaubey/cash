package com.idbiintech.cash.Controller;


	 
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.cash.DTO.LoginDetailDTO;
import com.idbiintech.cash.Service.LoginRestService;


	 
@CrossOrigin
@RestController
public class LoginRestController 
{
	@Autowired
	LoginRestService LoginRestService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<LoginDetailDTO> login(@RequestBody LoginDetailDTO loginUIVO)
	{
		LoginDetailDTO loginDetailsUIVO = null;
		try 
		{
			loginDetailsUIVO = LoginRestService.getLoggedInUserDetails(loginUIVO.getEmailId(), loginUIVO.getPassword());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginDetailsUIVO);
	}

}