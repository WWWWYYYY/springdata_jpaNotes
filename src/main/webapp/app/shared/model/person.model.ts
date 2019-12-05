export interface IPerson {
  id?: number;
  name?: string;
  age?: number;
  sex?: number;
  addr?: string;
  high?: number;
  weight?: number;
}

export const defaultValue: Readonly<IPerson> = {};
