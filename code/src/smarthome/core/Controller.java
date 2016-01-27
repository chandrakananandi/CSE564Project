package smarthome.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import smarthome.pair.Pair;

public abstract class Controller implements Item {

    /**
     * a data structure to store a String ID of a controller and a list of pairs of controlled
     * dumb devices and the commands sent to them
     */
    public HashMap<String, ArrayList<Pair>> under_control;

    /**
     * get the list of dumb devices controlled by this controller
     *
     * @return
     */
    public ArrayList<DumbDevice> getControlledDumbDevices() {

        ArrayList<DumbDevice> ret = new ArrayList<DumbDevice>();
        ArrayList<Pair> dd_comm_pair = new ArrayList<Pair>();

        dd_comm_pair.addAll(under_control.get(this.getID()));

        for (int x = 0; x < dd_comm_pair.size(); x++) {
            ret.add(dd_comm_pair.get(x).getDumbDevice());
        }
        return ret;
    }

    /**
     * get the list of sensors on which this controller relies. This is obtained by parsing the dependency policy file.
     *
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public Set<String> getSensors(String xmlFileControllerName)
            throws ParserConfigurationException, SAXException, IOException {

        Set<String> sensorname_list = new HashSet<String>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFileControllerName.concat("_policy.xml"));
        document.getDocumentElement().normalize();
        NodeList nodelist = document.getElementsByTagName("sensor");
        for (int x = 0; x < nodelist.getLength(); x++) {
            Node node = nodelist.item(x);
            Element e = (Element) node;
            sensorname_list.add(e.getAttribute("name"));
        }
        return sensorname_list;
    }

    /**
     * sends command to a dumb device
     */
    public abstract void sendCommandToDumbDevice(Command c, DumbDevice d);

    /**
     * get ID of the controller
     *
     * @return
     */
    @Override
    public abstract String getID();

    /**
     * returns a list of all the commands this controller can issue
     */
    public abstract ArrayList<Command> getCommands();

    /**
     * this function takes a dumb devices and detects all the commands that dumb device can execute
     */
    public abstract void detectCommandsDumbDevice(DumbDevice d);

    /**
     * updates the data structure storing the dumb devices and commands by copying the information from
     * all the controllers.
     *
     * @return
     */
    public void updateTable(HashMap<String, ArrayList<Pair>> table) {

    }

    /**
     * returns a list of all the discovered controllers in the house
     */
    public ArrayList<Controller> discoverControllerList() {
        ArrayList<Controller> ret = new ArrayList<Controller>();

        return ret;
    }

    @Override
    public boolean isController() {
        return true;
    }

    @Override
    public boolean isDumbDevice() {
        return false;
    }

    @Override
    public boolean isSensor() {
        return false;
    }

}
