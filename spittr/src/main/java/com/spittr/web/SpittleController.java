package com.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spittr.web.repository.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepository repository;

	@Autowired
	public SpittleController(SpittleRepository repository){
		this.repository = repository;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model){
		System.out.println("SpittleController.spittles()");
		model.addAttribute("spittleList",repository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}

}
