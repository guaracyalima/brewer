package br.com.sushicorp.brewer.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class Cerveja {

	@NotEmpty
	private String sku;

	@NotEmpty
	@Min(5)
	@Max(20)
	private String nome;

	@NotEmpty
	@Min(5)
	@Max(200)
	private String descricao;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cerveja [sku=" + sku + ", nome=" + nome + "]";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
