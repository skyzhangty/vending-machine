package vendingmachine.backend.controllers;

import org.springframework.web.bind.annotation.*;
import vendingmachine.backend.domains.VendingMachine;
import vendingmachine.backend.domains.VendingMachineRequestBody;
import vendingmachine.backend.services.TransactionHistoryService;
import vendingmachine.backend.services.VendingMachineService;

import java.util.List;

@RestController
@CrossOrigin
public class VendingMachineController {
  private final VendingMachineService vendingMachineService;
  private final TransactionHistoryService transactionHistoryService;

  public VendingMachineController(
      VendingMachineService vendingMachineService,
      TransactionHistoryService transactionHistoryService) {
    this.vendingMachineService = vendingMachineService;
    this.transactionHistoryService = transactionHistoryService;
  }

  @GetMapping("/vending-machine")
  public VendingMachine vendingMachine() {
    return this.vendingMachineService.getVendingMachine();
  }

  @PostMapping("/vending-machine")
  public VendingMachine transaction(
      @RequestBody VendingMachineRequestBody vendingMachineRequestBody) {
    return this.vendingMachineService.transaction(
        vendingMachineRequestBody.getVendingMachineAction());
  }

  @GetMapping("/history")
  public List<String> history() {
    return this.transactionHistoryService.getHistory();
  }
}
