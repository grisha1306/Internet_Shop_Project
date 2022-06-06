export class Product {
  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }
  get orderId(): number {
    return this._orderId;
  }

  set orderId(value: number) {
    this._orderId = value;
  }
  get objectId(): number {
    return this._objectId;
  }

  set objectId(value: number) {
    this._objectId = value;
  }
  get objectName(): string {
    return this._objectName;
  }

  set objectName(value: string) {
    this._objectName = value;
  }
  get typeName(): string {
    return this._typeName;
  }

  set typeName(value: string) {
    this._typeName = value;
  }
  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  // @ts-ignore
  private _orderId : number;
  // @ts-ignore
  private _objectId : number;
  // @ts-ignore
  private _objectName : string;
  // @ts-ignore
  private _typeName : string;
  // @ts-ignore
  private _price : number;
  // @ts-ignore
  private _quantity : number;

}
