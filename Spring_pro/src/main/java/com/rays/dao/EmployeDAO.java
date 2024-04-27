package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.EmployeDTO;

@Repository
public class EmployeDAO{
	
	@PersistenceContext
	public EntityManager entityManager;
	
	public Long add(EmployeDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}
	
	public void update(EmployeDTO dto) {
		entityManager.merge(dto);
	}
	
	public void delete(EmployeDTO dto) {
		entityManager.remove(dto);
	}
	public EmployeDTO findByPk(long pk) {
		EmployeDTO dto = entityManager.find(EmployeDTO.class, pk);
		return dto;
	}
	
	public List search(EmployeDTO dto) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<EmployeDTO> cq = builder.createQuery(EmployeDTO.class);

		Root<EmployeDTO> qRoot = cq.from(EmployeDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();


		TypedQuery<EmployeDTO> tq = entityManager.createQuery(cq);

		

		List<EmployeDTO> list = tq.getResultList();

		return list;
	}

}
