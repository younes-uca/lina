package ma.zs.commun.service.facade.admin.commun;

import java.util.List;
import ma.zs.commun.bean.core.commun.Client;
import ma.zs.commun.dao.criteria.core.commun.ClientCriteria;
import ma.zs.commun.zynerator.service.IService;



public interface ClientAdminService extends  IService<Client,ClientCriteria>  {

    List<Client> findByCategorieClientId(Long id);
    int deleteByCategorieClientId(Long id);
    long countByCategorieClientCode(String code);




}
