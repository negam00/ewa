import { Component, OnInit, Input, ChangeDetectorRef} from '@angular/core';
import { Router } from '@angular/router'
import { RestApiService } from "../shared/rest-api.service";
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    @Input() user = {
        email: '',
        password: ''
    };

    private credentials: any;

    constructor(
        public restApi: RestApiService,
        public router: Router,
        private chRef: ChangeDetectorRef,
        private http: HttpClient
    ) {}

    ngOnInit() {
    }


    // check(){
    // 	return this.restApi.checkUsers().subscribe((data: {}) => {
    //         this.status = data;
    // 	});
    // }


loginUser(user) {


this.user.password = btoa(this.user.password);
    this.restApi.loginUser(this.user)
        .subscribe(  resp  => {
            
           // if (resp.status === 200) {
           	// @ts-ignore
            localStorage.setItem("bearer", resp.headers.get("Authorization"));
            // @ts-ignore
             localStorage.setItem("email", this.user.email);

                return this.restApi.getUsers().subscribe((data: {}) => {
                            this.credentials = data;
                            for (var i = 0; i < this.credentials.length; i++) {
                                if (this.credentials[i].email == this.user.email) {
                                    if (this.credentials[i].password == this.user.password) {
                                        localStorage.setItem('userId', this.credentials[i].userID);
                                        localStorage.setItem('email', this.credentials[i].email);
                                        // console.log(localStorage.getItem('userId'));
                                        this.router.navigate(['/eventoverview']);
                                    }
                                }
                            }

                });

           // }
    }, error => {
        console.log("error");
        document.getElementById('error').style.visibility = 'visible';
        }
)
  }

}