package vendingmachine.backend.domains;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum VendingMachineAction {
  INSERT_QUARTER,
  REMOVE_QUARTER,
  PUSH_BUTTON,
  DISPENSE_SODA,
}
