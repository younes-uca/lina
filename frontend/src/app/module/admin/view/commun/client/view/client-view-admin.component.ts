import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';

import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientAdminService} from 'src/app/controller/service/admin/commun/CategorieClientAdmin.service';
@Component({
  selector: 'app-client-view-admin',
  templateUrl: './client-view-admin.component.html'
})
export class ClientViewAdminComponent extends AbstractViewController<ClientDto, ClientCriteria, ClientAdminService> implements OnInit {


    constructor(private clientService: ClientAdminService, private categorieClientService: CategorieClientAdminService){
        super(clientService);
    }

    ngOnInit(): void {
    }


    get categorieClient(): CategorieClientDto {
       return this.categorieClientService.item;
    }
    set categorieClient(value: CategorieClientDto) {
        this.categorieClientService.item = value;
    }
    get categorieClients(): Array<CategorieClientDto> {
       return this.categorieClientService.items;
    }
    set categorieClients(value: Array<CategorieClientDto>) {
        this.categorieClientService.items = value;
    }


}
