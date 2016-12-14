package by.bsu.labs.lab14.action;

import by.bsu.labs.lab14.entity.Flower;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by amareelez on 14.12.16.
 */

public class Run {

    private static final String s = "<html><head></head><body>";
    private static final String s1 = "</body></html>";

    public static void main(String[] args) throws IOException {
        DOMParser parser = new DOMParser();
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema s = sf.newSchema(new File("src/by/bsu/labs/lab14/xml/DataBase.xsd"));
            Validator v = s.newValidator();
            v.validate(new StreamSource(new File("src/by/bsu/labs/lab14/xml/DataBase.xml")));
            parser.parse("src/by/bsu/labs/lab14/xml/DataBase.xml");

            ArrayList<Flower> flowers = Parser.parse(parser.getDocument().getDocumentElement());

            flowers.sort(Comparator.comparing(Flower::getName));

            File html = new File("src/by/bsu/labs/lab14/xml/DataBase.html");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(html));
            bufferedWriter.write(Run.s);

            for (Flower flower : flowers) {
                bufferedWriter.write(flower.toString() + "<br>");
                for (int i = 0; i < 73; i++) {
                    bufferedWriter.write("-");
                }
                bufferedWriter.write("<br>");
            }
            bufferedWriter.write(s1);
            bufferedWriter.close();

            for (Flower flower : flowers) {
                System.out.println(flower);
                for (int i = 0; i < 73; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }


        } catch (SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
