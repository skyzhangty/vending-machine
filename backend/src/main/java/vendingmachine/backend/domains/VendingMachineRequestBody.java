package vendingmachine.backend.domains;

import java.io.Serializable;

public class VendingMachineRequestBody implements Serializable {
  private VendingMachineAction vendingMachineAction;

  public VendingMachineAction getVendingMachineAction() {
    return vendingMachineAction;
  }

  public void setVendingMachineAction(VendingMachineAction vendingMachineAction) {
    this.vendingMachineAction = vendingMachineAction;
  }
}
