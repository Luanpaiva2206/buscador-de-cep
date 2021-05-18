package br.com.buscadordecep.api;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import br.com.buscadordecep.model.CepModel;

public class CepClient {

	private RestTemplate restTemplate;
	private String url;
	
	public CepClient(RestTemplate restTemplate, String url) {
		this.restTemplate = restTemplate;
		this.url = url;
	}

	public CepModel buscar() {
		try {
			return restTemplate.getForObject(URI.create(url), CepModel.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}
