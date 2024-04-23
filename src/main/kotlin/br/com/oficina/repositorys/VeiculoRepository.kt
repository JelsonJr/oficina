package br.com.oficina.repositorys

import br.com.oficina.modelos.veiculo.Veiculo
import org.springframework.data.jpa.repository.JpaRepository

interface VeiculoRepository : JpaRepository<Veiculo, Long> {

}
