package com.dh.Projeto.Integrador.repository;

import com.dh.Projeto.Integrador.model.Caracteristicas;
import com.dh.Projeto.Integrador.model.Imagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRepository extends JpaRepository<Imagens, String> {

}
