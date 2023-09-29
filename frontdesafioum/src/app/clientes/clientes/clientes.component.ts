import { Component } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClientesService } from '../services/clientes.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.scss']
})
export class ClientesComponent {

  clientes: Cliente[] = [];
  displayedColumns = ['nome', 'cnpj', 'cpf', 'razaosocial', 'mcc', 'email'];

  constructor (private clientesService: ClientesService) {
    this.clientes = this.clientesService.list();
  }


}
