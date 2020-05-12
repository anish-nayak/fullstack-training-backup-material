import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
    selector: 'second',
    template: `<div>   
    
    <h1>Second component
    </h1>
    <input type="button" (click)="onClick()" value="GO TO THIRD PAGE">
            </div>`
})
export class SecondComponent {
    constructor(private router: Router) {

    }
    onClick() {
        this.router.navigate(['/third', 'MIT']);
    }
}