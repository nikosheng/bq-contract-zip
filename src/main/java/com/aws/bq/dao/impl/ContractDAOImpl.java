package com.aws.bq.dao.impl;


import com.aws.bq.dao.IContractDAO;
import com.aws.bq.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: jiasfeng
 * @Date: 8/5/2018
 */
@Repository
public class ContractDAOImpl implements IContractDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Contract contract) {
        return jdbcTemplate.update("insert into contract(contract_id, contract_num) values(?, ?)",
                contract.getContractId(),
                contract.getClientNum());
    }

    @Override
    public int update(Contract contract) {
        return 0;
    }

    @Override
    public int delete(String contractId) {
        return jdbcTemplate.update("delete from contract where contract_id = ?", contractId);
    }

    @Override
    public Contract findContractById(String contractId) {
        List<Contract> contracts = jdbcTemplate.query(
                "select * from contract where contract_id = ?",
                new Object[]{contractId},
                new RowMapper<Contract>() {
                    @Override
                    public Contract mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        Contract contract = new Contract();
                        contract.setContractId(resultSet.getString("contract_id"));
                        contract.setContractNum(resultSet.getString("contract_num"));
                        contract.setS3Bucket(resultSet.getString("s3_bucket"));
                        contract.setS3Key(resultSet.getString("s3_key"));
                        return contract;
                    }
                }
        );

        if (null != contracts && contracts.size() > 0) {
            Contract contract = contracts.get(0);
            return contract;
        }
        return null;
    }

    @Override
    public List<Contract> findContracts() {
        List<Contract> contracts = new ArrayList<>();
        contracts = jdbcTemplate.query(
                "select * from contract",
                new Object[]{},
                new RowMapper<Contract>() {
                    @Override
                    public Contract mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        Contract contract = new Contract();
                        contract.setContractId(resultSet.getString("contract_id"));
                        contract.setContractNum(resultSet.getString("contract_num"));
                        contract.setS3Bucket(resultSet.getString("s3_bucket"));
                        contract.setS3Key(resultSet.getString("s3_key"));
                        return contract;
                    }
                }
        );
        return contracts;
    }
}
