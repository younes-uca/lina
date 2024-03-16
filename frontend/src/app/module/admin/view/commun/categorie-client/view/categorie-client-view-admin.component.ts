import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieClientAdminService} from 'src/app/controller/service/admin/commun/CategorieClientAdmin.service';
import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientCriteria} from 'src/app/controller/criteria/commun/CategorieClientCriteria.model';

@Component({
  selector: 'app-categorie-client-view-admin',
  templateUrl: './categorie-client-view-admin.component.html'
})
export class CategorieClientViewAdminComponent extends AbstractViewController<CategorieClientDto, CategorieClientCriteria, CategorieClientAdminService> implements OnInit {


    constructor(private categorieClientService: CategorieClientAdminService){
        super(categorieClientService);
    }

    ngOnInit(): void {
    }




}
