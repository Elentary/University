package by.bsu.labs.lab14.entity;

import java.awt.*;

/**
 * Created by amareelez on 13.12.16.
 */

public class Flower {
    private String name, origin;
    private Soil soil;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;
    private Multiplying multiplying;

    public Flower() {
    }

    public Flower(String name, String origin, Soil soil, VisualParameters visualParameters,
        GrowingTips growingTips, Multiplying multiplying) {
        this.name = name;
        this.origin = origin;
        this.soil = soil;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override public String toString() {
        return "Flower:<br>" + "name = '" + name + '\'' + "<br>origin = '" + origin + '\''
            + "<br>soil = " + soil + "<br>visualParameters = <br>" + visualParameters
            + "<br>growingTips = <br>" + growingTips + "<br>multiplying = " + multiplying;
    }

    public enum Multiplying {
        byLeaves, bySeed, byCutting
    }


    public static class VisualParameters {
        Color halm, leaf;
        double meanSize;

        public VisualParameters(String halm, String leaf, double meanSize) {
            this.halm = new Color(Integer.parseInt(halm.substring(0, 3)),
                Integer.parseInt(halm.substring(4, 7)), Integer.parseInt(halm.substring(8, 11)));
            this.leaf = new Color(Integer.parseInt(leaf.substring(0, 3)),
                Integer.parseInt(leaf.substring(4, 7)), Integer.parseInt(leaf.substring(8, 11)));
            this.meanSize = meanSize;
        }

        @Override public String toString() {
            return "\t{<br>halm = " + halm + "<br>\tleaf = " + leaf + "<br>\tmeanSize = " + meanSize
                + "<br>}";
        }
    }


    public static class GrowingTips {
        double temperature;
        boolean light;
        int watering;

        public GrowingTips(double temperature, boolean light, int watering) {
            this.temperature = temperature;
            this.light = light;
            this.watering = watering;
        }

        @Override public String toString() {
            return "\t{<br>temperature = " + temperature + "<br>\tlight = " + light
                + "<br>\twatering = " + watering + "<br>}";
        }
    }
}

