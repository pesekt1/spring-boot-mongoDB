package swc3.mongodbwebserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import swc3.mongodbwebserver.model.Tutorial;

import java.util.List;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}
