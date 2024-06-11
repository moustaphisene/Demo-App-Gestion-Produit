import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  public product! : any;
  constructor(private http : HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8282/api/products")
      .subscribe({
        next : data => {
          this.product = data;

        },
        error : err => {
          console.log("Error to find products", err);
        }
      })

  }

}
