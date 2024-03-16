package ma.zs.commun.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.commun.zynerator.repository.AbstractRepository;
import ma.zs.commun.bean.core.commun.CategorieClient;
import org.springframework.stereotype.Repository;
import ma.zs.commun.bean.core.commun.CategorieClient;
import java.util.List;


@Repository
public interface CategorieClientDao extends AbstractRepository<CategorieClient,Long>  {
    CategorieClient findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CategorieClient(item.id,item.libelle) FROM CategorieClient item")
    List<CategorieClient> findAllOptimized();

}
