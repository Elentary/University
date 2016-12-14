package by.bsu.labs.lab14.action;

import by.bsu.labs.lab14.entity.Flower;
import by.bsu.labs.lab14.entity.Soil;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by amareelez on 14.12.16.
 */

public class Parser {
    public static ArrayList<Flower> parse(Element root) throws SAXException, IOException {
        ArrayList<Flower> flowers = new ArrayList<>();
        NodeList nodesFlowers = root.getElementsByTagName("flower");

        for (int i = 0; i < nodesFlowers.getLength(); i++) {
            Flower flower = new Flower();
            Element element = (Element) nodesFlowers.item(i);

            flower.setName(getChildValue(element, "name"));
            flower.setOrigin(getChildValue(element, "origin"));
            flower.setSoil(Soil.valueOf(getChildValue(element, "soil")));
            flower
                .setMultiplying(Flower.Multiplying.valueOf(getChildValue(element, "multiplying")));

            Flower.VisualParameters parameters = new Flower.VisualParameters(
                getChildValue(getChild(element, "visualParameters"), "halm"),
                getChildValue(getChild(element, "visualParameters"), "leaf"), Double
                .parseDouble(getChildValue(getChild(element, "visualParameters"), "meanSize")));
            flower.setVisualParameters(parameters);

            Flower.GrowingTips tips = new Flower.GrowingTips(
                Double.parseDouble(getChildValue(getChild(element, "growingTips"), "temperature")),
                Boolean.parseBoolean(getChildValue(getChild(element, "growingTips"), "light")),
                Integer.parseInt(getChildValue(getChild(element, "growingTips"), "watering")));
            flower.setGrowingTips(tips);

            flowers.add(flower);
        }

        return flowers;
    }

    private static Element getChild(Element e, String string) {
        return (Element) e.getElementsByTagName(string).item(0);
    }

    private static String getChildValue(Element element, String string) {
        return getChild(element, string).getFirstChild().getNodeValue();
    }
}
