package vendingmachine.backend.domains;

public class VendingMachine {
  private int sodaCount;
  private VendingMachineState vendingMachineState;

  public VendingMachine() {
    this(0, VendingMachineState.SOLD_OUT);
  }

  public VendingMachine(int sodaCount) {
    this(sodaCount, VendingMachineState.NO_QUARTER);
  }

  public VendingMachine(int sodaCount, VendingMachineState vendingMachineState) {
    this.sodaCount = sodaCount;
    this.vendingMachineState = vendingMachineState;
  }

  public int getSodaCount() {
    return sodaCount;
  }

  public void setSodaCount(int sodaCount) {
    this.sodaCount = sodaCount;
  }

  public VendingMachineState getVendingMachineState() {
    return vendingMachineState;
  }

  public void setVendingMachineState(VendingMachineState vendingMachineState) {
    this.vendingMachineState = vendingMachineState;
  }
}
