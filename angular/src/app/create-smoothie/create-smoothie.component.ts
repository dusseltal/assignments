import { SmoothieService } from '../smoothie.service';
import { Smoothie } from '../smoothie';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-smoothie',
  templateUrl: './create-smoothie.component.html',
  styleUrls: ['./create-smoothie.component.css']
})
export class CreateSmoothieComponent implements OnInit {

  smoothie: Smoothie = new Smoothie();
  submitted = false;

  constructor(private smoothieService: SmoothieService,
    private router: Router) { }

  ngOnInit() {
  }

  newSmoothie(): void {
    this.submitted = false;
    this.smoothie = new Smoothie();
  }

  save() {
    this.smoothieService.createSmoothie(this.smoothie)
      .subscribe(data => console.log(data), error => console.log(error));
    this.smoothie = new Smoothie();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/smoothies']);
  }
}
