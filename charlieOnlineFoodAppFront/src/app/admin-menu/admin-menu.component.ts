import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../item';
import { ItemService } from '../services/item.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {
  items: Item[];

  constructor(private itemService: ItemService,  private router: Router, private snackBar: MatSnackBar, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getItems();
  }
  private getItems() {
    this.itemService.getItems().subscribe(
      data => {
        this.items = data;
      });
  }

  updateItem(itemName: string) {
    this.router.navigate(['update-item', itemName]);
  }

  deleteItem(itemName: string) {
    this.itemService.deleteItem(itemName).subscribe(data => {
      this.getItems();
    },
    )
  }

  goToAddItem() {
    this.router.navigate([`/add-item`]);
  }

}
