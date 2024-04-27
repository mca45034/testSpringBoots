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

import com.rays.dto.CollageDTO;

@Repository
public class CollageDAO {
	@PersistenceContext
	public EntityManager entityManager;
	
	public Long add(CollageDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}
	public void update(CollageDTO dto) {
		entityManager.merge(dto);
		
	}
	public void delete(CollageDTO dto) {
		entityManager.remove(dto);
	}
	public CollageDTO findByPk(long pk) {
		CollageDTO dto=entityManager.find(CollageDTO.class, pk);
		return dto;
	}
	public List search(CollageDTO dto) {
		CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		CriteriaQuery<CollageDTO>cq=builder.createQuery(CollageDTO.class);
		Root<CollageDTO>qRoot=cq.from(CollageDTO.class);
		
		List<Predicate>predicateList=new ArrayList<Predicate>();
		TypedQuery<CollageDTO>tq=entityManager.createQuery(cq);
		
		List<CollageDTO> list=tq.getResultList();
		return list;
	}

}
