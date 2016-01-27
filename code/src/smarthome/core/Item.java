package smarthome.core;

public interface Item {

    public boolean isDumbDevice();

    public boolean isController();

    public boolean isSensor();

    public String getID();

}
