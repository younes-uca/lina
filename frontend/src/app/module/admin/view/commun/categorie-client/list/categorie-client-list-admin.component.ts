import {Component, OnInit} from '@angular/core';
import {CategorieClientAdminService} from 'src/app/controller/service/admin/commun/CategorieClientAdmin.service';
import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientCriteria} from 'src/app/controller/criteria/commun/CategorieClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-categorie-client-list-admin',
  templateUrl: './categorie-client-list-admin.component.html'
})
export class CategorieClientListAdminComponent extends AbstractListController<CategorieClientDto, CategorieClientCriteria, CategorieClientAdminService>  implements OnInit {

    override fileName = 'CategorieClient';




    constructor( private categorieClientService: CategorieClientAdminService  ) {
        super(categorieClientService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CategorieClient').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
