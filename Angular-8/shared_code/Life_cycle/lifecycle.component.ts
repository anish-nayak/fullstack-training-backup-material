import { Component, OnChanges, SimpleChanges, OnInit, DoCheck, AfterContentInit, AfterViewInit, OnDestroy } from '@angular/core';

@Component({
    selector: 'lifecycle',
    template: `<div>
    <ng-content></ng-content>
    <h1>Hello World
    </h1>
    {{title}}
            </div>`,
    inputs: ['uname']
})
export class LifeCycleComponent implements 
    OnChanges, OnInit, DoCheck, AfterContentInit, AfterViewInit, OnDestroy {
        public title:string = 'ITER';

    constructor() {
        console.log('1) LifeCycleComponent constructor called');
    }
    ngOnChanges(changes: SimpleChanges): void {
        console.log('2) ngOnChanges() changes: ', changes);
    }
    ngOnInit() {
        console.log('3) ngOnInit() called');
    }
    ngDoCheck() {
        console.log("4) ngDoCheck() called");
    }
    ngAfterContentInit(): void {
        console.log("5) ngAfterContentInit() called");
    }
    ngAfterViewInit(): void {
        console.log("6) ngAfterViewInit() called");
    }
    ngAfterViewChecked(): void {
        console.log("7) ngAfterViewChecked() called");
    }
    ngOnDestroy(): void {
        console.log("8) ngOnDestroy() called");
    }
}