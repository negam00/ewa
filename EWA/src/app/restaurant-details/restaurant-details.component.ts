import { Component, OnInit } from '@angular/core';
import { RestApiService } from "../shared/rest-api.service";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
	 id = this.actRoute.snapshot.params['id'];

	restaurant: any = [];
	data: any = {};

  constructor(
	public restApi: RestApiService,
	public actRoute: ActivatedRoute,
    public router: Router
  	) { }

  	ngOnInit() {
  		this.loadRestaurants();
	}

    // Get restaurants list
	loadRestaurants() {
		return this.restApi.getRestaurant(this.id).subscribe((data: {}) => {
		  	this.restaurant = data;
		  	console.log(data);
		});
	}

}
