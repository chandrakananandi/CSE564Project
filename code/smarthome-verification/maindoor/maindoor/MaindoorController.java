package maindoor;

import channel.Channel;
import item.Controller;
import message.Command;
import port.InputPort;
import port.OutputPort;

public class MaindoorController extends Controller {

    public static final String maindoor_controllerID = "maindoor_controller1";
    public InputPort inputport = new InputPort();
    public OutputPort outputPort = new OutputPort();
    public Maindoor maindoor = new Maindoor();

    // list of sensors and variables on which the command depends.

    public Channel doorcontroller_to_door = new Channel("controller_to_door1", outputPort, maindoor.receive_port);

    public MaindoorController() {
        super();
    }

    @Override
    public String getID() {
        return maindoor_controllerID;
    }

    @Override
    public boolean isActuator() {
        return true;
    }

    /**
     * this method sends a command to the front door to open or close. The command it sends depends on a bunch of
     * variable and
     * sensor values listed in the policy document.
     */
    @Override
    public void executeAction(Command action) {

        // if (all conditions for door to open are true)
        // doorcontroller_to_door.add_message_tochannel("open");
        // if (all conditions for door to close are true)
        // doorcontroller_to_door.add_message_tochannel("close");
    }

}
