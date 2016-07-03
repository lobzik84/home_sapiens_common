/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lobzik.home_sapiens.entity;

import java.util.Date;
import org.lobzik.tools.Tools;

/**
 *
 * @author lobzik
 */
public class Measurement {
    private int intValue;
    private double doubleValue;
    private String stringValue;
    private long time;
    
    public Measurement(String value) {
        this.time = System.currentTimeMillis();
        this.stringValue = value;
        this.intValue = Tools.parseInt(stringValue, 0);
        this.doubleValue = Tools.parseDouble(stringValue, 0);
    }
    
    public long getTime() {
        return time;
    }
    
    public String getStringValue() {
        return stringValue;
    }
    
    public double getDoubleValue() {
        return doubleValue;
    }
    
    public int getIntValue() {
        return intValue;
    }
    
    public String toString() {
        String dateStr = Tools.getFormatedDate(new Date(time), "yyyy.MM.dd HH:mm:ss");
        return dateStr + " : " + stringValue;
    }
            
}
