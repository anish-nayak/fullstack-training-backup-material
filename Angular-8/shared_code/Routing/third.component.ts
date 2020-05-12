import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'third',
    template: `<div>   
    
    <h1>Third component
    </h1>
    <h2>College name is {{collegeName}}</h2>
            </div>`
})
export class ThirdComponent implements OnInit {

    public collegeName: string = "";
    constructor(private activatedRoute: ActivatedRoute) {

    }

    ngOnInit() {
        this.collegeName = this.activatedRoute.snapshot.params['college'];
    }
}