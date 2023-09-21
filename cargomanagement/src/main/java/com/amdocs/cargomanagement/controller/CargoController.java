package com.amdocs.cargomanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.cargomanagement.entity.Cargo;
import com.amdocs.cargomanagement.service.impl.CargoServiceImpl;




@Controller
public class CargoController {
@Autowired
private CargoServiceImpl crgService;


@RequestMapping("/")
public String loadForm(Model model)
{
	Cargo crg=new Cargo();
	model.addAttribute("crg", crg);
	
	return "cargo";
}

@RequestMapping("/insert")
public String handleCargoForm(@ModelAttribute("crg")Cargo crg,Model model)
{
	
	//intract to service layer
	boolean saveCargo = crgService.saveCargo(crg);
	
	String msg="";
	
	if(saveCargo)
		msg="Data Inserted SuccessFully";
	else
		msg="Data Not Inserted SuccessFully";
	
	model.addAttribute("msg", msg);
	return "cargo";
}

@RequestMapping("/viewAll")
public String viewAllCargos(Model model)
{
	//fetch the data from the databse ,can interact service layer
	List<Cargo> allCargos = crgService.getAllCargos();
	
	model.addAttribute("cargo", allCargos);
	return "view";
}

@RequestMapping("/deleteCrg")
public String deleteCargo(@RequestParam("cid")     int cid)
{
	boolean flag = crgService.deleteCargo(cid);
	
	if(flag)
	return "redirect:/viewAll";
	else
	return "redirect:/viewAll";
}

@RequestMapping("/editCrg")
public String editEmployee(@RequestParam("cid")   int cid,Model model)
{
	Cargo crg = crgService.getCargoId(cid);
	
	model.addAttribute("crg", crg);
	return "editCargo";
}

@RequestMapping("/update")
public String updateCargo(Cargo crg)
{
	boolean updateBook = crgService.updateDetails(crg);
	
	return "redirect:/viewAll";

}
}
