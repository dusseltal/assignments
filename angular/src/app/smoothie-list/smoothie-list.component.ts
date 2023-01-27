import { SmoothieDetailsComponent } from '../smoothie-details/smoothie-details.component';
import { Observable } from "rxjs";
import { SmoothieService } from "../smoothie.service";
import { Smoothie } from "../smoothie";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-smoothie-list",
  templateUrl: "./smoothie-list.component.html",
  styleUrls: ["./smoothie-list.component.css"]
})
export class SmoothieListComponent implements OnInit {
  smoothies: Observable<Smoothie[]>;

  constructor(private smoothieService: SmoothieService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.smoothies = this.smoothieService.getSmoothiesList();
  }

  deleteSmoothie(id: number) {
    this.smoothieService.deleteSmoothie(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  smoothieDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateSmoothie(id: number){
    this.router.navigate(['update', id]);
  }
}
