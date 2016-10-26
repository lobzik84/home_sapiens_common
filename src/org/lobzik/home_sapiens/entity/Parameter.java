/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.home_sapiens.entity;

/**
 *
 * @author lobzik
 */

public class Parameter {

    private int id = 0;
    private String name = null;
    private String alias = null;
    private String description = null;
    private String pattern = null;
    private String unit = null;
    private String state = null;
    private Type type; 
    private Double calibration = null;
    
    public enum Type
    {   
        DOUBLE,  
        STRING,
        INTEGER,
        BOOLEAN, 
        INTEGER_COUNTER //incremental
    };

    public Parameter(int idP, String nameP, String aliasP, String descriptionP, String patternP, String unitP, Parameter.Type typeP, Double calibrationP) {
        id = idP;
        name = nameP;
        alias = aliasP;
        description = descriptionP;
        pattern = patternP;
        unit = unitP;
        type = typeP;
        calibration = calibrationP;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescription() {
        return description;
    }

    public String getPattern() {
        return pattern;
    }

    public String getUnit() {
        return unit;
    }

    public int getId() {
        return id;
    }
    
    public Double getCalibration() {
        return calibration;
    }


    public Parameter.Type getType() {
        return type;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}
