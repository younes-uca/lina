package ma.zs.commun.zynerator.service;

import ma.zs.commun.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zs.commun.zynerator.criteria.BaseCriteria;
import ma.zs.commun.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
