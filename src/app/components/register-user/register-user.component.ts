import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../../model/user';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {

  user:User=new User();
  submitted=false;

  constructor(private userservice:UserService) { }

  ngOnInit(): void {
    this.submitted=false;
  }

  registrationform=new FormGroup({
	firstName:new FormControl('',[Validators.required]),
    lastName:new FormControl('',[Validators.required]),
    username:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required]),
    confirm_password:new FormControl('',[Validators.required]),
    email:new FormControl('',[Validators.required, Validators.email]),
    role:new FormControl(),
  });

  register(register){
	this.user=new User();
    this.user.firstName=this.FirstName.value;
    this.user.lastName=this.LastName.value;
    this.user.username=this.Username.value;
    if(this.Password.value===this.ConfirmPassword.value)
      this.user.password=this.Password.value;
    this.user.email=this.Email.value;
    this.user.role=this.Role.value;
    if(this.user.role==="Admin"){
      this.user.enabled=true;
      this.user.status="Active";
    }
    else{
      this.user.enabled=false;
      this.user.status="Inactive";
    }
    this.user.isOnline=false;
    this.submitted=true;
    this.save();
  }

  save(){
    this.userservice.CreateUser(this.user)
    .subscribe(data=>console.log(data), error=>console.log(error));
    this.user=new User();
  }

  get FirstName(){
    return this.registrationform.get('firstName');
  }
  get LastName(){
    return this.registrationform.get('lastName');
  }
  get Username(){
    return this.registrationform.get('username');
  }
  get Password(){
    return this.registrationform.get('password');
  }
  get ConfirmPassword(){
    return this.registrationform.get('confirm_password');
  }
  get Email(){
    return this.registrationform.get('email');
  }
  get Role(){
    return this.registrationform.get('role');
  }

  registrationForm(){
    this.submitted=false;
    this.registrationform.reset();
  }
}