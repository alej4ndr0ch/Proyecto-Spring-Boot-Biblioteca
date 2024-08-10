package com.alejandrocuxun.webapp.biblioteca.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.alejandrocuxun.webapp.biblioteca.model.Prestamo;
import com.alejandrocuxun.webapp.biblioteca.service.PrestamoService;
 
@Controller
@RestController
@RequestMapping("")
public class PrestamoController {
 
    @Autowired
    PrestamoService prestamoService;
 
    @GetMapping("prestamos")
    public ResponseEntity<List<Prestamo>> listarPrestamos(){
        try{
            return ResponseEntity.ok(prestamoService.listarPrestamos());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @PostMapping("/prestamo")
    public ResponseEntity<Map<String, String>> agregarPrestamo(@RequestParam Prestamo prestamo){
        Map<String, String> response = new HashMap<>();
        try {
            prestamoService.guardarPrestamo(prestamo);
            response.put("message", "Prestamo creada con éxito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al crear el prestamo");
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @PutMapping("/prestamo")
    public ResponseEntity<Map<String, String>> editarprestamo(@RequestParam Long id, @RequestBody Prestamo prestamoNueva){
        Map<String, String> response = new HashMap<>();
        try{
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamo.setCliente(prestamoNueva.getCliente());
            prestamo.setEmpleado(prestamoNueva.getEmpleado());
            prestamo.setFechaDeDevolucion(prestamoNueva.getFechaDeDevolucion());
            prestamo.setFechaDePrestamo(prestamoNueva.getFechaDePrestamo());
            prestamo.setLibros(prestamoNueva.getLibros());
            prestamo.setVigencia(prestamoNueva.getVigencia());
            prestamoService.guardarPrestamo(prestamo);
            response.put("massage", "lacategoria se ha modificado con exito");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message", "Error");
            response.put("err", "Hubo un error al modificar la categoria");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
 