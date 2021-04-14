import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { ActivateUserComponent } from './components/activate-user/activate-user.component';
import { AddBlogComponent } from './components/add-blog/add-blog.component';
import { ApproveBlogComponent } from './components/approve-blog/approve-blog.component';
import { ViewBlogComponent } from './components/view-blog/view-blog.component';

const routes: Routes = [
  {path:'',redirectTo:'login-user', pathMatch:'full'},
  {path:'register-user', component:RegisterUserComponent},
  {path:'login-user', component:LoginUserComponent},
  {path:'user-list', component:UserListComponent},
  {path:'activate-user', component:ActivateUserComponent},
  {path:'add-blog', component:AddBlogComponent},
  {path:'approve-blog', component:ApproveBlogComponent},
  {path:'view-blog', component:ViewBlogComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }