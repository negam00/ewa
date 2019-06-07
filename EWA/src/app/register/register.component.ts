import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router'
import { RestApiService } from "../shared/rest-api.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

@Input() user = {firstname: '', surname:'', email:'', password:''};
public password_confirm: any;  

  constructor(
  public restApi: RestApiService,
    public router: Router
    ) { }

  ngOnInit() {

  }

  register(user) {
    if (this.user['firstname'] != "" && this.user['surname'] != "" && this.user['email'] != "" && this.user['password'] != "") {
      if (this.user['password'] == this.password_confirm) {
        this.user['password'] = btoa(this.user['password']);
        this.restApi.createUser(this.user).subscribe((data: {}) => {
          this.router.navigate(['/']);
        })
      }else{
        document.getElementById('error').style.visibility = 'visible';
      }
    }
  }

}
