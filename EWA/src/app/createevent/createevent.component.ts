import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from "../shared/rest-api.service";

@Component({
  selector: 'app-createevent',
  templateUrl: './createevent.component.html',
  styleUrls: ['./createevent.component.css']
})
export class CreateeventComponent implements OnInit {
	@Input() eventDetails = { name: '', descr: '', date: '', restaurantId: 0 , managerID: localStorage.getItem('userId')}; 

	data: any = [];
  event: any = [];


	restaurants: any = [];


  constructor(
  	public restApi: RestApiService, 
    public router: Router
  	) {	
}

  ngOnInit() { 
            if (localStorage.getItem('bearer') === null) {
      this.router.navigate(['/']);
    }
	this.loadRestaurants();
	// this.loadUsers();
  }

    // Get restaurants list
	loadRestaurants() {
		return this.restApi.getRestaurants().subscribe((data: {}) => {
		  	this.restaurants = data;
		});
	}



    addEvent(eventData) {
    this.restApi.createEvent(this.eventDetails).subscribe((data: {}) => {
        this.restApi.getHighestEvent().subscribe((data2:{}) => {

         this.event = {userId: localStorage.getItem('userId'), eventId: data2, userOrder: ''}; 

            this.restApi.createAttendees(this.event).subscribe((data3: {}) => {
              // console.log(data2);
                 this.router.navigate(['/eventoverview/'+data2])

             });

      });
      // console.log(this.eventDetails);
    })
  }
}
