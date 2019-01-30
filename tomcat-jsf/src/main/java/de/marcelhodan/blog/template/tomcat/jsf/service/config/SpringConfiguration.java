package de.marcelhodan.blog.template.tomcat.jsf.service.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import de.marcelhodan.blog.template.tomcat.jsf.ScanPackage;

/**
 * <p>
 * This class extends {@link AnnotationConfigWebApplicationContext} and
 * implements {@link WebApplicationInitializer} to bootstrap this web
 * application from within Spring config. The alternative would be the xml
 * configuration within WEB-INF/web.xml
 * </p>
 *
 * @author marcel.hodan
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = ScanPackage.class)
public class SpringConfiguration extends AnnotationConfigWebApplicationContext implements WebApplicationInitializer {

    /**
     * Spring Java config instead of web.xml config
     */
    @Override
    public void onStartup(ServletContext container) {
	DispatcherServlet servlet = new DispatcherServlet();
	/* tell application server which application context shall be used */
	servlet.setContextClass(getClass());
	/* specify which spring configuration shall be used for bean definition */
	servlet.setContextConfigLocation(SpringConfiguration.class.toString());
	/* Servlet registration and configuration */
	ServletRegistration.Dynamic registration = container.addServlet("api", servlet);
	registration.setLoadOnStartup(1);
	registration.addMapping("/*");
    }

}
