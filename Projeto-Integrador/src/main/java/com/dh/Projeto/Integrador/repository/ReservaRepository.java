package com.dh.Projeto.Integrador.repository;

import com.dh.Projeto.Integrador.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reservas, Integer> {

    @Query(value = "SELECT * FROM tb_reservas " +
            "INNER JOIN tb_produtos " +
            "ON tb_reservas.produto_id=tb_produtos.id " +
            "WHERE tb_produtos.id=:id", nativeQuery = true)
    List<Reservas> listarReservasIdProduto(@Param("id") Integer id);



}
