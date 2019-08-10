package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Users;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UsersDao;
import service.impl.UsersDaoImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users> {
    private Users user = new Users();
    private static final long serialVersionUID = 1L;

    //用户登录动作
    public String login(){
        UsersDao udao = new UsersDaoImpl();
        if(udao.usersLogin(user)){
            session.setAttribute("loginUserName",user.getUsername());
            return "login_success";
        }else{
            return "login_failure";
        }

    }

    //用户注销方法
    @SkipValidation
    public String logout(){
        if(session.getAttribute("loginUserName")!=null){
            session.removeAttribute("loginUserName");
        }
        return "logout_success";
    }
    @Override
    public Users getModel() {
        return user;
    }

    @Override
    public void validate() {
        //检查用户名不能为空
        if("".equals(user.getUsername().trim())){
            this.addFieldError("usernameError","用户名不能为空");

        }
        if(user.getPassword().length()<3){
            this.addFieldError("passwordError","密码长度不能少于3");
        }
    }
}
