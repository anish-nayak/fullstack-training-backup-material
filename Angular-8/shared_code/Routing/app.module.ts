import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './components/first.component';
import { ChildComponent } from './components/child.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MyHiddenDirective } from './directives/myhidden.directive';
import {EventPipe} from './pipes/even.pipe';
import { SearchPipe } from './pipes/search.pipe';
import { TemplateDrivenFormComponent } from './components/template-driven-forms.component';
import { MDFComponent } from './components/mdf.component';
import { MDFFormBuilderComponent } from './components/mdf-formbuilder.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';
import { LifeCycleComponent } from './components/lifecycle.component';
import { SecondComponent } from './components/second.component';
import { ThirdComponent } from './components/third.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent, FirstComponent, ChildComponent, MyHiddenDirective, EventPipe, SearchPipe, 
    TemplateDrivenFormComponent, MDFComponent, MDFFormBuilderComponent, LifeCycleComponent,
    SecondComponent, ThirdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
        {path: "second", component: SecondComponent},
        {path: "third/:college", component: ThirdComponent}
    ])
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
