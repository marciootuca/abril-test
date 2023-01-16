package br.com.abril.editora.domain;

import br.com.abril.editora.enumeration.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AssinaturaEndereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Assinatura assinatura;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    private String cep;
}
