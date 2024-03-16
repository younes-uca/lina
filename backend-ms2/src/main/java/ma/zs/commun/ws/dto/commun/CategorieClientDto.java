package  ma.zs.commun.ws.dto.commun;

import ma.zs.commun.zynerator.audit.Log;
import ma.zs.commun.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieClientDto  extends AuditBaseDto {

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
