package br.com.tcc.sceh.utils;

import br.com.tcc.sceh.model.entity.Hospital;

import java.util.Map;

public class ConvertUtil {

	public static Hospital convertHospital(final Map<String,String> obj){
		final Hospital hospital = new Hospital();
		hospital.setCnpj(obj.get("CNPJ"));
		hospital.setRazaoSocial(obj.get("RAZAO SOCIAL"));
		hospital.setNomeFantasia(obj.get("NOME FANTASIA"));
		hospital.setRua(obj.get("TIPO LOGRADOURO")+" " + obj.get("LOGRADOURO"));
		hospital.setNumero(obj.get("NUMERO"));
		hospital.setCidade(obj.get("MUNICIPIO"));
		hospital.setEstado(obj.get("UF"));
		hospital.setCep(obj.get("CEP"));
		hospital.setComplemento(obj.get("COMPLEMENTO"));
		return hospital;
	}
}
