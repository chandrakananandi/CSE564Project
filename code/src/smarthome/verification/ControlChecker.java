package smarthome.verification;

import smarthome.core.Item;

public class ControlChecker {

    public static boolean verify_control_policy(Item item) {
        boolean retval = false;

        if (item.isSensor()) {
            retval = true;
        }

        if (item.isDumbDevice()) {
            retval = true;
        }

        if (item.isController()) {

        }
        return retval;
    }
}
