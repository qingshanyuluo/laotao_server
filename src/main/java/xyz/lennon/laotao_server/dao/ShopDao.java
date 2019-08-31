package xyz.lennon.laotao_server.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lennon.laotao_server.entity.Shop;

import java.util.List;

@Repository
public interface ShopDao extends JpaRepository<Shop, Long> {

    public List<Shop> findAllByNameLike(String key);
}
