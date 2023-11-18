package com.example.crud_UBS;

import com.example.crud_UBS.Controller.MedicoController;
import com.example.crud_UBS.model.domin.Medico;
import com.example.crud_UBS.service.MedicoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MedicoControllerTest {

    @InjectMocks
    private MedicoController medicoController;

    @Mock
    private MedicoService medicoService;

    @Test
    public void testCreateMedico() {
        Medico medico = new Medico();
        when(medicoService.addmedico(any(Medico.class))).thenReturn(medico);

        Medico createdMedico = medicoController.createMedico(new Medico());

        assertNotNull(createdMedico);
        verify(medicoService, times(1)).addmedico(any(Medico.class));
    }

    @Test
    public void testGetMedico() {
        List<Medico> medicos = Arrays.asList(new Medico(), new Medico());
        when(medicoService.findAllMedico()).thenReturn(medicos);

        List<Medico> returnedMedicos = medicoController.getmedico();

        assertNotNull(returnedMedicos);
        assertEquals(2, returnedMedicos.size());
        verify(medicoService, times(1)).findAllMedico();
    }

    @Test
    public void testGetMedicoTaskId() {
        Medico medico = new Medico();
        when(medicoService.getMedicoTaskId(anyString())).thenReturn(medico);

        Medico returnedMedico = medicoController.getMedicoTaskId("1");

        assertNotNull(returnedMedico);
        verify(medicoService, times(1)).getMedicoTaskId("1");
    }

    @Test
    public void testUpdMedico() {
        Medico medico = new Medico();
        when(medicoService.updateTask(any(Medico.class))).thenReturn(medico);

        Medico updatedMedico = medicoController.updMedico(new Medico());

        assertNotNull(updatedMedico);
        verify(medicoService, times(1)).updateTask(any(Medico.class));
    }

    @Test
    public void testDeleteMedico() {
        when(medicoService.delelemedico(anyString())).thenReturn("Deleted");

        String result = medicoController.deleteMedico("1");

        assertNotNull(result);
        assertEquals("Deleted", result);
        verify(medicoService, times(1)).delelemedico("1");
    }
}
