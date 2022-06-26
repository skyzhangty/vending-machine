package vendingmachine.backend.services;

import org.springframework.stereotype.Service;
import vendingmachine.backend.domains.VendingMachine;
import vendingmachine.backend.domains.VendingMachineAction;
import vendingmachine.backend.domains.VendingMachineState;

import static vendingmachine.backend.domains.VendingMachineAction.*;
import static vendingmachine.backend.domains.VendingMachineState.*;

@Service
public class VendingMachineService {
  private int initialSodaCount = 5;
  private VendingMachine vendingMachine = new VendingMachine(initialSodaCount);

  private final TransactionHistoryService transactionHistoryService;

  public VendingMachineService(TransactionHistoryService transactionHistoryService) {
    this.transactionHistoryService = transactionHistoryService;
  }

  public VendingMachine transaction(VendingMachineAction action) {
    VendingMachineState state = vendingMachine.getVendingMachineState();
    int sodaCount = vendingMachine.getSodaCount();

    if (state == NO_QUARTER && action == INSERT_QUARTER) {
      vendingMachine = new VendingMachine(sodaCount, HAS_QUARTER);
    } else if (state == HAS_QUARTER) {
      if (action == PUSH_BUTTON) {
        vendingMachine = new VendingMachine(sodaCount - 1, SOLD);
        this.transactionHistoryService.addHistory();
      } else if (action == REMOVE_QUARTER) {
        vendingMachine = new VendingMachine(sodaCount, NO_QUARTER);
      }
    } else if (state == SOLD && action == DISPENSE_SODA) {
      if (sodaCount > 0) {
        vendingMachine = new VendingMachine(sodaCount, NO_QUARTER);
      } else {
        vendingMachine = new VendingMachine(sodaCount, SOLD_OUT);
      }
    }

    return vendingMachine;
  }

  public VendingMachine getVendingMachine() {
    return vendingMachine;
  }
}
