package com.amdocs.cargomanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.amdocs.cargomanagement.entity.Truck;
import com.amdocs.cargomanagement.exception.CargoNotFoundException;
import com.amdocs.cargomanagement.service.CargoService;
import com.amdocs.cargomanagement.service.TruckService;
;
@RestController
@RequestMapping("/trucks")
public class TruckController {
	private TruckService truckserv;
	private CargoService cargoserv;

	@Autowired
	public TruckController(TruckService truckserv,CargoService cargoserv) {
		//super();
		this.truckserv = truckserv;
		this.cargoserv = cargoserv;	}
	//Basic URI for API Testing
	
	//http://localhost:8085/books
	
	//insert into book_entity(book_name, pub_date)values(?,?);
	//http://localhost:8085/books/insert
	@PostMapping("/insert/{cid}")
	public Truck saveTruck(@RequestBody Truck truck, @PathVariable Integer cid) throws CargoNotFoundException
	{
		return truckserv.saveTruck(truck,cid) ;
	}
	
	//select *from book_entity
	//http://localhost:8085/books/allbooks

	@GetMapping("/allTrucks")
	public List<Truck> getAlltrucks()
	{
		return truckserv.getAlltrucks();
		
	}
	
	//select *from book_entity where truckno=?
	//http://localhost:8085/books/1
	@GetMapping("/{truckno}")
	public Truck getTruckById(@PathVariable int truckno)
	{
		return truckserv.getTruckById(truckno);
	}
	
	//http://localhost:8085/books/update/1
	@PutMapping("/update/{truckno}")
	public Truck updateTruck(@PathVariable int truckno,@RequestBody Truck truck)
	{
		return truckserv.updateTruck(truckno,truck);
	}
	
	
	@DeleteMapping("/delete/{truckno}")
	public void deleteTruck(@PathVariable int truckno)
	{
		truckserv.deletetruck(truckno);
	}
	

}
