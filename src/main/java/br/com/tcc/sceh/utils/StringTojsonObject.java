package br.com.tcc.sceh.utils;

import br.com.tcc.sceh.model.response.ResponseCnpj;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Map;

@Service
public class StringTojsonObject {

	public Map<String, String> convert(String objectString){

		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>() {}.getType();
		Map<String, String> resp = gson.fromJson(objectString, type);;
		System.out.println(resp);

		return resp;
	}
}
