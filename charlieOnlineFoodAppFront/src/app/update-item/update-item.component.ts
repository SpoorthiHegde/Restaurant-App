import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ItemService } from '../../app/services/item.service'
import { Item } from '../item'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {
  itemName:string;
  item:Item=new Item();

  constructor(private itemService: ItemService, private snackBar: MatSnackBar, private router: Router,private route:ActivatedRoute) { }
 

  ngOnInit(): void {
    //----------------show item details when clicked on update-----------
    this.itemName=this.route.snapshot.params['itemName'];
    this.itemService.getItemByItemName(this.itemName).subscribe(data=>{
      this.item=data;
    },
    error=>console.log(error)
    )
  }

  formUpdateItem(){
    this.itemService.updateItem(this.itemName,this.item).subscribe(data=>{
      this.goToAdminMenu();
    },
    error=>console.log(error)
    );
  }

  goToAdminMenu() {
    this.router.navigate([`/admin-menu`]);
  }
}
