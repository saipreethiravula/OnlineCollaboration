import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {DataTablesModule} from 'angular-datatables';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { ActivateUserComponent } from './components/activate-user/activate-user.component';
import { AddBlogComponent } from './components/add-blog/add-blog.component';
import { ApproveBlogComponent } from './components/approve-blog/approve-blog.component';
import { ViewBlogComponent } from './components/view-blog/view-blog.component';
import {UserService} from './services/user.service';
import {BlogService} from './services/blog.service';

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponent,
    UserListComponent,
    LoginUserComponent,
    ActivateUserComponent,
    AddBlogComponent,
    ApproveBlogComponent,
    ViewBlogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    DataTablesModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [UserService, BlogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
