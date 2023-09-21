package com.amdocs.cargomanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.cargomanagement.entity.Cargo;
import com.amdocs.cargomanagement.repo.CargoRepository;
import com.amdocs.cargomanagement.service.CargoService;


@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository crgrepo;
	@Override
	public boolean saveCargo(Cargo crg) {
		// TODO Auto-generated method stub
		
		Cargo crgsave=crgrepo.save(crg);
		boolean flag=false;
		if(crgsave!=null)
			return true;
		return false;
	}

	@Override
	public List<Cargo> getAllCargos() {
		// TODO Auto-generated method stub
		
		List<Cargo> crgRecords=crgrepo.findAll();
		return crgRecords;
	}

	@Override
	public Cargo getCargoId(int cid) {
		// TODO Auto-generated method stub
		
		Optional<Cargo> crgId=crgrepo.findById(cid);
		Cargo crg=crgId.get();
		return crg;
	}

	@Override
	public boolean updateDetails(Cargo cs) {
		// TODO Auto-generated method stub
		return saveCargo(cs);
	}

	@Override
	public boolean deleteCargo(int cid) {
		// TODO Auto-generated method stub
		Cargo cg=getCargoId(cid);
		boolean flag=false;
		if(cg!=null)
		{
			crgrepo.delete(cg);
			flag=true;
		}
		return false;
	}

}
