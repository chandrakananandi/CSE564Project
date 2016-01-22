package smarthome.verification;

import policychecker.ControlChecker;
import policychecker.DependencyChecker;
import smarthome.item.Item;

public class NewItemChecker {

    public static boolean verify_new_item_policy(Item item) {
        boolean retval = false;

        /*
         * if the new item is a dumb device, there is no new verification to be
         * done for it because dumb devices are assumed to be trusted, hence the verifier will return true
         */

        if (item.isDumbDevice()) {
            retval = true;
        }

        /*
         * if the new item is a sensor, there is no new verification to be
         * done for it because sensors are assumed to be trusted, hence the verifier will return true
         */
        if (item.isSensor()) {
            retval = true;
        }

        /*
         * if the new item is a controller, then the verifier will return the and of the results of the
         * dependency policy checker and the control policy checker
         */
        if (item.isController()) {
            retval = ControlChecker.verify_control_policy(item) & DependencyChecker.verify_dependency_policy(item);
        }
        return retval;
    }

}
