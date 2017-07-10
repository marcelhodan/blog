package de.marcelhodan.blog.jettyembedded.httpserver;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class Static {
	public static void main(String[] args) throws Exception {
		// Create Server
		Server server = new Server(8080);

		// Configure ResourceHandler
		ResourceHandler resource_handler = new ResourceHandler();
		resource_handler.setDirectoriesListed(true);
		resource_handler.setWelcomeFiles(new String[] { "index.html" });
		resource_handler.setResourceBase("./src/webapp");

		// Add the ResourceHandler to the server.
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resource_handler });
		server.setHandler(handlers);

		// Start the server
		server.start();
		server.join();
	}
}
