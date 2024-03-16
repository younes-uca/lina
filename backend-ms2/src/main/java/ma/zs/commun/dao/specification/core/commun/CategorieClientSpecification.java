package  ma.zs.commun.dao.specification.core.commun;

import ma.zs.commun.dao.criteria.core.commun.CategorieClientCriteria;
import ma.zs.commun.bean.core.commun.CategorieClient;
import ma.zs.commun.zynerator.specification.AbstractSpecification;


public class CategorieClientSpecification extends  AbstractSpecification<CategorieClientCriteria, CategorieClient>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategorieClientSpecification(CategorieClientCriteria criteria) {
        super(criteria);
    }

    public CategorieClientSpecification(CategorieClientCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
