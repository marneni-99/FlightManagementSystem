package com.cg.fms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.BookingDao;

@Service
@Transactional
public class ServiceClass implements IService {

	@Autowired
	BookingDao bookingObject;

	@Override
	public boolean cancelTickets(long id) {
		// To check whether given id exists
		boolean b = bookingObject.existsById(id);
		// If exists cancel tickets
		if (b) {
			bookingObject.deleteById(id);
		}
		return b;
	}

}
