package xyz.lennon.laotao_server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lennon.laotao_server.entity.Shop;

@Repository
public interface ShopDao extends JpaRepository<Shop, Long> {
}
