import { Component, OnInit } from '@angular/core';
import { VendingMachineService } from '../vending-machine.service';
import { Observable } from 'rxjs';
import { VendingMachine } from '../vending-machine.models';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})
export class HistoryComponent implements OnInit {
  history$: Observable<string[]> | null = null;

  constructor(private vendingMachineService: VendingMachineService) {}

  ngOnInit(): void {
    this.history$ = this.vendingMachineService.getHistory();
  }
}
