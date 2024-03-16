import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientAdminService} from 'src/app/controller/service/admin/commun/CategorieClientAdmin.service';
@Component({
  selector: 'app-client-create-admin',
  templateUrl: './client-create-admin.component.html'
})
export class ClientCreateAdminComponent extends AbstractCreateController<ClientDto, ClientCriteria, ClientAdminService>  implements OnInit {



   private _validClientCin = true;
   private _validClientNom = true;
    private _validCategorieClientCode = true;
    private _validCategorieClientLibelle = true;

    constructor( private clientService: ClientAdminService , private categorieClientService: CategorieClientAdminService) {
        super(clientService);
    }

    ngOnInit(): void {
        this.categorieClient = new CategorieClientDto();
        this.categorieClientService.findAll().subscribe((data) => this.categorieClients = data);
    }





    public override setValidation(value: boolean){
        this.validClientCin = value;
        this.validClientNom = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClientCin();
        this.validateClientNom();
    }

    public validateClientCin(){
        if (this.stringUtilService.isEmpty(this.item.cin)) {
        this.errorMessages.push('Cin non valide');
        this.validClientCin = false;
        } else {
            this.validClientCin = true;
        }
    }
    public validateClientNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validClientNom = false;
        } else {
            this.validClientNom = true;
        }
    }


    public async openCreateCategorieClient(categorieClient: string) {
    const isPermistted = await this.roleService.isPermitted('CategorieClient', 'add');
    if(isPermistted) {
         this.categorieClient = new CategorieClientDto();
         this.createCategorieClientDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createCategorieClientDialog(): boolean {
       return this.categorieClientService.createDialog;
    }
    set createCategorieClientDialog(value: boolean) {
        this.categorieClientService.createDialog= value;
    }



    get validClientCin(): boolean {
        return this._validClientCin;
    }

    set validClientCin(value: boolean) {
         this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }

    set validClientNom(value: boolean) {
         this._validClientNom = value;
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
