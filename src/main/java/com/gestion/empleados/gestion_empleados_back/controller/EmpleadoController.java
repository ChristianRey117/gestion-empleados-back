package com.gestion.empleados.gestion_empleados_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.gestion_empleados_back.model.Empleado;
import com.gestion.empleados.gestion_empleados_back.repository.EmpleadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository _empleadoRepository;

    @GetMapping("/empleados")
    public List<Empleado> listEmpleados() {
        return _empleadoRepository.findAll();
    }
    
}
