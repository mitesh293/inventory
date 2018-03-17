package com.mit.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.daoImpl.AbstractDao;
import com.mit.model.User;

@Service("userService")
@Transactional
public class LoginService extends AbstractDao<Serializable, User>{
	@SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("email"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();
         
        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
    }
}
