package ma.zs.commun.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.commun.zynerator.repository.AbstractRepository;
import ma.zs.commun.bean.core.commun.Client;
import org.springframework.stereotype.Repository;
import ma.zs.commun.bean.core.commun.Client;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {
    Client findByCin(String cin);
    int deleteByCin(String cin);

    List<Client> findByCategorieClientId(Long id);
    int deleteByCategorieClientId(Long id);
    long countByCategorieClientCode(String code);

    @Query("SELECT NEW Client(item.id,item.nom) FROM Client item")
    List<Client> findAllOptimized();

}
