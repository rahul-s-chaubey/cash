package com.idbiintech.cash.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.SchemeDTO;
import com.idbiintech.cash.Entity.SchemeMaster;
import com.idbiintech.cash.Repository.SchemeMasterRepository;
import com.idbiintech.cash.Service.SchemeMasterService;


@Service
public class SchemeMasterServiceImpl implements SchemeMasterService{
	
	
	@Autowired
	SchemeMasterRepository schememasterrepository;

	@Override
	public List<SchemeDTO> getschemedata(String casteName, String incomeBracket) {


		List<SchemeMaster> schememaster = new ArrayList<>();
		List<SchemeDTO> list =new ArrayList<>();
		
		
		
		SchemeDTO schemeDTO = null;
		
		schememaster = schememasterrepository.getSchemeMasterBycasteandincome(casteName, incomeBracket);
		
		
		for (SchemeMaster schemeMaster : schememaster) {
			schemeDTO = new SchemeDTO();
			BeanUtils.copyProperties(schemeMaster,schemeDTO);
			list.add(schemeDTO);
		}
		
//		schemeDTO = new SchemeDTO();
//		BeanUtils.copyProperties(schememaster,schemeDTO);
//		
		
		
		return list;
	}
	
	
	
}