import { Component, OnInit } from '@angular/core'
import { FormControl, FormGroup,Validators } from '@angular/forms';
import {UserService} from '../../services/user.service';
import {User} from '../../model/user';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.scss']
})
export class LoginUserComponent implements OnInit {
 
  user:User=new User();
  submitted=false;

  constructor(private userservice:UserService) { }


  ngOnInit(): void {
    this.submitted=false;

  }
  loginform=new FormControl({
    Username:new FormControl('',[Validators.required]),
    Password:new FormControl('',[Validators.required]),
  });

  login(login){
    this.user=new User();
    this.user.username=this.Username.value;
      this.user.password=this.Password.value;
    }
    save(){
      this.userservice.CreateUser(this.user)
      .subscribe(data=>console.log(data), error=>console.log(error));
      this.user=new User();
    }
    get Username(){
      return this.loginform.get('Username');
    }
    get Password(){
      return this.loginform.get('Password');
    }

      loginForm(){
        this.submitted=false;
        this.loginform.reset();
      }  
  }  
