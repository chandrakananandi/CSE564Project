package smarthome.examples.entrance;

import channel.Channel;
import message.Command;
import port.InputPort;
import port.OutputPort;
import smarthome.core.DumbDevice;
import state.State;

/**
 * This class is for the main door. The main door can open and close automatically, depending on where the owner of the
 * house is. It extends the abstract class SmartDevice. There are two ports: an input port where it receives the command
 * to do something and an output port through which it sends it current state to some other device.
 *
 * @author cnandi
 *
 */
public class Garagedoor extends DumbDevice {

    public final String maindoorID = "MainDoor1";
    public Command openaction = new Command("open"); // final?
    public Command closeaction = new Command("close"); // final?

    public final InputPort receive_port = new InputPort();
    public final OutputPort send_port = new OutputPort();
    public State state;

    public GaragedoorController controller = new GaragedoorController();

    public Channel door_to_doorcontroller = new Channel("door_to_controller1", send_port, controller.inputport);

    // public List<Action> door_actions;

    public Garagedoor() {
        super();
    }

    @Override
    public String getID() {
        return maindoorID;
    }

    @Override
    public boolean isActuator() {
        return false;
    }

    @Override
    public boolean isSensor() {
        return false;
    }

    @Override
    public boolean isControlledDevice() {
        return true;
    }

    @Override
    public void executeAction(Command act) {
        if (act == null)
            System.out.println("No action.");
        else if (act == openaction && this.state.state.equals("closed")) {
            // invoke some lower level API of the door device to actually open it.
            System.out.println("door is opening");
            door_to_doorcontroller.message_in_channel = "opened";

        } else if (act == closeaction && this.state.state.equals("open")) {
            // invoke some lower level API of the door device to actually close it.
            System.out.println("door is closing");
            door_to_doorcontroller.message_in_channel = "closed";
        }
    }

}
