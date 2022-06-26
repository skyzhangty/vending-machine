export interface VendingMachine {
  sodaCount: number;
  vendingMachineState: string;
}

export interface VendingMachineRequest {
  vendingMachineAction: string;
}

export const INSERT_QUARTER = 'INSERT_QUARTER';
export const REMOVE_QUARTER = 'REMOVE_QUARTER';
export const PUSH_BUTTON = 'PUSH_BUTTON';
export const DISPENSE_SODA = 'DISPENSE_SODA';

export const SOLD_OUT = 'SOLD_OUT';
export const NO_QUARTER = 'NO_QUARTER';
export const HAS_QUARTER = 'HAS_QUARTER';
export const SOLD = 'SOLD';
