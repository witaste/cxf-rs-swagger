package cn.zno.common.context;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import cn.zno.common.constants.ApplicationConstants;

public class GServletContext implements ServletContextAware {

	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext; 
        getServletContext().setAttribute("resouceVersion", new Date().getTime());
        getServletContext().setAttribute("swaggerPath", ApplicationConstants.SWAGGER_PATH);
	}
	
	public ServletContext getServletContext() {  
        return servletContext;  
    }  
}
