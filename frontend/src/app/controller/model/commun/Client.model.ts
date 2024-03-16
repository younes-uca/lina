import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CategorieClientDto} from './CategorieClient.model';

export class ClientDto extends BaseDto{

    public cin: string;

    public nom: string;

    public tel: string;

    public email: string;

    public adresse: string;

    public description: string;

    public creance: null | number;

    public categorieClient: CategorieClientDto ;
    

    constructor() {
        super();

        this.cin = '';
        this.nom = '';
        this.tel = '';
        this.email = '';
        this.adresse = '';
        this.description = '';
        this.creance = null;

        }

}
