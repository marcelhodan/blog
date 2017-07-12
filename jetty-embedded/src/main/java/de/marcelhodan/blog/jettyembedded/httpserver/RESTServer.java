package de.marcelhodan.blog.jettyembedded.httpserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class RESTServer {
	public static void main(String[] args) throws Exception {
		// Create Server
		Server server = new Server(8090);

		// Configure ServletContextHandler
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);

		// Create Servlet Container
		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
	}
}
