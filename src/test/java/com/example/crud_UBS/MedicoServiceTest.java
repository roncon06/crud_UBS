package com.example.crud_UBS;

import com.example.crud_UBS.model.domin.Medico;
import com.example.crud_UBS.model.repository.MedicoRepository;
import com.example.crud_UBS.service.MedicoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MedicoServiceTest {

    @InjectMocks
    private MedicoService medicoService;

    @Mock
    private MedicoRepository medicoRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMedico() {
        Medico medico = new Medico();
        when(medicoRepository.save(any(Medico.class))).thenReturn(medico);

        Medico result = medicoService.addmedico(new Medico());

        assertNotNull(result);
        verify(medicoRepository, times(1)).save(any(Medico.class));
    }

    @Test
    public void testFindAllMedico() {
        List<Medico> medicoList = new ArrayList<>();
        when(medicoRepository.findAll()).thenReturn(medicoList);

        List<Medico> result = medicoService.findAllMedico();

        assertNotNull(result);
        assertEquals(medicoList, result);
        verify(medicoRepository, times(1)).findAll();
    }

    @Test
    public void testGetMedicoTaskId() {
        String medicoId = "1";
        Medico medico = new Medico();
        when(medicoRepository.findById(medicoId)).thenReturn(Optional.of(medico));

        Medico result = medicoService.getMedicoTaskId(medicoId);

        assertNotNull(result);
        verify(medicoRepository, times(1)).findById(medicoId);
    }


    @Test
    public void testDeleteMedico() {
        String medicoId = "1";

        medicoService.delelemedico(medicoId);

        verify(medicoRepository, times(1)).deleteById(medicoId);
    }
}
