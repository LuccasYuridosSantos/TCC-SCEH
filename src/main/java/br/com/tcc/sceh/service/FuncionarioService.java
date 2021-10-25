package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.Cargo;
import br.com.tcc.sceh.model.Funcionario;
import br.com.tcc.sceh.model.Telefone;
import br.com.tcc.sceh.repository.CargoRepository;
import br.com.tcc.sceh.repository.FuncionarioRepository;
import br.com.tcc.sceh.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    private CargoRepository cargoRepository;
    private TelefoneRepository telefoneRepository;

    @Autowired
    public FuncionarioService(CargoRepository cargoRepository, TelefoneRepository telefoneRepository) {
        this.cargoRepository = cargoRepository;
        this.telefoneRepository = telefoneRepository;
    }

    public void verificarFuncionario(final Funcionario funcionario) {
        if(funcionario != null){
            adicionarUmCargoExistente(funcionario);
            buscsarTelefonesExistentes(funcionario);
        }
    }

    private void buscsarTelefonesExistentes(Funcionario funcionario) {
        if(CollectionUtils.isEmpty(funcionario.getTelefone())){
            final List<Telefone> telefoneList = new ArrayList<>();
            var funcionarios = funcionario.getTelefone();
            if(CollectionUtils.isEmpty(funcionarios)){
                funcionarios.forEach(
                        telefone -> {
                            telefoneRepository
                                    .findById(telefone.getCodigoTelefone()).ifPresent(tel -> telefoneList.add(telefone));

                        }
                );
            }
            funcionario.setTelefone(telefoneList);
        }
    }

    private void adicionarUmCargoExistente(final Funcionario funcionario) {
        if(funcionario.getCargo() != null){
            cargoRepository.findById(funcionario.getCargo().getCodigoCargo()).ifPresent(funcionario::setCargo);
        }
    }
}
