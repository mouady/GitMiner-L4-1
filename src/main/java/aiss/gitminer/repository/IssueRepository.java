package aiss.gitminer.repository;

import aiss.gitminer.model.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, String> {
    Page<Issue> findByTitle(String title, Pageable paging);
    Page<Issue> findByState(String state, Pageable paging);
    Page<Issue> findByAuthorId(String authorId, Pageable paging);
}
