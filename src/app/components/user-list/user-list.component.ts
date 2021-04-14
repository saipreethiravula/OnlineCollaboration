import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../model/user';
import {Observable, Subject} from 'rxjs';
import {Validators, FormControl, FormGroup, FormBuilder} from '@angular/forms';
import {DataTablesModule} from 'angular-datatables'

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  usersArray:any=[];
  dtOptions: DataTables.Settings={};
  dtTrigger: Subject<any>=new Subject();
  users: Observable<User[]>;
  user: User=new User();
  deleteMessage=false;
  userlist:any;
  isupdated=false;

  constructor(private userservice: UserService) { }

  ngOnInit(): void {
    this.isupdated=false;
    this.dtOptions={
      pageLength:6,
      stateSave:true,
      lengthMenu:[[6,16,20,-1],[6,16,20,"All"]],
      processing:true
    };
    this.userservice.getUserList().subscribe(data=>{
      this.users=data;
      this.dtTrigger.next();
    })
  }

  deleteUser(id:number){
    this.userservice.deleteUser(id)
    .subscribe(data=>{
      console.log(data);
      this.deleteMessage=true;
      this.userservice.getUserList().subscribe(data=>{
        this.users=data;
      })
    }, error=>console.log(error));
  }

  updateUser(id:number){
    this.userservice.getUser(id)
    .subscribe(data=>{
      this.userlist=data;
    }, error=>console.log(error));
  }

  userupdateform=new FormGroup({
    userId:new FormControl(),
    firstName:new FormControl(),
    lastName:new FormControl(),
    userName:new FormControl(),
    password:new FormControl(),
    email:new FormControl(),
    role:new FormControl(),
    status:new FormControl(),
    isOnline:new FormControl(),
    enabled:new FormControl()
  });

  update(user){
    this.user=new User();
    this.user.userId=this.UserId.value,
    this.user.firstName=this.FirstName.value;
    this.user.lastName=this.LastName.value;
    this.user.username=this.Username.value;
    this.user.password=this.Password.value;
    this.user.email=this.Email.value;
    this.user.role=this.Role.value;
    this.user.enabled=true;
    this.user.status="Active";
    
    this.userservice.updateUser(this.user.userId,this.user).subscribe(data=>{
      this.isupdated=true;
      this.userservice.getUserList().subscribe(data=>{
        this.users=data;
      })
    },error=>console.log(error));
  }

  get UserId(){
    return this.userupdateform.get('userId');
  }
  get FirstName(){
    return this.userupdateform.get('firstName');
  }
  get LastName(){
    return this.userupdateform.get('lastName');
  }
  get Username(){
    return this.userupdateform.get('username');
  }
  get Password(){
    return this.userupdateform.get('password');
  }
 
  get Email(){
    return this.userupdateform.get('email');
  }
  get Role(){
    return this.userupdateform.get('role');
  }
  get Status(){
    return this.userupdateform.get('status');
  }
  get IsOnline(){
    return this.userupdateform.get('isOnline');
  }
  get Enabled(){
    return this.userupdateform.get('enabled');
  }

  changeisUpdate(){
    this.isupdated=false;
  }

}