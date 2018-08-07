package com.aws.bq.service;


import com.aws.bq.model.Contract;

import java.util.List;

/**
 * @Description:
 * @author: jiasfeng
 * @Date: 8/5/2018
 */
public interface IContractService {
    int add(Contract contract);
    int update(Contract contract);
    int delete(String contractId);
    Contract findContractById(String contractId);
    List<Contract> findContracts();
}
