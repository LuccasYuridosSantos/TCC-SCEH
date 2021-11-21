package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.entity.Hospital;
import br.com.tcc.sceh.model.requests.HospitalRequest;
import br.com.tcc.sceh.repository.HospitalRepository;
import br.com.tcc.sceh.repository.TelefoneRepository;
import br.com.tcc.sceh.utils.ConvertUtil;
import br.com.tcc.sceh.utils.ScehUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService{
    public static final String MSG_PADRAO_PARA_ATRIBUTO = " do hospital cadastrado não pode ser vazio ou nulo";
    public static final String MSG_PADRAO_PARA_HOSPITAL = " cadastrado não pode ser nulo";

    private HospitalRepository hospitalRepository;
    private CnpjService cnpjService;

    @Autowired
    public HospitalService(final HospitalRepository hospitalRepository, final CnpjService cnpjService) {
        this.hospitalRepository = hospitalRepository;
        this.cnpjService = cnpjService;
    }

    public void validacaoHospital(final Hospital hospital) {
        if (hospital == null){
            ScehUtils.lancarException("Hospital",MSG_PADRAO_PARA_HOSPITAL);
        }else{
            verificarAtributosHospital(hospital);
        }
    }

    public void verificarAtributosHospital(final Hospital hospital) {
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getRazaoSocial(),
                "Razão Social", MSG_PADRAO_PARA_ATRIBUTO);
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getTipo(),
                "Tipo", MSG_PADRAO_PARA_ATRIBUTO);
        ScehUtils.lancarExcecaoComAtributoVazioOuNulo(hospital.getCnpj(),
                "CNPJ", MSG_PADRAO_PARA_ATRIBUTO);
    }

    public Hospital preCadastroHospital(HospitalRequest request){
        var respCnpj = cnpjService.buscaCNPJ(request.getCnpj());
        var hospital = ConvertUtil.convertHospital(respCnpj);
        hospital.setTipo(request.getTipo());
        hospital.setObservacao(request.getObservacao());
        validacaoHospital(hospital);
        if (hospitalExistente(hospital.getCnpj())){
            ScehUtils.lancarException("Hospital com este CNPJ já registrado!!!");
        }
        return hospital;
    }

    public boolean hospitalExistente(final String cnpj) {
        var hospitalExist = hospitalRepository.findByCnpj(cnpj);
        return hospitalExist.isPresent();
    }
}
