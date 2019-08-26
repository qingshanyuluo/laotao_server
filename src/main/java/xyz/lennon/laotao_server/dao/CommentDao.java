package xyz.lennon.laotao_server.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lennon.laotao_server.entity.Comment;

import java.util.Optional;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
    Page<Comment> findByShopId(Long shopId, Pageable pageable);

    Optional<Comment> findByIdAndUserId(Long id, Long postId);
}
