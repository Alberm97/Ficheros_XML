import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File archivoXML = new File("C:\\Users\\alber\\Desktop\\peliculas.xml"); // Reemplaza con la ruta de tu archivo XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            NodeList listaPeliculas = doc.getElementsByTagName("Pelicula");

            for (int i = 0; i < listaPeliculas.getLength(); i++) {
                Node nodoPelicula = listaPeliculas.item(i);

                if (nodoPelicula.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPelicula = (Element) nodoPelicula;
                    System.out.println("Título: " + elementoPelicula.getElementsByTagName("Titulo").item(0).getTextContent());
                    System.out.println("Duración: " + elementoPelicula.getElementsByTagName("Duracion").item(0).getTextContent() + " minutos");
                    System.out.println("Género: " + elementoPelicula.getElementsByTagName("Genero").item(0).getTextContent());
                    System.out.println("Sinopsis: " + elementoPelicula.getElementsByTagName("sinopsis").item(0).getTextContent());
                    NodeList listaActores = elementoPelicula.getElementsByTagName("Actor");
                    System.out.print("Actores: ");
                    for (int j = 0; j < listaActores.getLength(); j++) {
                        System.out.print(listaActores.item(j).getTextContent());
                        if (j < listaActores.getLength() - 1) {
                            System.out.print(", ");
                        }
                    }
                        System.out.println();
                        System.out.println("Fecha: " + elementoPelicula.getElementsByTagName("Fecha").item(0).getTextContent());
                        System.out.println("Director: " + elementoPelicula.getElementsByTagName("Director").item(0).getTextContent());
                        System.out.println();
                }
            }
        } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
