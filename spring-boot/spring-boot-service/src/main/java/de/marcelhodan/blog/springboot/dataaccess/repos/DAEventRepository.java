package de.marcelhodan.blog.springboot.dataaccess.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.marcelhodan.blog.springboot.dataaccess.event.model.DAEventE;

@Repository
public interface DAEventRepository extends CrudRepository<DAEventE, Long> {

    List<DAEventE> findByApiVersion(String apiVersion);

    List<DAEventE> findByRequest(String request);

    List<DAEventE> findByEventId(String eventId);
}