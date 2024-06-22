package org.sopt.week6.repository;

import org.sopt.week6.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {

}
