package com.example.avalicaocliente;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import jakarta.inject.Named;
@Named
public class AprovaDadosFormulario implements JavaDelegate  {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String nome = (String) execution.getVariable("nome");
        String dataNascimento = execution.getVariable("dataNascimento").toString();

        
        Period idade = Period.between(converteDataNascimento(dataNascimento), LocalDate.now());

        if(idade.getYears() > 18){
            execution.setVariable("aprovado", true);
        } else {
            execution.setVariable("aprovado", false);
        }
    }

    private LocalDate converteDataNascimento(String dataNascimento) {
        String strDate = dataNascimento;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(strDate, formatter);
        return date;
    }

}
