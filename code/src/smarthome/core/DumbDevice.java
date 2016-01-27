package smarthome.core;

public abstract class DumbDevice implements Item {

    /**
     * returns the unique ID of the device
     *
     * @return
     */
    @Override
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
     * control the dumb device. This could for example be a roomheater, an airconditioner, a laundrymachine etc.
     */
    public abstract String getType();

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
