package br.com.tcc.sceh.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEndereco;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;
	private String obversacao;

	public Endereco() {
	}

	public Endereco(Long codigoEndereco, String rua, String numero, String cidade, String estado, String cep,
					String complemento, String obversacao) {
		this.codigoEndereco = codigoEndereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
		this.obversacao = obversacao;
	}

	public Long getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getObversacao() {
		return obversacao;
	}

	public void setObversacao(String obversacao) {
		this.obversacao = obversacao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Endereco endereco = (Endereco) o;
		return Objects.equals(codigoEndereco, endereco.codigoEndereco) && Objects.equals(rua, endereco.rua) && Objects.equals(numero, endereco.numero) && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado) && Objects.equals(cep, endereco.cep) && Objects.equals(complemento, endereco.complemento) && Objects.equals(obversacao, endereco.obversacao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoEndereco, rua, numero, cidade, estado, cep, complemento, obversacao);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codigoEndereco", codigoEndereco)
				.append("rua", rua)
				.append("numero", numero)
				.append("cidade", cidade)
				.append("estado", estado)
				.append("cep", cep)
				.append("complemento", complemento)
				.append("obversacao", obversacao)
				.toString();
	}
}
