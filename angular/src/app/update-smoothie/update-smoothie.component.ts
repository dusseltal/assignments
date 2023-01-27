import { Component, OnInit } from '@angular/core';
import { Smoothie } from '../smoothie';
import { ActivatedRoute, Router } from '@angular/router';
import { SmoothieService } from '../smoothie.service';

@Component({
  selector: 'app-update-smoothie',
  templateUrl: './update-smoothie.component.html',
  styleUrls: ['./update-smoothie.component.css']
})
export class UpdateSmoothieComponent implements OnInit {

  id: number;
  smoothie: Smoothie;

  constructor(private route: ActivatedRoute,private router: Router,
    private smoothieService: SmoothieService) { }

  ngOnInit() {
    this.smoothie = new Smoothie();

    this.id = this.route.snapshot.params['id'];

    this.smoothieService.getSmoothie(this.id)
      .subscribe(data => {
        console.log(data)
        this.smoothie = data;
      }, error => console.log(error));
  }

  updateSmoothie() {
    this.smoothieService.updateSmoothie(this.id, this.smoothie)
      .subscribe(data => console.log(data), error => console.log(error));
    this.smoothie = new Smoothie();
    this.gotoList();
  }

  onSubmit() {
    this.updateSmoothie();
  }

  gotoList() {
    this.router.navigate(['/smoothies']);
  }
}
