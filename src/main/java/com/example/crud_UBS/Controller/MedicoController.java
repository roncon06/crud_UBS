package com.example.crud_UBS.Controller;


import com.example.crud_UBS.model.domin.Medico;
import com.example.crud_UBS.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    public MedicoService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico createMedico(@RequestBody Medico medico){
        return service.addmedico(medico);
    }

    @GetMapping
    public List<Medico> getmedico() {
        return service.findAllMedico();
    }
    @GetMapping("/{medicoId}")
    public Medico getMedicoTaskId(@PathVariable String medicoId){
        return service.getMedicoTaskId(medicoId);
    }
    @PutMapping
    public Medico updMedico(@RequestBody Medico medico){
        return service.updateTask(medico);

    }

    @DeleteMapping("/{medicoId}")
    public String deleteMedico(@PathVariable String medicoId){
        return service.delelemedico(medicoId);
    }

}
