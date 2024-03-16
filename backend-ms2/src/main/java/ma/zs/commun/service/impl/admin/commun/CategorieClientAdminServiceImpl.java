package ma.zs.commun.service.impl.admin.commun;


import ma.zs.commun.bean.core.commun.CategorieClient;
import ma.zs.commun.dao.criteria.core.commun.CategorieClientCriteria;
import ma.zs.commun.dao.facade.core.commun.CategorieClientDao;
import ma.zs.commun.dao.specification.core.commun.CategorieClientSpecification;
import ma.zs.commun.service.facade.admin.commun.CategorieClientAdminService;
import ma.zs.commun.zynerator.service.AbstractServiceImpl;
import ma.zs.commun.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieClientAdminServiceImpl extends AbstractServiceImpl<CategorieClient, CategorieClientCriteria, CategorieClientDao> implements CategorieClientAdminService {






    public CategorieClient findByReferenceEntity(CategorieClient t){
        return  dao.findByCode(t.getCode());
    }


    public List<CategorieClient> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieClient.class, CategorieClientSpecification.class);
    }



    public CategorieClientAdminServiceImpl(CategorieClientDao dao) {
        super(dao);
    }

}
