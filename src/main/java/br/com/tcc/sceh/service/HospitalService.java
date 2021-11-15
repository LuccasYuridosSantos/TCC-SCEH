package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.Hospital;
import br.com.tcc.sceh.utils.ScehUtils;
import org.springframework.stereotype.Service;

@Service
public class HospitalService{
    public static final String MSG_PADRAO_PARA_ATRIBUTO = " do hospital cadastrado não pode ser vazio ou nulo";
    public static final String MSG_PADRAO_PARA_HOSPITAL = " cadastrado não pode ser nulo";

    public void ValidacaoHospital(final Hospital hospital) {
        if (hospital == null){
            ScehUtils.lancarException("Hospital",MSG_PADRAO_PARA_HOSPITAL);
        }else{
            verificarAtributosHospital(hospital);
        }
    }

    public void verificarAtributosHospital(final Hospital hospital) {
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getNomeFantasia(),
                "Nome Fantasia", MSG_PADRAO_PARA_ATRIBUTO);
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getRazaoSocial(),
                "Razão Social", MSG_PADRAO_PARA_ATRIBUTO);
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getTipo(),
                "Tipo", MSG_PADRAO_PARA_ATRIBUTO);
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getCnpj(),
                "CNPJ", MSG_PADRAO_PARA_ATRIBUTO);
        if(!ScehUtils.regexCnpjECpf(hospital.getCnpj())){
            ScehUtils.lancarException("O valor do CNPJ ", "não é valido");
        }
    }
}
