import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js";
//import {};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'app-commerce-front';
  public profile: any;

  constructor(public keycloackService: KeycloakService) {

  }

  ngOnInit() {

    if(this.keycloackService.isLoggedIn()){
      this.keycloackService.loadUserProfile().then(profile=>{
        this.profile=profile;
      });

    }
  }

  logout(){
    this.keycloackService.logout(window.location.origin);
  }

  async onLogin(){
    await this.keycloackService.login({
      redirectUri: window.origin
    });
  }
}
