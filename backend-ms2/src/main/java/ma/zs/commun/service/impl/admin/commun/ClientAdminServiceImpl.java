package ma.zs.commun.service.impl.admin.commun;


import ma.zs.commun.bean.core.commun.Client;
import ma.zs.commun.dao.criteria.core.commun.ClientCriteria;
import ma.zs.commun.dao.facade.core.commun.ClientDao;
import ma.zs.commun.dao.specification.core.commun.ClientSpecification;
import ma.zs.commun.service.facade.admin.commun.ClientAdminService;
import ma.zs.commun.zynerator.service.AbstractServiceImpl;
import ma.zs.commun.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.commun.service.facade.admin.commun.CategorieClientAdminService ;
import ma.zs.commun.bean.core.commun.CategorieClient ;

import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {






    public Client findByReferenceEntity(Client t){
        return  dao.findByCin(t.getCin());
    }
    public void findOrSaveAssociatedObject(Client t){
        if( t != null) {
            t.setCategorieClient(categorieClientService.findOrSave(t.getCategorieClient()));
        }
    }

    public List<Client> findByCategorieClientId(Long id){
        return dao.findByCategorieClientId(id);
    }
    public int deleteByCategorieClientId(Long id){
        return dao.deleteByCategorieClientId(id);
    }
    public long countByCategorieClientCode(String code){
        return dao.countByCategorieClientCode(code);
    }

    public List<Client> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Client.class, ClientSpecification.class);
    }


    @Autowired
    private CategorieClientAdminService categorieClientService ;

    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}
