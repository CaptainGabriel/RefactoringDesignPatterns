package com.gabriel.strategy;

public class Validator {

    private ValidationStrategy strat;

    public Validator(ValidationStrategy strat){
        this.strat = strat;
    }

    public boolean isUpperCase(String toEval){
        return strat.execute(toEval);
    }

}
