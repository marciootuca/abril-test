package br.com.abril.editora.repository;

import br.com.abril.editora.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
   @Query("SELECT P FROM Pessoa P JOIN Assinatura A ON P.id = A.pessoa.id " +
           " JOIN Produto PR ON PR.id = A.produto.id " +
           " JOIN AssinaturaEndereco  AE ON AE.assinatura.id = A.id " +
           " WHERE AE.cep = :cep AND PR.id = :produtoId " +
           " AND AE.tipoEndereco = 'ENTREGA'")
   List<Pessoa> findPessoaByCepAndProduto(String cep, Long produtoId);
}
