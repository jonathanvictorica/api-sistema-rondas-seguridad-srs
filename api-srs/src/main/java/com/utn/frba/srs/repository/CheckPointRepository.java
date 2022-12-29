package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.CheckPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckPointRepository extends JpaRepository<CheckPoint, String> {
    List<CheckPoint> findBySucursalCliente_id(Long subsidiaryId);
}