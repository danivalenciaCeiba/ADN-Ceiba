import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SingletonService } from './singleton/singleton.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [SingletonService],
})
export class SharedModule { }
