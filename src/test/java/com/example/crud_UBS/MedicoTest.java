package com.example.crud_UBS;

import com.example.crud_UBS.model.domin.Medico;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.*;

public class MedicoTest {

    @Test
    public void testConstrutores() {
        Medico medico1 = new Medico();
        assertNotNull(medico1);

        Date dataNascimento = new Date(); // ou uma data específica
        Date dataConsulta = new Date();
        Medico medico2 = new Medico("1", "NomeMedico","Lucas roncon", dataNascimento, "12345678901", "EnderecoMedico", "123456789", dataConsulta);
        assertNotNull(medico2);
        assertEquals("1", medico2.getId());
        assertEquals("NomeMedico", medico2.getNome());
        assertEquals("Lucas roncon", medico2.getPaciente());
        assertEquals(dataNascimento, medico2.getDataNascimento());
        assertEquals("12345678901", medico2.getCpf());
        assertEquals("EnderecoMedico", medico2.getEndereco());
        assertEquals("123456789", medico2.getTelefone());
        assertEquals(dataConsulta, medico2.getDataConsulta());
    }

    @Test
    public void testGettersSetters() {
        Medico medico = new Medico();

        medico.setId("2");
        assertEquals("2", medico.getId());

        medico.setNome("NovoNome");
        assertEquals("NovoNome", medico.getNome());

        Date novaDataNascimento = new Date(); // ou uma data específica
        medico.setDataNascimento(novaDataNascimento);
        assertEquals(novaDataNascimento, medico.getDataNascimento());

        medico.setCpf("98765432109");
        assertEquals("98765432109", medico.getCpf());

        medico.setEndereco("NovoEndereco");
        assertEquals("NovoEndereco", medico.getEndereco());

        medico.setTelefone("987654321");
        assertEquals("987654321", medico.getTelefone());
    }

    @Test
    public void testAnotacoesJPA() {
        Field idField = ReflectionUtils.findField(Medico.class, "id");
        assertNotNull(idField);
        assertTrue(idField.isAnnotationPresent(Id.class));
        assertTrue(idField.isAnnotationPresent(GeneratedValue.class));
        assertEquals(GenerationType.IDENTITY, idField.getAnnotation(GeneratedValue.class).strategy());

        // Verificar outras anotações JPA conforme necessário
    }
}

