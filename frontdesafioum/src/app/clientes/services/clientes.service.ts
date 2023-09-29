import { Injectable } from '@angular/core';
import { Cliente } from '../model/cliente';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private httpClient: HttpClient) { }

  list(): Cliente[] {
    return [
      {_id: '12345678910', nome: 'Nome da silva', mcc: '1234', email: 'email@email.com', cpf: '12345678910', cnpj: '', razaosocial: ''},
      {_id: '12345678910121', nome: 'O contato', mcc: '1234', email: 'nomail@email.com', cpf: '10987654321', cnpj: '12345678910121', razaosocial: 'PB&J'}
    ];
  }
}
