package smarthome.test.unit;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import smarthome.core.Command;
import smarthome.core.Controller;
import smarthome.core.DumbDevice;

public class ControllerTest {

    @Test
    public void testGetSensors() throws ParserConfigurationException, SAXException, IOException {
        Controller cont = new Controller() {
            @Override
            public String getID() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public ArrayList<Command> getCommands() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void detectCommandsDumbDevice(DumbDevice d) {
                // TODO Auto-generated method stub

            }

            @Override
            public void sendCommandToDumbDevice(Command c, DumbDevice d) {
                // TODO Auto-generated method stub

            }

        };
        Set<String> test = cont.getSensors("Test");
        assertEquals(8, test.size());

    }

}
