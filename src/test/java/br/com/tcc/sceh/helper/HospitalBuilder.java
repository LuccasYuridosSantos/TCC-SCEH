package br.com.tcc.sceh.helper;

import br.com.tcc.sceh.model.Hospital;
import br.com.tcc.sceh.model.Telefone;

import java.util.List;

public class HospitalBuilder {
    private Hospital hospital = new Hospital();

    private HospitalBuilder(){}

    public static HospitalBuilder builder() {
        return new HospitalBuilder();
    }

    public HospitalBuilder hospitalCompleto() {
        final Hospital hospital = new Hospital();
        hospital.setCodigoHospital(1L);
        hospital.setCnpj("39651466000192");
        hospital.setNomeFantasia("Hospital Test");
        hospital.setRazaoSocial("Hospital Test");
        hospital.setTipo("PUBLICO");
        final Telefone telefone = new Telefone();
        telefone.setCodigoTelefone(1L);
        hospital.setTelefone(telefone);
        this.hospital = hospital;
        return this;
    }

    public Hospital build() {
        return hospital;
    }

    public HospitalBuilder setCnpj(final String cnpj) {
        hospital.setCnpj(cnpj);
        return this;
    }

    public HospitalBuilder camposNulos() {
        final Hospital hospital = new Hospital();
        hospital.setCodigoHospital(null);
        hospital.setCnpj(null);
        hospital.setNomeFantasia(null);
        hospital.setRazaoSocial(null);
        hospital.setTipo(null);
        this.hospital = hospital;
        return this;
    }

    public HospitalBuilder camposVazios() {
        final Hospital hospital = new Hospital();
        hospital.setCnpj("");
        hospital.setNomeFantasia("");
        hospital.setRazaoSocial("");
        hospital.setTipo("");
        this.hospital = hospital;
        return this;
    }
}
