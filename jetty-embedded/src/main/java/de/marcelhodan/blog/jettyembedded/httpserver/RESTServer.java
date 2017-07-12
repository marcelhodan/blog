package de.marcelhodan.blog.jettyembedded.httpserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class RESTServer {
	public static void main(String[] args) throws Exception {
		// Create Server
		Server server = new Server(8080);

		// Configure ServletContextHandler
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
	}
}
