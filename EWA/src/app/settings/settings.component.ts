import { Component, OnInit } from '@angular/core';
import { RestApiService } from "../shared/rest-api.service";
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})

export class SettingsComponent implements OnInit {

	id = localStorage.getItem('userId');
	user: any = [];

	constructor(
		public restApi: RestApiService,
		public actRoute: ActivatedRoute,
   		public router: Router
	){}

	ngOnInit() {
		this.loadUser(this.id);
		        if (localStorage.getItem('bearer') === null) {
      this.router.navigate(['/']);
    }
	}

	loadUser(userId){
		return this.restApi.getUsers().subscribe((data: []) => {
	        for (var i = data.length - 1; i >= 0; i--) {
	        	if (data[i]['userID'] == userId){
	        		console.log(data[i]);
	        		this.user = data[i];
	        	}else{
	        		// no users found
	        	}
        	}
	    });
	}

	updateUser(){
		this.restApi.updateUser(this.id, this.user).subscribe(data => {
	        console.log("updated");
      	})
	}

	logout(){
		localStorage.clear();
		this.router.navigate(['/']);
	}

}
