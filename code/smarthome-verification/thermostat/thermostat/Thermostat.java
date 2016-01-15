package thermostat;

import java.util.ArrayList;

import item.Controller;
import item.DumbDevice;
import item.Sensor;
import message.Command;

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

    @Override
    public ArrayList<DumbDevice> getDumbDevices() {
        return dumbdevice_list;
    }

    @Override
    public ArrayList<Sensor> getSensors() {
        return sensor_list;
    }

    @Override
    public void sendCommandToDumbDevice(Command c, DumbDevice d) {
        // TODO do something here to send the command to the dumb device

    }

    @Override
    public void broadcast() {
        // TODO: get owner's location over WiFi and broadcast it inside the house using some other protocol which rest
        // of the controllers support
    }

    @Override
    public String getID() {
        return thermostatID;
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
    public void addInformationToDatabase() {
        // TODO Auto-generated method stub

    }

}
