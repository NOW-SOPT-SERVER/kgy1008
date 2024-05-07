package org.sopt.week3.repository;

import org.sopt.week3.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {

}
