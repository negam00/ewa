import { Component, OnInit, Input } from '@angular/core';
import { RestApiService } from "../shared/rest-api.service";

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

  restaurant: any = [];
  @Input() restaurantDetails = { name: '', email: '', phone: '', description: '' }

  

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
