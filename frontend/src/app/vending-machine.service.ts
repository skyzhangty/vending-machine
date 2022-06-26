import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  VendingMachine,
  VendingMachineRequest,
} from './vending-machine.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VendingMachineService {
  baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getVendingMachine(): Observable<VendingMachine> {
    return this.http.get<VendingMachine>(`${this.baseUrl}/vending-machine`);
  }

  transaction(action: string): Observable<VendingMachine> {
    const requestBody: VendingMachineRequest = {
      vendingMachineAction: action,
    };
    return this.http.post<VendingMachine>(
      `${this.baseUrl}/vending-machine`,
      requestBody
    );
  }

  getHistory(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/history`);
  }
}
