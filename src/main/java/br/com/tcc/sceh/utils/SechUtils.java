package br.com.tcc.sceh.utils;

import br.com.tcc.sceh.exceptions.ApiException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SechUtils {

    public static void lancarExcecaoComAtributoVazioOuNulo(final String atributoParaVerificar,
                                                    final String nomeDoAtributo,
                                                    final String msgParaExcecao){
        if (StringUtils.isBlank(atributoParaVerificar)) {
            lancarException(nomeDoAtributo, msgParaExcecao);
        }
    }

    public static void lancarException(final String valorInicialDaMsg, final String valorFinalMsg) {
        List<String> details = List.of(valorInicialDaMsg+ valorFinalMsg);
        throw ApiException.invalidRequest(details);
    }

    public static boolean regexCnpjECpf(final String valor) {
        final Pattern pattern = Pattern.compile("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");
        Matcher matcher = pattern.matcher(valor);
        return matcher.find();
    }
}
