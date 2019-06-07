import { Component, OnInit } from '@angular/core';
import { RestApiService } from "../shared/rest-api.service";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-restaurant-update',
  templateUrl: './restaurant-update.component.html',
  styleUrls: ['./restaurant-update.component.css']
})

export class RestaurantUpdateComponent implements OnInit {
	id = this.actRoute.snapshot.params['id'];
  	restaurantData: any = {};

  constructor(
    public restApi: RestApiService,
    public actRoute: ActivatedRoute,
    public router: Router
  	) { }

  ngOnInit() {
            if (localStorage.getItem('bearer') === null) {
      this.router.navigate(['/']);
    }
  	    this.restApi.getRestaurant(this.id).subscribe((data: {}) => {
      this.restaurantData = data;
  })
}

  // Update restaurant data
  updateRestaurant() {
    if(window.confirm('Are you sure, you want to update?')){
      this.restApi.updateRestaurant(this.id, this.restaurantData).subscribe(data => {
        this.router.navigate(['/restaurant-list'])
      })
    }
  }

}