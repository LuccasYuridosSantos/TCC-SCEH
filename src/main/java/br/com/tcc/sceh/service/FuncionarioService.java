package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.entity.Funcionario;
import br.com.tcc.sceh.model.entity.FuncionarioLogin;
import br.com.tcc.sceh.repository.FuncionarioRepository;
import br.com.tcc.sceh.repository.HospitalRepository;
import br.com.tcc.sceh.repository.PermissaoRepository;
import br.com.tcc.sceh.utils.ScehUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;

@Service
public class FuncionarioService {

    private PermissaoRepository permissaoRepository;
    private HospitalRepository hospitalRepository;
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(final PermissaoRepository permissaoRepository,
            final HospitalRepository hospitalRepository, final FuncionarioRepository funcionarioRepository) {
        this.permissaoRepository = permissaoRepository;
        this.hospitalRepository = hospitalRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String senha = encoder.encode(funcionario.getSenha());
        funcionario.setSenha(senha);
        Optional<Funcionario> existUsername = funcionarioRepository.findByUsername(funcionario.getUsername());
        if (existUsername.isPresent()) {
            ScehUtils.lancarException("Username já existe, por gentileza utilizar outro");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Optional<FuncionarioLogin> logar(Optional<FuncionarioLogin> login){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Funcionario> funcionario = funcionarioRepository.findByUsername(login.get().getUsername());

        if(funcionario.isPresent()){
            if (encoder.matches(login.get().getSenha(),funcionario.get().getSenha())) {

                String auth = login.get().getUsername()+":"+login.get().getSenha();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
                String authHeader = "Basic "+new String(encodeAuth);
                login.get().setToken(authHeader);
                login.get().setNome(funcionario.get().getNome());
                login.get().setPermissao(funcionario.get().getPermissao().getNome());
                login.get().setCodigoFuncionario(funcionario.get().getCodigoFuncionario());
                if(StringUtils.isNotBlank(funcionario.get().getHospital().getNomeFantasia())){
                    login.get().setNomeHospital(funcionario.get().getHospital().getNomeFantasia());
                }else{
                    login.get().setNomeHospital(funcionario.get().getHospital().getRazaoSocial());
                }
                login.get().setCnpj(funcionario.get().getHospital().getCnpj());

                return login;
            }
        }

        return Optional.empty();
    }



    public void verificarFuncionario(final Funcionario funcionario) {
        funcionario.setStatus(true);
        adicionarUmaPermissaoEHospitalExistente(funcionario);
    }

    private void adicionarUmaPermissaoEHospitalExistente(final Funcionario funcionario) {
        if(funcionario.getPermissao() != null){
            permissaoRepository.findById(funcionario.getPermissao().getCodigoPermissao()).ifPresent(funcionario::setPermissao);
        }
        if(funcionario.getHospital() != null){
            hospitalRepository.findByCnpj(funcionario.getHospital().getCnpj()).ifPresent(funcionario::setHospital);
        }
    }
}
