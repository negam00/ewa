import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Restaurants } from '../shared/restaurants';
import { Events } from '../shared/events';
import { Users } from '../shared/users';
import { AttendeeKoppel } from '../shared/AttendeeKoppel';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

// Define API
  apiURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // Http Options
   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    observe: 'response' as 'body'
    
  };


  // HttpClient API get() method => Fetch restaurant list
  getRestaurants(): Observable<Restaurants> {
    return this.http.get<Restaurants>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/restaurants')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API get() method => Fetch restaurant
  getRestaurant(id): Observable<Restaurants> {
    return this.http.get<Restaurants>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/restaurants/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  } 

  // EVENT CALLS

  // HttpClient API get() method => Fetch event list
  getEvents(id): Observable<Events> {
    return this.http.get<Events>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/events/user/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API get() method => Fetch event
  getEvent(id): Observable<Events> {
    return this.http.get<Events>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/events/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

// get latest added event id
    getHighestEvent(): Observable<Events> {
    return this.http.get<Events>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/events/latest')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

    // HttpClient API get() method => Fetch event
  getAttendees(id): Observable<any> {
    return this.http.get(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/attendeekoppels/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API get() method => Fetch event
  changeAttendeeOrder(uid, eid, koppelOrder): Observable<AttendeeKoppel> {
    return this.http.put<AttendeeKoppel>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/attendeekoppels/' + uid + '/' + eid, JSON.stringify(koppelOrder), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }


    // HttpClient API post() method => Create restaurant
  createAttendees(attendees): Observable<AttendeeKoppel> {
    return this.http.post<AttendeeKoppel>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/attendeekoppels', JSON.stringify(attendees), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }



// END EVENT CALLS
// User calls
    // HttpClient API get() method => Fetch event list
  getUsers(): Observable<Users> {
    return this.http.get<Users>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/users')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

    // HttpClient API get() method => Fetch event
  getUser(id): Observable<Users> {
    return this.http.get<Users>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/users/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

      // HttpClient API get() method => Fetch event
  getOrder(eid): Observable<AttendeeKoppel> {
    return this.http.get<AttendeeKoppel>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/attendeekoppels/order/' + eid)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }
// End user calls

  // HttpClient API post() method => Create restaurant
  createRestaurant(restaurant): Observable<Restaurants> {
    return this.http.post<Restaurants>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/restaurants', JSON.stringify(restaurant), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  } 

  // HttpClient API post() method => Create event
  createEvent(event): Observable<Events> {
    return this.http.post<Events>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/events', JSON.stringify(event), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  } 

    // HttpClient API post() method => Create event
  createUser(user): Observable<Users> {
    return this.http.post<Users>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/users/register', JSON.stringify(user), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API post() method => Create event
  loginUser(user): Observable<Users> {
    return this.http.post<Users>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/users', JSON.stringify(user), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }


  // HttpClient API put() method => Update user
  updateUser(id, user): Observable<Users> {
    return this.http.put<Users>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/users/' + id, JSON.stringify(user), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }



  // HttpClient API post() method => Create event
  // checkUser(user): Observable<Users> {
  //   return this.http.get<Users>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/users', JSON.stringify(user), this.httpOptions)
  //   .pipe(
  //     retry(1),
  //     catchError(this.handleError)
  //   )
  // } 
 

  // HttpClient API put() method => Update restaurant
  updateRestaurant(id, restaurant): Observable<Restaurants> {
    return this.http.put<Restaurants>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/restaurants/' + id, JSON.stringify(restaurant), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API delete() method => Delete restaurant
  deleteRestaurant(id){
    return this.http.delete<Restaurants>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/restaurants/' + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

    // HttpClient API delete() method => Delete restaurant
  deleteAttendee(id){
    return this.http.delete<AttendeeKoppel>(this.apiURL + '/Aquadine-1.0-SNAPSHOT/services/rest/attendeekoppels/' + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // Error handling 
  handleError(error) {
     let errorMessage = '';
     if(error.error instanceof ErrorEvent) {
       // Get client-side error
       errorMessage = error.error.message;
     } else {
       // Get server-side error
       errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
     }
     window.alert(errorMessage);
     return throwError(errorMessage);
  }
}
