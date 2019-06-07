import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from "../shared/rest-api.service";

@Component({
  selector: 'app-restaurant-create',
  templateUrl: './restaurant-create.component.html',
  styleUrls: ['./restaurant-create.component.css']
})
export class RestaurantCreateComponent implements OnInit {

@Input() restaurantDetails = { name: '', email: '', phone: '0', description: '' }

  constructor(    
  	public restApi: RestApiService, 
    public router: Router
    ) { }

  ngOnInit() {        
    if (localStorage.getItem('bearer') === null) {
      this.router.navigate(['/']);
    } }

    addRestaurant(dataRestaurant) {
    this.restApi.createRestaurant(this.restaurantDetails).subscribe((data: {}) => {
      this.router.navigate(['/restaurants-list'])
    })
  }

}
