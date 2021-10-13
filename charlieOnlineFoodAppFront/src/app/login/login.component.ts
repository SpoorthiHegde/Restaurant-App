import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router, RouterModule } from '@angular/router';
import { UserService } from '../services/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private userService: UserService, private snackBar: MatSnackBar) { }

  public user = {
    userName: "",
    password: ""
  }

  ngOnInit(): void {
  }

  loginSubmit() {
    console.log(this.user);
    if (this.user.userName == '' || this.user.userName == null) {
      this.snackBar.open('User is Required !!', 'ok', {
        duration: 3000
      });
      return;
    }
    // -------------------------------login for admin configured-----------------------------------------
    if (this.user.userName == 'spoo17' && this.user.password == 'spoo17') {
      this.userService.loginUser(this.user).subscribe(
        (data:any) => {
          console.log(data)
          Swal.fire('Admin logged in  Successfully!!','UserName: '+data.userName,'success')
          this.adminPage();
        },
        (error) => {
          console.log(error);
          this.snackBar.open('Invalid credentials!!', 'ok', {
            duration: 3000
          })
        }
      );
      return
    }
//---------------------------login for user-----------------------------------------------------------
    this.userService.loginUser(this.user).subscribe(
      (data:any) => {
        //Success
        console.log(data)
        Swal.fire('User logged in  Successfully!!','UserName: '+data.userName,'success')
        this.userPage(this.user.userName);
      },
      (error) => {
        //error
        console.log(error);
        this.snackBar.open('Invalid credentials', 'ok', {
          duration: 3000
        })
      }
    );
  }

  userPage(userName: string) {
    this.router.navigate(['user-details', userName]);
  }

  adminPage() {
    this.router.navigate(['admin-menu']);
  }
}
