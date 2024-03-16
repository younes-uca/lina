package  ma.zs.stocky.required.dto.commun;

import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieClientDto extends AuditBaseDto {

    private String code  ;
    private String libelle  ;



    public CategorieClientDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
         this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
         this.libelle = libelle;
    }




}
