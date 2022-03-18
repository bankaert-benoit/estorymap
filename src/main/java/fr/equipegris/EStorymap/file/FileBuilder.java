package fr.equipegris.EStorymap.file;

import com.nimbusds.oauth2.sdk.id.Actor;
import fr.equipegris.EStorymap.diagramme.mcd.Attribut;
import fr.equipegris.EStorymap.diagramme.mcd.Entity;
import fr.equipegris.EStorymap.diagramme.mcd.Mcd;
import fr.equipegris.EStorymap.diagramme.mfc.Mfc;
import fr.equipegris.EStorymap.diagramme.mfc.composant.Acteur;
import fr.equipegris.EStorymap.diagramme.mfc.composant.Flux;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileBuilder {

    public static Mfc buildMfc(MultipartFile file) {
        String titre = file.getOriginalFilename();
        Document doc = null;
        try {
            doc = fileToDocument(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Acteur> acteurs = getMfcActeurs(doc);
        Set<Flux> flux = getMfcFlux(doc);

        return new Mfc(titre, acteurs, flux);
    }

    public static Mcd buildMcd(MultipartFile file) {
        String titre = file.getOriginalFilename();
        Document doc = null;
        try {
            doc = fileToDocument(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Entity> entities = getMcdEntity(doc);

        return new Mcd(titre,entities);
    }

    private static Document fileToDocument(MultipartFile file) throws IOException {
        return convertStringToXMLDocument(new String(file.getBytes()));
    }

    private static Document convertStringToXMLDocument(String xmlString)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Créer une liste d'acteurs à partir d'un Document doc
     * @param doc
     * @return la liste des acteurs
     */
    private static Set<Acteur> getMfcActeurs(Document doc) {
        Set<Acteur> acteurs = new HashSet<>();
        NodeList nodes = doc.getElementsByTagName("mxCell");
        for(int i = 0; i < nodes.getLength(); i++){
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE ) {
                Element element = (Element) node;
                if (element.getAttribute("style").contains("umlActor")){
                    acteurs.add(new Acteur(element.getAttribute("value")));
                }
            }
        }
        return acteurs;
    }

    /**
     * Créer une liste de flux à partir d'un Document doc
     * @param doc
     * @return la liste des flux
     */
    private static Set<Flux> getMfcFlux(Document doc) {
        Set<Flux> flux = new HashSet<>();
        NodeList nodes = doc.getElementsByTagName("mxCell");
        for(int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String value = element.getAttribute("value");
                if (value.matches("F\\d+ : [\\w\\s]+") ) {
                    Flux f = new Flux(value, value.split(" : ")[0], value.split(" : ")[1]);
                    flux.add(f);
                }
            }
        }
        return flux;
    }

    private static Set<Entity> getMcdEntity(Document doc){
        Set<Entity> entities = new HashSet<>();
        NodeList nodes = doc.getElementsByTagName("entite");
        for(int i = 0; i < nodes.getLength(); i++){
            Node node = nodes.item(i);
            NodeList attribut = node.getChildNodes();
            if (node.getNodeType() == Node.ELEMENT_NODE ) {
                Element element = (Element) node;
                String nom = element.getAttribute("name");

                entities.add(new Entity(nom, getMcdEntityAttribut(attribut)));
            }
        }
        return entities;
    }

    private static Set<Attribut> getMcdEntityAttribut(NodeList attribut){
        Set<Attribut> res = new HashSet<>();
        for(int i = 0; i < attribut.getLength(); i++){
            Node node = attribut.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String nom = element.getAttribute("name");
                String type = element.getAttribute("type");
                res.add(new Attribut(nom,type));
            }
        }
        return res;
    }
}
