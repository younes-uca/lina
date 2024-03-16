package ma.zs.commun.zynerator.security.dao.specification.core;

import ma.zs.commun.zynerator.security.bean.ActionPermission;
import ma.zs.commun.zynerator.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.commun.zynerator.specification.AbstractSpecification;


public class ActionPermissionSpecification extends  AbstractSpecification<ActionPermissionCriteria, ActionPermission>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ActionPermissionSpecification(ActionPermissionCriteria criteria) {
        super(criteria);
    }

    public ActionPermissionSpecification(ActionPermissionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
