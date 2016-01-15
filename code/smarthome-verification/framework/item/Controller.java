package item;

import java.util.ArrayList;
import java.util.HashMap;

import message.Command;
import pair.Pair;

public abstract class Controller implements Item {

    /**
     * a data structure to store the ID of the controller and a list of pairs of controlled
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
     */
    public abstract ArrayList<Sensor> getSensors();

    /**
     * sends command to a dumb device
     */
    public abstract void sendCommandToDumbDevice(Command c, DumbDevice d);

    /**
     * get ID of the controller
     *
     * @return
     */
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
