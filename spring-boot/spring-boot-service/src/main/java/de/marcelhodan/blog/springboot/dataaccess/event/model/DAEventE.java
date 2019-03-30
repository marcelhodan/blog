package de.marcelhodan.blog.springboot.dataaccess.event.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "Events")
@Getter
@EqualsAndHashCode
@ToString
public class DAEventE {
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private String eventId;
    private String apiVersion;
    private String request;
    private String requestBody;

    protected DAEventE() {
	// constructor for JPA
    }

    public DAEventE(String apiVersion, String request, String requestBody) {
	timestamp = new Date();
	eventId = UUID.randomUUID().toString();
	this.apiVersion = apiVersion;
	this.request = request;
	this.requestBody = requestBody;
    }

}
