package com.amdocs.cargomanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.amdocs.cargomanagement.entity.Cargo;
import com.amdocs.cargomanagement.entity.Truck;
import com.amdocs.cargomanagement.exception.CargoNotFoundException;
import com.amdocs.cargomanagement.repo.CargoRepository;
import com.amdocs.cargomanagement.repo.TruckRepository;
@Service
public class TruckService {
private TruckRepository truckrepo;
private CargoRepository cargorepo;
	
	@Autowired
	public TruckService(TruckRepository truckrepo,CargoRepository cargorepo) {
		//super();
		this.truckrepo = truckrepo;
		this.cargorepo= cargorepo;
	}


	//crud operations
	//savetruck data
	//insert query is generated at runtime by server using hibernate and jpa
	public Truck saveTruck(Truck truck,Integer cid) throws CargoNotFoundException
	{

		Cargo cargo1= cargorepo.findById(cid).orElse(null);
		if(cargo1!=null)
		{
			truck.setCargo(cargo1);
		return truckrepo.save(truck); 
		}
		else
		{
			throw new CargoNotFoundException("Cargo details not found") ;
		}
	}
	

	public List<Truck> getAlltrucks()
	{
		return truckrepo.findAll();
	}
	
	public 	Truck getTruckById(int truckno)
	{
		return truckrepo.findById(truckno).orElse(null);
	}

	public Truck updateTruck(int truckno, Truck truck)
	{
		Truck existingtruck=truckrepo.findById(truckno).orElse(null);
		
		if(existingtruck!=null)
		{
			existingtruck.setDriverName(truck.getDriverName());
			existingtruck.setLiscence(truck.getLiscence());
		return truckrepo.save(existingtruck);
		}
		return null;
	}
	
	public void deletetruck(int truckno)
	{
		 truckrepo.deleteById(truckno);
	}


	
}
