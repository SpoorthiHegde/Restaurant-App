import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../services/user.service';
import Swal from 'sweetalert2'
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  userName:string;
  user:User;
  constructor(private userService: UserService,private snackBar: MatSnackBar,private router: Router,private route:ActivatedRoute) { }
  
  ngOnInit(): void {
        //----------------show users details when clicked on update-----------
        this.userName=this.route.snapshot.params['userName'];
        this.userService.getUserByUserName(this.userName).subscribe(data=>{
      this.user=data;
    },
    error=>console.log(error)
    )
  }

  formUpdateUser(){
      this.userService.updateUser(this.userName,this.user).subscribe(data=>{
        this.goToMenu();
      },
      error=>console.log(error)
      );
  }

  goToMenu(){
    this.router.navigate([`/user-details`,this.userName]);
  }
}
