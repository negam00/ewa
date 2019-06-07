import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RestApiService } from "../shared/rest-api.service";

@Component({
    selector: 'app-event-overview',
    templateUrl: './event-overview.component.html',
    styleUrls: ['./event-overview.component.css']
})
export class EventOverviewComponent implements OnInit {

    id = this.actRoute.snapshot.params['id'];

    @Input() eventOverview = {
        userId: 0,
        eventId: 0,
        userOrder: ''
    };
    @Input() orderData = {
        userOrder: '...'
    };

    // orderData: any = {koppelID:0, userId:0,eventId:0, userOrder: 'blahblah'};
    event: any = [];
    order: any = [];
    events: any = [];
    isChecked: any = [];
    users: any = [];
    attendees: any = [];
    attendees2: any = [];
    attendeesWithEmail: any = [];

    loggedInUserID: any = localStorage.getItem('userId');


    constructor(
        public restApi: RestApiService,
        public actRoute: ActivatedRoute,
        public router: Router
    ) {}

    ngOnInit() {
        if (localStorage.getItem('bearer') === null) {

            this.router.navigate(['/']);
        }
        var inEmail = localStorage.getItem('email');
        var sEmails = inEmail.split("@");
        var domain = sEmails[1];

        this.loadEvents(localStorage.getItem('userId'))
        if (typeof this.id != 'undefined') {
            this.loadEvent();
            this.loadAttendees(this.id);
            this.loadUsersWithEmail(domain);
        }
        this.loadUsers();

    }

    // Get events list
    loadEvents(id) {
        return this.restApi.getEvents(id).subscribe((data: {}) => {
            this.events = data;
        })
    }

    loadAttendees(EID) {
        return this.restApi.getAttendees(EID).subscribe((data: []) => {
            var result = [];
            for (var i = data.length - 1; i >= 0; i--) {
              var order = data[i][0]['userOrder'];
              var firstname = data[i][1]['firstname'];
              var userID = data[i][0]['userId'];

              if (userID == localStorage.getItem('userId')) {
                this.order = order;
              }

              result.push({order, firstname, userID});
            }
            //console.log(order);
            this.attendees = result;
        })
    }



    inviteAttendees() {
        var EID = ( < HTMLInputElement > document.getElementById('EID')).value;
        this.eventOverview['eventId'] = parseInt(EID);
        this.restApi.createAttendees(this.eventOverview).subscribe((data: {}) => {
            // this.router.navigate(['/event-overview'])
            // console.log(this.eventOverview);
        })
    }

    // Get event
    loadEvent() {
        return this.restApi.getEvent(this.id).subscribe((data: {}) => {
            this.event = data;
        });
    }

    checkValue(event) {
        console.log('UserID: ' + event);
        var checkBox = ( < HTMLInputElement > document.getElementById("checker" + event));
        if (checkBox.checked == true) {
            this.eventOverview['userId'] = event;
            var EID = ( < HTMLInputElement > document.getElementById('EID')).value;
            this.eventOverview['eventId'] = parseInt(EID);
            this.restApi.createAttendees(this.eventOverview).subscribe((data: {}) => {
                this.router.navigate(['/eventoverview/' + this.id])
                // console.log(this.eventOverview);
            })

        } else {
            // this.restApi.deleteAttendee(event).subscribe(data => {
            //   this.loadUsers();
            // })
            alert("You cant unsubscribe from this event.");
        }
    }
    // Get user list
    loadUsers() {
        return this.restApi.getUsers().subscribe((data: {}) => {
            this.users = data;
        });
    }

    addOrder() {
        this.restApi.changeAttendeeOrder(localStorage.getItem("userId"), this.id, this.orderData).subscribe(data => {
          window.location.reload();
            // this.router.navigate(['/eventoverview/' + this.id])
        })
        // console.log(this.orderData);

        // console.log(this.getCookie('UserLogin'));
    }

    getOrder() {
        return this.restApi.getOrder(this.id).subscribe((data: {}) => {
            this.order = data;
            // this.ngOnInit();
        });
    }


    loadUsersWithEmail(domain) {
        this.restApi.getUsers().subscribe((data: any[]) => {
            var users = data;
            var userWithDomain = [];
            for (var i = users.length - 1; i >= 0; i--) {
                var email = users[i]['email'];
                if (email.includes(domain)) {
                    userWithDomain.push(users[i]);
                }
            }
            this.attendeesWithEmail = userWithDomain;
            // console.log(this.attendeesWithEmail);
        });
    }


}
