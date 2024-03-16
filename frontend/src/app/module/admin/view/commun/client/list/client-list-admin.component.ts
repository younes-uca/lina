import {Component, OnInit} from '@angular/core';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientAdminService} from 'src/app/controller/service/admin/commun/CategorieClientAdmin.service';


@Component({
  selector: 'app-client-list-admin',
  templateUrl: './client-list-admin.component.html'
})
export class ClientListAdminComponent extends AbstractListController<ClientDto, ClientCriteria, ClientAdminService>  implements OnInit {

    override fileName = 'Client';


    categorieClients: Array<CategorieClientDto>;


    constructor( private clientService: ClientAdminService  , private categorieClientService: CategorieClientAdminService) {
        super(clientService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Client').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadCategorieClient();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'nom', header: 'Nom'},
            {field: 'tel', header: 'Tel'},
            {field: 'email', header: 'Email'},
            {field: 'adresse', header: 'Adresse'},
            {field: 'creance', header: 'Creance'},
            {field: 'categorieClient?.libelle', header: 'Categorie client'},
        ];
    }


    public async loadCategorieClient(){
       this.categorieClientService.findAllOptimized().subscribe(categorieClients => this.categorieClients = categorieClients, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Cin': e.cin ,
                 'Nom': e.nom ,
                 'Tel': e.tel ,
                 'Email': e.email ,
                 'Adresse': e.adresse ,
                 'Description': e.description ,
                 'Creance': e.creance ,
                'Categorie client': e.categorieClient?.libelle ,
            }
        });

        this.criteriaData = [{
            'Cin': this.criteria.cin ? this.criteria.cin : environment.emptyForExport ,
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Tel': this.criteria.tel ? this.criteria.tel : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Creance Min': this.criteria.creanceMin ? this.criteria.creanceMin : environment.emptyForExport ,
            'Creance Max': this.criteria.creanceMax ? this.criteria.creanceMax : environment.emptyForExport ,
        //'Categorie client': this.criteria.categorieClient?.libelle ? this.criteria.categorieClient?.libelle : environment.emptyForExport ,
        }];
      }
}
