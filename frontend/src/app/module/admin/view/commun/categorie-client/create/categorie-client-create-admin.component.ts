import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CategorieClientAdminService} from 'src/app/controller/service/admin/commun/CategorieClientAdmin.service';
import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientCriteria} from 'src/app/controller/criteria/commun/CategorieClientCriteria.model';
@Component({
  selector: 'app-categorie-client-create-admin',
  templateUrl: './categorie-client-create-admin.component.html'
})
export class CategorieClientCreateAdminComponent extends AbstractCreateController<CategorieClientDto, CategorieClientCriteria, CategorieClientAdminService>  implements OnInit {



   private _validCategorieClientCode = true;
   private _validCategorieClientLibelle = true;

    constructor( private categorieClientService: CategorieClientAdminService ) {
        super(categorieClientService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validCategorieClientCode = value;
        this.validCategorieClientLibelle = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieClientCode();
        this.validateCategorieClientLibelle();
    }

    public validateCategorieClientCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validCategorieClientCode = false;
        } else {
            this.validCategorieClientCode = true;
        }
    }
    public validateCategorieClientLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validCategorieClientLibelle = false;
        } else {
            this.validCategorieClientLibelle = true;
        }
    }






    get validCategorieClientCode(): boolean {
        return this._validCategorieClientCode;
    }

    set validCategorieClientCode(value: boolean) {
         this._validCategorieClientCode = value;
    }
    get validCategorieClientLibelle(): boolean {
        return this._validCategorieClientLibelle;
    }

    set validCategorieClientLibelle(value: boolean) {
         this._validCategorieClientLibelle = value;
    }



}
