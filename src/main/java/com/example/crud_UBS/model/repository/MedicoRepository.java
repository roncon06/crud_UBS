package com.example.crud_UBS.model.repository;

import com.example.crud_UBS.model.domin.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicoRepository extends MongoRepository<Medico, String> {

}
