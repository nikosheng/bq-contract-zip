package com.aws.bq.ecs.impl;

import com.amazonaws.services.ecs.AmazonECS;
import com.amazonaws.services.ecs.model.StopTaskRequest;
import com.aws.bq.ecs.IECSOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: jiasfeng
 * @Date: 8/6/2018
 */
@Service
public class ECSOperationImpl implements IECSOperation {
    @Autowired
    private AmazonECS client;
    @Value("${amazon.ecs.cluster.name}")
    private String ECS_CLUSTER_NAME;

    @Override
    public void stopTask(String taskArn) {
        StopTaskRequest stopReq = new StopTaskRequest().withCluster(ECS_CLUSTER_NAME)
                .withTask(taskArn);
        client.stopTask(stopReq);
    }
}
