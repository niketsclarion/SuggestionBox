package com.clarion.hackathon.backend.function;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.clarion.hackathon.backend.model.InputModel;
import com.clarion.hackathon.backend.model.ModuleMaster;
import com.clarion.hackathon.backend.service.ModuleService;
import com.clarion.hackathon.backend.service.impl.ModuleServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;

/**
 * This Aws-Lambda Class is used manage a Transaction on based of ID. so if you
 * pass transaction id it will return your detail of that Transaction.
 *
 * @author niket
 */
public class AwsLAmbdaGetModules implements RequestHandler<InputModel, List<ModuleMaster>> {

    /**
     * This function is used to get transaction id as input and return a Transaction
     * model on based of your Input id.
     *
     * @param input({@link InputIdRequest}
     * @return {@link TransactionModel}
     */
    @Override
    public List<ModuleMaster> handleRequest(InputModel inputModel, Context context) {
        ModuleService moduleService = ModuleServiceImpl.Instance();

        try {

            return moduleService.getAllModules();
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}