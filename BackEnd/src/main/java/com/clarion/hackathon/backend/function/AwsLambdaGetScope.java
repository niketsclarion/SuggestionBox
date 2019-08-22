package com.clarion.hackathon.backend.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.clarion.hackathon.backend.model.InputModel;
import com.clarion.hackathon.backend.model.ModuleMaster;
import com.clarion.hackathon.backend.model.ScopeMaster;
import com.clarion.hackathon.backend.service.ScopeService;
import com.clarion.hackathon.backend.service.impl.ScopeServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;

import java.util.List;

public class AwsLambdaGetScope  implements RequestHandler<InputModel, List<ScopeMaster>> {

    @Override
    public List<ScopeMaster> handleRequest(InputModel inputModel, Context context) {

        ScopeService scopeService = ScopeServiceImpl.Instance();

        try {

            return scopeService.getAllScopeMaster();
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
