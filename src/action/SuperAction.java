package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//所有Action的基类
public class SuperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {
    private static final long serialVersionUID = 1L;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    protected HttpSession session;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
        this.session = httpServletRequest.getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
}
