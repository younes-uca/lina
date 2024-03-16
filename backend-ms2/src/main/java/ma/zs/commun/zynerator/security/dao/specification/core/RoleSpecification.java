package ma.zs.commun.zynerator.security.dao.specification.core;

import ma.zs.commun.zynerator.security.bean.Role;
import ma.zs.commun.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.commun.zynerator.specification.AbstractSpecification;


public class RoleSpecification extends  AbstractSpecification<RoleCriteria, Role>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("authority", criteria.getAuthority(),criteria.getAuthorityLike());
    }

    public RoleSpecification(RoleCriteria criteria) {
        super(criteria);
    }

    public RoleSpecification(RoleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
