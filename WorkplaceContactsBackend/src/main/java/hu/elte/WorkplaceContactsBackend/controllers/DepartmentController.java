/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Department;
import hu.elte.WorkplaceContactsBackend.repositories.DepartmentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Department>> getAll() {
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @GetMapping(path = "/findByName", consumes = "application/json")
    public ResponseEntity<Iterable<Department>> getByNameContaining(@RequestBody Department department) {
        return ResponseEntity.ok(departmentRepository.findByName(department.getName()));
    }

    //Ide kérek ellenőrzéseket
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Department> post(@RequestBody Department department) {
        Department newDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(newDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> put(@RequestBody Department person, @PathVariable Integer id) {
        Optional<Department> oPerson = departmentRepository.findById(id);
        if (oPerson.isPresent()) {
            person.setId(id);
            return ResponseEntity.ok(departmentRepository.save(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Department> oMessage = departmentRepository.findById(id);
        if (oMessage.isPresent()) {
            departmentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
