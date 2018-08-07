package com.aws.bq.service.impl;


import com.aws.bq.dao.IContractDAO;
import com.aws.bq.model.Contract;
import com.aws.bq.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: jiasfeng
 * @Date: 8/5/2018
 */
@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractDAO contractDAO;

    @Override
    public int add(Contract contract) {
        return contractDAO.add(contract);
    }

    @Override
    public int update(Contract contract) {
        return contractDAO.update(contract);
    }

    @Override
    public int delete(String contractId) {
        return contractDAO.delete(contractId);
    }

    @Override
    public Contract findContractById(String contractId) {
        return contractDAO.findContractById(contractId);
    }

    @Override
    public List<Contract> findContracts() {
        return contractDAO.findContracts();
    }
}
