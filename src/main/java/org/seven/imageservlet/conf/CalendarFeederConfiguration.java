package org.seven.imageservlet.conf;

import org.seven.imageservlet.listener.CalendarFeederListener;
import org.seven.imageservlet.servlet.CalendarFeederServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.ServletContextListener;

@Configuration
public class CalendarFeederConfiguration {

    @Bean
    public ServletRegistrationBean customServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CalendarFeederServlet(), "/feeder");
        return bean;
    }
    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean();
        bean.setListener(new CalendarFeederListener());
        return bean;
    }

}
