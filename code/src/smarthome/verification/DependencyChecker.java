package smarthome.verification;

import smarthome.core.Item;

public class DependencyChecker {
    public static boolean verify_dependency_policy(Item item) {
        boolean retval = false;

        if (item.isDumbDevice()) {
            retval = true;
        }

        if (item.isSensor()) {
            retval = true;
        }

        if (item.isController()) {
            /*
             * get the dependency file, parse it, check that the sensor values are always satisfied before the
             * controller sends a command
             */
        }
        return retval;
    }
}
