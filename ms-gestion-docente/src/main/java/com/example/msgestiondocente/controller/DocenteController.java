package com.example.msgestiondocente.controller;




import com.example.msgestiondocente.entity.Docente;
import com.example.msgestiondocente.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/docente")
public class DocenteController {
    @Autowired
    private DocenteService docenteService;

    @GetMapping
    ResponseEntity<List<Docente>> lista(){
        return ResponseEntity.ok(docenteService.lista());
    }
    @PostMapping
    ResponseEntity<Docente> guardar(@RequestBody Docente docente) {
        return ResponseEntity.ok(docenteService.guardar((docente)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Docente> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(docenteService.buscarPorId(id).get());

    }

    @PutMapping("/{id}")
    ResponseEntity<Docente> actualizar(@PathVariable(required = true) Integer id,
                                       @RequestBody Docente docente){
        docente.setId(id);
        return ResponseEntity.ok(docenteService.actualizar((docente)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Docente>> eleminar(@PathVariable(required = true) Integer id){
        docenteService.eleminar(id);
        return ResponseEntity.ok(docenteService.lista());

    }
}
