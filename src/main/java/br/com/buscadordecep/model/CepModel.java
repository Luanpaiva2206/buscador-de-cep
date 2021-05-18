package br.com.buscadordecep.model;

import lombok.Data;

@Data
public class CepModel {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private Long ibge;
	private String gia;
	private Long ddd;
	private Long siafi;
}
