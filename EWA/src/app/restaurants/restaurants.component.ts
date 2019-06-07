import { Component, OnInit } from '@angular/core';
import { RestApiService } from "../shared/rest-api.service";

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

	restaurant: any = [];

  constructor(
	public restApi: RestApiService
  	) { }

  ngOnInit() {
  	this.loadRestaurants()
  }

    // Get restaurants list
  loadRestaurants() {
    return this.restApi.getRestaurants().subscribe((data: {}) => {
      this.restaurant = data;
    })
  }

  // Delete restaurant
  deleteRestaurant(id) {
    if (window.confirm('Are you sure, you want to delete?')){
      this.restApi.deleteRestaurant(id).subscribe(data => {
        this.loadRestaurants()
      })
    }
  } 

}