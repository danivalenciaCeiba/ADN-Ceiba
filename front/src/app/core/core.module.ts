import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestService } from './servicios/rest.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
	providers: [RestService],
})
export class CoreModule { }
