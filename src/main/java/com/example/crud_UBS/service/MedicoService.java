package com.example.crud_UBS.service;

import com.example.crud_UBS.model.domin.Medico;
import com.example.crud_UBS.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

   public Medico addmedico(Medico medico) {
       medico.setId(UUID.randomUUID().toString().split("-")[0]);
       return repository.save(medico);

   }

   public List<Medico> findAllMedico() {
       return repository.findAll();
   }

   public Medico getMedicoTaskId(String medicoId){
       return repository.findById(medicoId).get();
   }


    public Medico updateTask(Medico medicoupd){
//get the existing document from DB
// populate new value from request to existing object/entity/document
        Medico existingTask = repository.findById(medicoupd.getId()).get();
        existingTask.setNome(medicoupd.getNome());
        existingTask.setPaciente(medicoupd.getPaciente());
        existingTask.setCpf(medicoupd.getCpf());
        existingTask.setDataNascimento(medicoupd.getDataNascimento());
        existingTask.setEndereco(medicoupd.getEndereco());
        existingTask.setTelefone(medicoupd.getTelefone());
        existingTask.setDataConsulta(medicoupd.getDataConsulta());
        return repository.save(existingTask);
}

  public String delelemedico(String medicoId){
       repository.deleteById(medicoId);
       return medicoId+"Cadastro medico deletado";

}
    }
