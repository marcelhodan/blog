package de.marcelhodan.blog.jettyembedded.httpserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class Static {
	public static void main(String[] args) throws Exception {
		// Create Server
		Server server = new Server(8080);

		// Configure ResourceHandler
		ResourceHandler resource_handler = new ResourceHandler();
		resource_handler.setDirectoriesListed(true);
		resource_handler.setResourceBase(".");

	}
}
