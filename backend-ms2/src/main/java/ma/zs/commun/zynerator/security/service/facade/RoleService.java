package ma.zs.commun.zynerator.security.service.facade;

import ma.zs.commun.zynerator.security.bean.Role;
import ma.zs.commun.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.commun.zynerator.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
