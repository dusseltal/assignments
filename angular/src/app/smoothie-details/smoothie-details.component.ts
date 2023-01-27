import { Smoothie } from '../smoothie';
import { Component, OnInit, Input } from '@angular/core';
import { SmoothieService } from '../smoothie.service';
import { SmoothieListComponent } from '../smoothie-list/smoothie-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-smoothie-details',
  templateUrl: './smoothie-details.component.html',
  styleUrls: ['./smoothie-details.component.css']
})
export class SmoothieDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['smoothies']);
  }
}
