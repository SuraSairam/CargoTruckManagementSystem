package com.amdocs.cargomanagement.service;

import java.util.List;

import com.amdocs.cargomanagement.entity.Cargo;



public interface CargoService {
public boolean saveCargo(Cargo crg);
	
	public List<Cargo> getAllCargos();
	
	public Cargo getCargoId(int cid);

	public boolean updateDetails(Cargo cs);

	public boolean deleteCargo(int cid);
	

}
