package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EastAsiaCountries {
    public String code;
    public String name;
    public float area;
    public String terrain;

    public EastAsiaCountries(String code, String name, float area, String terrain) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.terrain = terrain;
    }

    public void display() {
        System.out.println("Country Code: " + code);
        System.out.println("Country Name: " + name);
        System.out.println("Total Area: " + area);
        System.out.println("Country Terrain: " + terrain);
        System.out.println("=========================");
    }

    // Getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}