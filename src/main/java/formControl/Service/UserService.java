package formControl.Service;

import formControl.DAO.UserDAO;
import formControl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public void save(User user){
        userDAO.save(user);
    }
    public List<User> findAll(){
        return userDAO.findAll();
    }
    public long count(){
        return userDAO.count();
    }
    public User findById(long id){
        return userDAO.userDetail(id);
    }
    public List<User> findBySex(boolean sex){
        return userDAO.findBySex(sex);
    }
}
