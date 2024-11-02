package com.gestion.empleados.gestion_empleados_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.gestion_empleados_back.model.Empleado;
import com.gestion.empleados.gestion_empleados_back.model.Exceptions.ResourceNotFoundException;
import com.gestion.empleados.gestion_empleados_back.repository.EmpleadoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
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

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Long id) {
        Empleado employee = _empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun empleado"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> updateEmployee(@PathVariable Long id, @RequestBody Empleado detailsEmployee) {
        Empleado employee = _empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun empleado"));
        employee.setNombre(detailsEmployee.getNombre());
        employee.setApellido(detailsEmployee.getApellido());
        employee.setEmail(detailsEmployee.getEmail());

        Empleado employeeUpdated = _empleadoRepository.save(employee);
        return ResponseEntity.ok(employeeUpdated);
    }

    @DeleteMapping("/empleados/{id}")
    public List<Empleado> deleteEmployee(@PathVariable long id) {
        Empleado employee = _empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist id: " + id));
        _empleadoRepository.delete(employee);
        List<Empleado> newListEmpleados = _empleadoRepository.findAll();
        return newListEmpleados;
    }
}
