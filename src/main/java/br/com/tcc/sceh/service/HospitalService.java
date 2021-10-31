package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.Hospital;
import br.com.tcc.sceh.model.Telefone;
import br.com.tcc.sceh.repository.TelefoneRepository;
import br.com.tcc.sceh.utils.SechUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService{
    public static final String MSG_PADRAO_PARA_ATRIBUTO = " do hospital cadastrado não pode ser vazio ou nulo";
    public static final String MSG_PADRAO_PARA_HOSPITAL = " cadastrado não pode ser nulo";

    private TelefoneRepository telefoneRepository;

    @Autowired
    public HospitalService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public void ValidacaoHospital(final Hospital hospital) {
        if (hospital == null){
            SechUtils.lancarException("Hospital",MSG_PADRAO_PARA_HOSPITAL);
        }else{
            verificarAtributosHospital(hospital);
        }
    }

    public void verificarAtributosHospital(final Hospital hospital) {
        SechUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getNomeFantasia(),
                "Nome Fantasia", MSG_PADRAO_PARA_ATRIBUTO);
        SechUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getRazaoSocial(),
                "Razão Social", MSG_PADRAO_PARA_ATRIBUTO);
        SechUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getTipo(),
                "Tipo", MSG_PADRAO_PARA_ATRIBUTO);
        SechUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getCnpj(),
                "CNPJ", MSG_PADRAO_PARA_ATRIBUTO);
        if(!SechUtils.regexCnpjECpf(hospital.getCnpj())){
            SechUtils.lancarException("O valor do CNPJ ", "não é valido");
        }
    }
}
