import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ItemService } from '../../app/services/item.service'
import { Item } from '../item'
import Swal from 'sweetalert2'
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  constructor(private itemService: ItemService, private userService: UserService, private snackBar: MatSnackBar, private router: Router, private route: ActivatedRoute) { }

  public item = {
    itemName: "",
    itemDesc: "",
    price: "",
    image: ""
  }
 

  ngOnInit(): void {

  }
  formSubmitItem() {
    console.log(this.item);
    if (this.item.itemName == '' || this.item.itemName == null) {
      this.snackBar.open('Item Name is Required !!', 'ok', {
        duration: 3000
      });
      return;
    }
    // ------------Add item from item service-------------------
    this.itemService.addItem(this.item).subscribe(
      (data) => {
        //Success
        console.log(data)
        Swal.fire('Item added Successfully!!', '', 'success')
        this.goToAdminMenu();
      },
      (error) => {
        //error
        console.log(error);
        this.snackBar.open('Something went wrong', 'ok', {
          duration: 3000
        })
      }
    );
  }

  goToAdminMenu() {
    this.router.navigate([`admin-menu`]);
  }
}
