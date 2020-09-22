package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Booking;
import com.cg.fms.service.IService;

@RestController
@RequestMapping("/Cancel")
@CrossOrigin("http://localhost:4200")
public class Controller {


	@Autowired
	IService flightScheduleService;
	
	//For canceling flight ticket
	@DeleteMapping("/CancelTickets/{id}")
	public ResponseEntity<String> addBookingDetails(@PathVariable("id") long id){

		boolean b= flightScheduleService.cancelTickets(id);
		if(!b)
			return new ResponseEntity<String>("Id doesnt exist",HttpStatus.OK);
		else		
			return new ResponseEntity<String>("Cancelled tickets",HttpStatus.OK);

	}

	
	

}
