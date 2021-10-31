package br.com.tcc.sceh.service;

import br.com.tcc.sceh.model.Funcionario;
import br.com.tcc.sceh.repository.CargoRepository;
import br.com.tcc.sceh.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        }
    }

    private void adicionarUmCargoExistente(final Funcionario funcionario) {
        if(funcionario.getCargo() != null){
            cargoRepository.findById(funcionario.getCargo().getCodigoCargo()).ifPresent(funcionario::setCargo);
        }
    }
}
