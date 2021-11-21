package br.com.tcc.sceh.service;

import br.com.tcc.sceh.utils.ScehUtils;
import br.com.tcc.sceh.utils.StringTojsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CnpjService {

	private StringTojsonObject parser;

	@Autowired
	public CnpjService(final StringTojsonObject parser) {
		this.parser = parser;
	}

	public Map<String, String> buscaCNPJ(String cnpjRequest){
		var cnpj = verificarCnpj(cnpjRequest);
		var respSpeedio =
				new RestTemplate().getForObject("https://api-publica.speedio.com.br/buscarcnpj?cnpj="+cnpj,
						String.class);
		StringTojsonObject tojsonObject = new StringTojsonObject();
		return tojsonObject.convert(respSpeedio);
	}

	public String verificarCnpj(String cnpjRequest){
		if(cnpjRequest.contains(".") || cnpjRequest.contains("-") || cnpjRequest.contains("/") ){
			cnpjRequest = ScehUtils.removeCharacterSpecialCNPJ(cnpjRequest);
		}
		if(!ScehUtils.regexCnpjECpf(cnpjRequest)){
			ScehUtils.lancarException("O valor do CNPJ ", "não é valido");
		}
		return cnpjRequest;
	}
}
