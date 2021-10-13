import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Item } from '../item';
import { ItemService } from '../services/item.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  items: Item[];

  constructor(private itemService: ItemService,private router:Router,private snackBar: MatSnackBar) { }
  ngOnInit(): void {
    this.getItems();
  }

  private getItems() {
    this.itemService.getItems().subscribe(
      data => {
        this.items=data;
    });
  }

  message(){
    this.snackBar.open('Item added to cart', 'ok', {
      duration: 3000
    });
  }
}
