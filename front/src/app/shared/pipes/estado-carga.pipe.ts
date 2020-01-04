import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'estadoCarga'
})
export class EstadoCargaPipe implements PipeTransform {

  transform(value: number): string {
	return 1 === value?"Buen estado":"Mal estado";
  }

}
