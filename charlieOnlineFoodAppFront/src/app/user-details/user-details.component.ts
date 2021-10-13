import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../user';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user:any;
  userName:string;

  constructor(private router:Router,private userService:UserService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    console.log(this.userName);
    this.userService.getUserByUserName(this.userName).subscribe(
      data=>{
        this.user=data;
        console.log(data)
      },
      error=>{
        console.log(error)
      }
    )
  }

  updateUser(userName:string){
    console.log(this.user)
    this.router.navigate(['update-user',userName]);
    console.log(this.user)
  }
  goToCartDetails(){
    this.router.navigate(['cart-details']);
  }
}
