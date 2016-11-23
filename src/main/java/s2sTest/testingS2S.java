/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s2sTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael
 */
public class testingS2S {

    public static void main(String[] args) {
        System.out.println("dfgdfg");
        testing();
        
    }

    public static void testing() {

        try {

            URL url = new URL("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-01-20T00:00:00.000Z/1");
            URLConnection connection = url.openConnection();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(connection.getInputStream());

            System.out.println(document);
            System.out.println(document.toString());
            NodeList currencyNodeList = document.getElementsByTagName("currency");

            Date now = new Date();

        } catch (MalformedURLException MalURLex) {

        } catch (IOException IOex) {

        } catch (ParserConfigurationException PCex) {

        } catch (SAXException SAXex) {

        }

    }

//    private double checkRate(String rateToCheck) {
//
//        double rate = 0;
//        try {
//            rate = Double.parseDouble(rateToCheck);
//        } catch (NumberFormatException e) {
//            rate = 0;
//        }
//        return rate;
//    }
}
