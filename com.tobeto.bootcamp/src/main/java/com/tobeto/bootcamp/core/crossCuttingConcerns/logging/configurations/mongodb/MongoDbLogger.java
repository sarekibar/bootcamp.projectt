package com.tobeto.bootcamp.core.crossCuttingConcerns.logging.configurations.mongodb;

import com.tobeto.bootcamp.core.crossCuttingConcerns.logging.LogDetail;
import com.tobeto.bootcamp.core.crossCuttingConcerns.logging.LogParameter;
import com.tobeto.bootcamp.core.crossCuttingConcerns.logging.LoggerServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDbLogger extends LoggerServiceBase {
    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoDbLogger(MongoTemplate mongoTemplate) {
        super(MongoDbLogger.class);
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void log(String methodName, List<LogParameter> logParameters, String userName) {
        LogDetail detail = new LogDetail();
        detail.setMethodName(methodName);
        detail.setLogParameters(logParameters);
        detail.setUser(userName);
        info(detail.toString());
        mongoTemplate.save(detail);
    }
}
