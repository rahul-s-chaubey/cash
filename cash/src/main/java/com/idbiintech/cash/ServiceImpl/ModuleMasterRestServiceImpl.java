package com.idbiintech.cash.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.ModuleManagerResponseDTO;
import com.idbiintech.cash.DTO.ModulesDTO;
import com.idbiintech.cash.Entity.Modules;
import com.idbiintech.cash.Repository.ModuleMasterRepository;
import com.idbiintech.cash.Service.ModuleMasterService;

@Service
public class ModuleMasterRestServiceImpl implements ModuleMasterService {
	
	@Autowired
	ModuleMasterRepository modulemasterrepo;

	@Override
	public ModuleManagerResponseDTO getallmodule() {
		ModulesDTO moduledto = null;
		
		ModuleManagerResponseDTO modulemanagerresponseDTO =new ModuleManagerResponseDTO();
		List<ModulesDTO> list =new ArrayList<>();

		try {

			List<Modules> moduleMasterList = new ArrayList<>();
			moduleMasterList = modulemasterrepo.findAll();
			
			
			
			for (Modules moduleMaster : moduleMasterList) {
				moduledto = new ModulesDTO();
				BeanUtils.copyProperties(moduleMaster, moduledto);
				list.add(moduledto);
			}
			modulemanagerresponseDTO.setModuleDTOList(list);


			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return modulemanagerresponseDTO;
			
	}


}
