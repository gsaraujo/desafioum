import { Component } from '@angular/core';

import { ClientesService } from '../services/clientes.service';
import { Observable, catchError, of } from 'rxjs';
import { Cliente } from '../model/cliente';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.scss']
})
export class ClientesComponent {

  clientes$: Observable<Cliente[]>;
  displayedColumns = ['nome', 'cnpj', 'cpf', 'razaosocial', 'mcc', 'email'];

  constructor (
    private clientesService: ClientesService,
    public dialog: MatDialog

    ) {
    this.clientes$ = this.clientesService.list()
    .pipe(catchError(error => {
      this.onError('Erro ao carregar informações.');
      return of([])
    }));
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }


}
