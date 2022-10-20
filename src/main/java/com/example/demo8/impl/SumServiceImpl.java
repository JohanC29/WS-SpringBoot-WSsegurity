package com.example.demo8.impl;

import com.example.demo8.WSSecurityInterceptor;
import localhost.sumservice.schema.GetSumRequest;
import localhost.sumservice.schema.GetSumResponse;
import localhost.sumservice.wsdl.SumServicePort;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Service;

@Service
@SchemaValidation(type = SchemaValidation.SchemaValidationType.REQUEST)
@InInterceptors(classes = WSSecurityInterceptor.class)
public class SumServiceImpl implements SumServicePort {
    @Override
    public GetSumResponse getSum(GetSumRequest parameters) {
        GetSumResponse response = new GetSumResponse();
        response.setResult(parameters.getAddendOne()+ parameters.getAddendTwo());
        return response;
    }
}
