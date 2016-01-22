package smarthome.pair;

import item.DumbDevice;
import message.Command;

/**
 * represents a pair of elements, in this case a dumb device and the command issued to it by the controller
 * 
 * @author cnandi
 *
 */
public class Pair {
    public DumbDevice dd;
    public Command command;

    public Pair(DumbDevice d, Command c) {
        dd = d;
        command = c;
    }

    public DumbDevice getDumbDevice() {
        return dd;
    }

    public Command getCommand() {
        return command;
    }

}
