package item;

import message.Command;
import shared.Type;

public abstract class DumbDevice implements Item {

    /**
     * returns the unique ID of the device
     *
     * @return
     */
    public abstract String getID();

    /**
     * This method is called to execute a command.
     */
    public abstract void executeCommand(Command c);

    /**
     * returns the controller which issues the command c for this dumb device
     *
     * @return
     */
    public abstract Controller getController(Command c);

    /**
     * returns the type of a dumb device. This information is required by the controllers to determine if they can
     * control the dumb device.
     */
    public abstract Type getType();

    @Override
    public boolean isController() {
        return false;
    }

    @Override
    public boolean isDumbDevice() {
        return true;
    }

    @Override
    public boolean isSensor() {
        return false;
    }

}
