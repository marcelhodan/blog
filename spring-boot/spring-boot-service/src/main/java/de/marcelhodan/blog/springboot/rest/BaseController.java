package de.marcelhodan.blog.springboot.rest;

public abstract class BaseController {
    private String rootContext;

    public BaseController(String rootContext) {
	this.rootContext = rootContext;
    }

    protected String fullContextPath(String contextPath) {
	return String.format("%s%s", rootContext, contextPath);
    }
}
