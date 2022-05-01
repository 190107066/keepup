package com.softsdu.keepup.service;

import java.util.Date;
import java.util.List;

import com.softsdu.keepup.domain.Magazine;
import com.softsdu.keepup.domain.MagazineStatus;
import com.softsdu.keepup.repository.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MagazineService {

	@Autowired
	private MagazineRepository magazineRepository;

	public Long getTotalCount() {
		return magazineRepository.count();
	}
	
	public Long getTotalBorrowedMagazines() {
		return magazineRepository.countByStatus(MagazineStatus.TAKEN);
	}
	
	public List<Magazine> getAll() {
		return magazineRepository.findAll();
	}
	
	public Magazine get(Long id) {
		return magazineRepository.findById(id).get();
	}
	
	public Magazine getByName(String name) {
		return magazineRepository.findByName(name);
	}
	
	public List<Magazine> get(List<Long> ids) {
		return magazineRepository.findAllById(ids);
	}
	
	public Magazine addNew(Magazine magazine) {
		magazine.setCreatedDate(new Date());
		magazine.setStatus(MagazineStatus.AVAILABLE );
		return magazineRepository.save(magazine);
	}
	
	public Magazine save(Magazine magazine) {
		return magazineRepository.save(magazine);
	}
	
	public void delete(Magazine magazine) {
		magazineRepository.delete(magazine);
	}
	
	public void delete(Long id) {
		magazineRepository.deleteById(id);
	}
	
	public boolean isTaken(Magazine magazine) {
		return false;
	}
}
