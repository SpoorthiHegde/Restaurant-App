import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../item';
import baseURL from './helper';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http:HttpClient) { }
  
  //---------------------Add item admin -------------------

  public addItem(item:any){
    return this.http.post(`${baseURL}/item/`,item)
  }
//--------------------Get all items------------------
  public getItems():Observable<Item[]>{
    return this.http.get<Item[]>(`${baseURL}/item/items`);
  }

//----------------- get item by item name-----------------

public getItemByItemName(itemName:string):Observable<Item> {
 return this.http.get<Item>(`${baseURL}/item/${itemName}`);
}

public getItemByItemId(itemId:number):Observable<Item>{
  return this.http.get<Item>(`${baseURL}/item/items/${itemId}`);
}

//----------------Update item by item name admin---------

public updateItem(itemName:string,item:Item):Observable<object> {
  return this.http.put(`${baseURL}/item/${itemName}`,item);
}

public updateItemById(itemId:number,item:Item):Observable<object> {
  return this.http.put(`${baseURL}/item/items/${itemId}`,item);
}

//------------------Delete item  admin----------------------

  public deleteItem(itemName:string):Observable<object>{
    return this.http.delete(`${baseURL}/item/${itemName}`)
  }

  public deleteItemById(itemId:number):Observable<object>{
    return this.http.delete(`${baseURL}/item/items/${itemId}`)
  }
}
