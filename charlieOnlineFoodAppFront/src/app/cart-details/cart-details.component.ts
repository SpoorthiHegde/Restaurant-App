import { Component, OnInit } from '@angular/core';
import { CartDetails } from '../cart-details';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  cart:CartDetails[];
  constructor() { }

  ngOnInit(): void {
    this.cart=[
      {
        "cartEntryId":1,
        "itemName":"Manchurian",
        "menuId":1,
        "price":120,
        "quantity":1,
        "userId":2
      },
      {
        "cartEntryId":2,
        "itemName":"Pizza",
        "menuId":3,
        "price":300,
        "quantity":1,
        "userId":2
      }
    ];
  }
}
