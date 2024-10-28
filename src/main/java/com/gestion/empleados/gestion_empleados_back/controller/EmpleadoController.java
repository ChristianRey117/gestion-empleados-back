package com.gestion.empleados.gestion_empleados_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.gestion_empleados_back.model.Empleado;
import com.gestion.empleados.gestion_empleados_back.repository.EmpleadoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository _empleadoRepository;

    @GetMapping("/empleados")
    public List<Empleado> listEmpleados() {
        return _empleadoRepository.findAll();
    }

    @PostMapping("/empleados")
    public Empleado saveEmployees(@RequestBody Empleado employees) {        
        return _empleadoRepository.save(employees);
    }
    
    
}
