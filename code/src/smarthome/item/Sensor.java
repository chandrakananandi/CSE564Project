package smarthome.item;

import item.Item;

public abstract class Sensor implements Item {

    /**
     * returns the ID of a sensor
     *
     * @return
     */
    public abstract String getID();

    /**
     * returns the name of the entity the sensor tracks. It could be the state of a device
     *
     * @return
     */
    public abstract String getSensedEntity();

    /**
     * broadcasts any change in the value of an entity being tracked
     */
    public abstract void broadcast();

    @Override
    public boolean isController() {
        return false;
    }

    @Override
    public boolean isDumbDevice() {
        return false;
    }

    @Override
    public boolean isSensor() {
        return true;
    }
}
