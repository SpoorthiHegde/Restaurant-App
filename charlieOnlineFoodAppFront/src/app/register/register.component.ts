import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../services/user.service';
import Swal from 'sweetalert2'
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // Injecting userService    and  matsnakbar 
  constructor(private userService: UserService, private snackBar: MatSnackBar, private router: Router) { }
  // ------------------User fields which will be used to bind users data---------
  public user = {
    userName: "",
    password: "",
    firstName: "",
    lastName: "",
    phone: "",
  }

  ngOnInit(): void {
  }

  // ---------------------- Button call after user clicks register------------
  formSubmit() {
    console.log(this.user);
    if (this.user.userName == '' || this.user.userName == null) {
      this.snackBar.open('User is Required !!', 'ok', {
        duration: 3000
      });
      return;
    }
    // ------------Add User -from user service-------------------
    this.userService.addUser(this.user).subscribe(
      (data) => {
        //Success
        console.log(data)
        Swal.fire('user Registered Successfully!!', '', 'success')
        this.goTologinPage();
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

  goTologinPage() {
    this.router.navigate(['login']);
  }
}
