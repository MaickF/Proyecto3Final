/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;


import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author pc
 */
public class ControlXml { 
    private static ArrayList<Usuario> usuario = new ArrayList();
    public ControlXml(){}
    public void addUsuario(Usuario nuevo){
        usuario.add(nuevo);
    }
    /**
     * Escribe la informacion guardad en la lista.
     */
    public void save(){
        try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// elemento raiz
		Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("Usuarios");
                doc.appendChild(rootElement);
                int tamano = usuario.size();
                for(int i = 0; i<tamano; i++){
                    Element empleado = doc.createElement("Usuario");
                    rootElement.appendChild(empleado);
                    // atributo del elemento empleado
                    Attr attr = doc.createAttribute("id");
                    String valor = String.valueOf(i);
                    attr.setValue(valor);
                    empleado.setAttributeNode(attr);

                    // nombre
                    Element universo = doc.createElement("Nombre");
                    universo.appendChild(doc.createTextNode(usuario.get(i).getNombre()));
                    empleado.appendChild(universo);
                   // nombre
                    Element nombre = doc.createElement("Apellidos");
                    nombre.appendChild(doc.createTextNode(usuario.get(i).getApellidos()));
                    empleado.appendChild(nombre);

                    // apellidos
                    Element apellidos = doc.createElement("Correo");
                    apellidos.appendChild(doc.createTextNode(usuario.get(i).getCorreoElectronico()));
                    empleado.appendChild(apellidos);

                    // seccion
                    Element seccion = doc.createElement("Contrasenna");
                    seccion.appendChild(doc.createTextNode(usuario.get(i).getContrasenna()));
                    empleado.appendChild(seccion);
                    
                    /*Element cantV = doc.createElement("CantVitorias");
                    valor = String.valueOf(usuario.get(i).getCantV());
                    cantV.appendChild(doc.createTextNode(valor));
                    empleado.appendChild(cantV);
                    
                    Element cantE = doc.createElement("CantEmpates");
                    valor = String.valueOf(usuario.get(i).getCantE());
                    cantE.appendChild(doc.createTextNode(valor));
                    empleado.appendChild(cantE);
                    
                    Element cantD = doc.createElement("CantDerrotas");
                    valor = String.valueOf(usuario.get(i).getCantD());
                    cantD.appendChild(doc.createTextNode(valor));
                    empleado.appendChild(cantD);*/
                    
                }
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("src/documentXml/Usuarios.xml"));
		//StreamResult result = new StreamResult(new File("archivo.xml"));
 
		// Si se quiere mostrar por la consola...
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
        }catch (ParserConfigurationException pce) {
		pce.printStackTrace();
        } catch (TransformerException tfe) {
		tfe.printStackTrace();
	}
    }
    /**
     * Carla lista con el archivo en la lista
     * 
     * @throws ParserConfigurationException 
     */
    public void readXml() throws ParserConfigurationException{
        try {

            File fXmlFile = new File("src\\documentXml\\Usuarios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Usuario");

             System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String Staff = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                    String FirstName =eElement.getElementsByTagName("Apellidos").item(0).getTextContent();
                    String Last = eElement.getElementsByTagName("Correo").item(0).getTextContent();
                    String NickName = eElement.getElementsByTagName("Contrasenna").item(0).getTextContent();
                    Usuario nuevo = new Usuario(Staff,FirstName,Last,NickName);
                    addUsuario(nuevo);//Aqui debe ir la clase;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
