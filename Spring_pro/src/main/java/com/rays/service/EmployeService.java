package com.rays.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.EmployeDAO;
import com.rays.dto.EmployeDTO;

@Service
@Transactional
public class EmployeService {
	@Autowired
	public EmployeDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(EmployeDTO dto) {
		long pk=dao.add(dto);
		return pk;
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(EmployeDTO dto) {
		dao.update(dto);
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		try {
		EmployeDTO dto=findById(id);
		dao.delete(dto);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional(readOnly = true)
	public EmployeDTO findById(long pk) {
		EmployeDTO dto=dao.findByPk(pk);
		return dto;
	}
	@Transactional(readOnly = true)
	public List search(EmployeDTO dto) {
		List list=dao.search(dto);
		return list;
	}
	

}
