package com.chetan.springboot.mvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chetan.springboot.mvc.dao.dao;
import com.chetan.springboot.mvc.entity.User;



@RestController
public class controller {

	@Autowired
	private dao userdao;
	
	
	@GetMapping("/")
	public ModelAndView home() {
		System.out.println("Going home...");
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@GetMapping("/register")
	  public ModelAndView showForm(Model model) {
		    User user = new User();
		    List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");
		     
		    model.addAttribute("user", user);
		    model.addAttribute("professionList", professionList);
		   // System.out.println(user);//null
		    ModelAndView mav1 = new ModelAndView("register_form");
			return mav1;
		}
	  
	  
	  @PostMapping("/save")
	  public ModelAndView submitForm(@Valid @ModelAttribute("user") User user, 
			  BindingResult bindingResult, Model model) {
	       
	      //System.out.println(user);
	      
	      if (bindingResult.hasErrors()) {
				List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
				model.addAttribute("professionList", professionList);			
				ModelAndView mav1 = new ModelAndView("register_form");
				return mav1;
			}
			
	      userdao.save(user);	
	      ModelAndView mav2 = new ModelAndView("register_success");
			return mav2;
	      
	  }
	  
	  @GetMapping(value="/show/all")
		public Iterable<User> getAllUser(){
			return userdao.findAll();
		}

}

/*
 * @Controller public class controller {
 * 
 * @RequestMapping("/") public String home() {
 * System.out.println("Going home..."); return "index"; }
 * 
 * @GetMapping("/register") public String showForm(Model model) { User user =
 * new User(); List<String> professionList = Arrays.asList("Developer",
 * "Designer", "Tester");
 * 
 * model.addAttribute("user", user); model.addAttribute("professionList",
 * professionList);
 * 
 * return "register_form"; }
 * 
 * 
 * @PostMapping("/register") public String submitForm(@ModelAttribute("user")
 * User user) {
 * 
 * System.out.println(user);
 * 
 * return "register_success"; } }
 * 
 */


  
 