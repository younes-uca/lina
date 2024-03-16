import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategorieClientDto} from 'src/app/controller/model/commun/CategorieClient.model';
import {CategorieClientCriteria} from 'src/app/controller/criteria/commun/CategorieClientCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategorieClientAdminService extends AbstractService<CategorieClientDto, CategorieClientCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/categorieClient/');
    }

    public constrcutDto(): CategorieClientDto {
        return new CategorieClientDto();
    }

    public constrcutCriteria(): CategorieClientCriteria {
        return new CategorieClientCriteria();
    }
}
