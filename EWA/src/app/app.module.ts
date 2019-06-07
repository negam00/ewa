import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

// Routing module for router service
import { AppRoutingModule } from './app-routing.module';
// import { RouterModule, Routes } from '@angular/router';

// HTTPClient module for RESTful API
import { HttpClientModule } from '@angular/common/http';

// Forms module
import { FormsModule } from '@angular/forms';

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

@NgModule({
  declarations: [
    AppComponent,
    EventOverviewComponent,
    LoginComponent,
    RegisterComponent,
    SettingsComponent,
    CreateeventComponent,
    RestaurantsComponent,
    RestaurantCreateComponent,
    RestaurantUpdateComponent,
    RestaurantListComponent,
    RestaurantDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
