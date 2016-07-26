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
    private Measurement measurement = null;
    private Measurement prevMeasurement = null;
    private String description = null;
    private String pattern = null;
    private String unit = null;
    private Object data = null;

    public Parameter(int idP, String nameP, String aliasP, Measurement measurementP, String descriptionP, String patternP, String unitP) {
        id = idP;
        name = nameP;
        alias = aliasP;
        measurement = measurementP;
        description = descriptionP;
        pattern = patternP;
        unit = unitP;
    }

    public void setData(Object dataP) {
        data = dataP;
    }

    public void set(Measurement measurementP) {
        prevMeasurement = measurement;
        measurement = measurementP;
    }

    public Measurement get() {
        return measurement;
    }
/*
    public String getF() {
        return Formatter.format(value, false);
    }

    public String getFU() {
        return Formatter.format(this, true);
    }
*/
    public Measurement getPrevious() {
        return prevMeasurement;
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

    public Object getData() {
        return data;
    }
}
