package de.marcelhodan.blog.springboot.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.marcelhodan.blog.springboot.dataaccess.event.model.DAEventE;
import de.marcelhodan.blog.springboot.dataaccess.repos.DAEventRepository;

public abstract class BaseController {
    private static final String API_V1 = "v1"; // TODO: remove hard coded version with model specific api version
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private DAEventRepository eventRepository;
    @Autowired
    private ObjectMapper om;
    private String rootContext;

    public BaseController(String rootContext) {
	this.rootContext = rootContext;
    }

    protected void trackApiInteraction(String request, Object objectToTrack) {
	try {
	    String apiVersion = API_V1;
	    String requestBody = om.writeValueAsString(objectToTrack);
	    String fullContextPath = fullContextPath(request);
	    DAEventE daEvent = new DAEventE(apiVersion, fullContextPath, requestBody);
	    eventRepository.save(daEvent);
	    LOGGER.info("saved a new {}: {}", DAEventE.class.getSimpleName(), daEvent);
	} catch (JsonProcessingException e) {
	    LOGGER.error(String.format("Could not create json String from '%s' of class '%s'", objectToTrack), objectToTrack.getClass(), e);
	}
    }

    protected String fullContextPath(String contextPath) {
	return String.format("%s%s", rootContext, contextPath);
    }
}
