package com.zm.mi.model;
public enum UnitsOfMeasurement {
    METER("m"),
    KILOMETER("km"),
    CENTIMETER("cm"),
    MILLIMETER("mm"),

    KILOGRAM("kg"),
    GRAM("g"),
    MILLIGRAM("mg"),

    LITER("L"),
    MILLILITER("mL"),

  
    SECOND("s"),
    MINUTE("min"),
    HOUR("h"),

    
    CELSIUS("°C"),
    FAHRENHEIT("°F");

    private final String isoCode;

   UnitsOfMeasurement(String isoCode) {
        this.isoCode = isoCode;
    }

    public  String getIsoCode() {
        return isoCode;
    }
}

