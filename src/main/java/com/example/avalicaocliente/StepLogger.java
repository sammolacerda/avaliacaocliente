package com.example.avalicaocliente;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class StepLogger implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        execution.getActivityInstanceId();
        execution.getEventName();
        execution.getProcessInstanceId();
        execution.getProcessBusinessKey();
        execution.getProcessDefinitionId();
        
     if (execution.getActivityInstanceId().contains("cad-cliente")) {
           log(execution);
        }
        if (execution.getActivityInstanceId().contains("verificar-dados")) {
            log(execution);
        }
      
    }

    private void log(DelegateExecution execution){
        System.out.println(String.format("%s - %s",execution.getCurrentActivityName(), execution.getEventName()));
    }

}
