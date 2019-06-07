import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Components
import { EventOverviewComponent } from './event-overview/event-overview.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SettingsComponent } from './settings/settings.component';
import { CreateeventComponent } from './createevent/createevent.component';
import { RestaurantsComponent } from './restaurants/restaurants.component';

// restaurant components
import { RestaurantCreateComponent } from './restaurant-create/restaurant-create.component';
import { RestaurantUpdateComponent } from './restaurant-update/restaurant-update.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';

const routes: Routes = [
      {path: "", component: LoginComponent},
      {path: "eventoverview", component: EventOverviewComponent},
      {path: "eventoverview/:id", component: EventOverviewComponent},
      {path: "register", component: RegisterComponent},
      {path: "settings", component: SettingsComponent},
      {path: "createevent", component: CreateeventComponent},
      {path: "restaurants", component: RestaurantsComponent},
      {path: "restaurants/:id", component: RestaurantDetailsComponent},

      {path: "create-restaurant", component: RestaurantCreateComponent},
      {path: "restaurant-details/:id", component: RestaurantDetailsComponent},
      {path: "update-restaurant/:id", component: RestaurantUpdateComponent},
      {path: "restaurants-list", component: RestaurantListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
