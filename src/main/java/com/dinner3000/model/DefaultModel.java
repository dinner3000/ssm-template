package com.dinner3000.model;

import com.dinner3000.springmvc.model.DefaultForm;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DefaultModel implements Serializable{

    @NotNull
    @Size(min = 6, max = 12)
    private String name;

    @Min(1)
    @Max(9)
    private int value;

    @Min(1)
    @Max(9)
    private double result;

    public static DefaultModel ConvertFromDefaultForm(DefaultForm form){
        DefaultModel model = new DefaultModel();
        model.setName(form.getName());
        model.setValue(form.getValue());
        model.calculateResult();

        return model;
    }

    public double calculateResult(){
        this.result = value * 2;
        return this.result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getResult() {
        return result;
    }

    private void setResult(int result) {
        this.result = result;
    }
}
