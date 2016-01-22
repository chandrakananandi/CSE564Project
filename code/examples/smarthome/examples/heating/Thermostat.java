package smarthome.examples.heating;

import java.util.ArrayList;

import message.Command;
import smarthome.item.Controller;
import smarthome.item.DumbDevice;
import smarthome.item.Sensor;

public class Thermostat implements Controller {

    public final String thermostatID = "thermostat1";

    public final Command command1 = new Command("start_roomheater");
    public final Command command2 = new Command("stop_roomheater");
    public final Command command3 = new Command("start_airconditioner");
    public final Command command4 = new Command("stop_airconditioner");

    public ArrayList<Sensor> sensor_list = new ArrayList<Sensor>();
    public ArrayList<DumbDevice> dumbdevice_list = new ArrayList<DumbDevice>();

    public Thermostat() {

    }

    public ArrayList<DumbDevice> getDumbDevices() {
        return dumbdevice_list;
    }

    public ArrayList<Sensor> getSensors() {
        return sensor_list;
    }

    public void sendCommandToDumbDevice(Command c, DumbDevice d) {
        // TODO do something here to send the command to the dumb device

    }

    public void broadcast() {
        // TODO: get owner's location over WiFi and broadcast it inside the house using some other protocol which rest
        // of the controllers support
    }

    public String getID() {
        return thermostatID;
    }

    public ArrayList<Command> getCommands() {
        // TODO Auto-generated method stub
        return null;
    }

    public void detectCommandsDumbDevice(DumbDevice d) {
        // TODO Auto-generated method stub

    }

    public void addInformationToDatabase() {
        // TODO Auto-generated method stub

    }

}
