package com.utn.frba.srs.service;

import com.utn.frba.srs.exception.CatalogoErrores;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.CheckPoint;
import com.utn.frba.srs.repository.CheckPointRepository;
import com.utn.frba.srs.repository.SucursalClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointService {

    private final CheckPointRepository checkPointRepository;
    private final SucursalClienteRepository sucursalClienteRepository;

    public CheckpointService(CheckPointRepository checkPointRepository, SucursalClienteRepository sucursalClienteRepository) {
        this.checkPointRepository = checkPointRepository;
        this.sucursalClienteRepository = sucursalClienteRepository;
    }

    public List<CheckPoint> findBySubsidiary(Long subsidiaryId) {
        return checkPointRepository.findBySucursalCliente_id(subsidiaryId);
    }

    public void create(CheckPoint checkPoint) throws SRSException {
        sucursalClienteRepository.findById(checkPoint.getSucursalCliente().getId()).orElseThrow(() ->  new SRSException(CatalogoErrores.SUCURSAL_NO_EXISTE));
        checkPointRepository.save(checkPoint);
    }

    public void update(CheckPoint checkPoint) throws SRSException {
        sucursalClienteRepository.findById(checkPoint.getSucursalCliente().getId()).orElseThrow(() ->  new SRSException(CatalogoErrores.SUCURSAL_NO_EXISTE));
        checkPointRepository.save(checkPoint);
    }

    public void delete(String nfcIdentify) {
        checkPointRepository.deleteById(nfcIdentify);
    }
}
