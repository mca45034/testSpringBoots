package com.rays.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.CollageDAO;
import com.rays.dto.CollageDTO;
import com.rays.dto.EmployeDTO;

@Service
@Transactional
public class CollageService {
	@Autowired
	public CollageDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(CollageDTO dto) {
		long pk=dao.add(dto);
		return pk;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(CollageDTO dto) {
		dao.update(dto);
	}
	@Transactional(propagation = Propagation.REQUIRED)
   public void delete(long id) {
		try {
			CollageDTO dto=findById(id);
			dao.delete(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Transactional(readOnly = true)
	public CollageDTO findById(long pk) {
		CollageDTO dto=dao.findByPk(pk);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List search(CollageDTO dto) {
		List list=dao.search(dto);
		return list;
	}
	
	
   

}
