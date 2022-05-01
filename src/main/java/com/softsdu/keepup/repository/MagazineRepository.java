package com.softsdu.keepup.repository;

import com.softsdu.keepup.domain.Magazine;
import com.softsdu.keepup.domain.MagazineStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    public Magazine findByName(String name);
    public Long countByStatus(MagazineStatus status);
}
