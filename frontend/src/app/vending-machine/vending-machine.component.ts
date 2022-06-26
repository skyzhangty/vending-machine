import { Component, OnInit } from '@angular/core';
import { VendingMachineService } from '../vending-machine.service';
import { Observable, switchMap } from 'rxjs';
import {
  DISPENSE_SODA,
  HAS_QUARTER,
  INSERT_QUARTER,
  NO_QUARTER,
  PUSH_BUTTON,
  REMOVE_QUARTER,
  VendingMachine,
} from '../vending-machine.models';

@Component({
  selector: 'app-vending-machine',
  templateUrl: './vending-machine.component.html',
  styleUrls: ['./vending-machine.component.css'],
})
export class VendingMachineComponent implements OnInit {
  vendingMachine$: Observable<VendingMachine> | null = null;

  constructor(private vendingMachineService: VendingMachineService) {}

  ngOnInit(): void {
    this.vendingMachine$ = this.vendingMachineService.getVendingMachine();
  }

  insertQuarter() {
    this.vendingMachine$ =
      this.vendingMachineService.transaction(INSERT_QUARTER);
  }

  removeQuarter() {
    this.vendingMachine$ =
      this.vendingMachineService.transaction(REMOVE_QUARTER);
  }

  pushForSoda() {
    this.vendingMachine$ = this.vendingMachineService
      .transaction(PUSH_BUTTON)
      .pipe(
        switchMap(() => this.vendingMachineService.transaction(DISPENSE_SODA))
      );
  }

  disableInsertQuarter(vendingMachine: VendingMachine) {
    return vendingMachine.vendingMachineState !== NO_QUARTER;
  }

  disableRemoveQuarter(vendingMachine: VendingMachine) {
    return vendingMachine.vendingMachineState !== HAS_QUARTER;
  }

  disablePushForSoda(vendingMachine: VendingMachine) {
    return vendingMachine.vendingMachineState !== HAS_QUARTER;
  }
}
