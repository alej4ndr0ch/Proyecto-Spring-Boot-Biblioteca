package com.alejandrocuxun.webapp.biblioteca.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.alejandrocuxun.webapp.biblioteca.model.Empleado;
import com.alejandrocuxun.webapp.biblioteca.service.EmpleadoService;
 
@Controller
@RestController
@RequestMapping("empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;
 
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        try {
            return ResponseEntity.ok(empleadoService.listarEmpleados());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @GetMapping("/empleado")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@RequestParam Long Id){
        try {
            return ResponseEntity.ok(empleadoService.buscarEmpleadoPorId(Id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
 
    @PostMapping("empleado")
    public ResponseEntity<Map<String, String>> agregarEmpleado(@RequestBody Empleado empleado){
        Map<String, String> response = new HashMap<>();
        try{
            empleadoService.guardarEmpleado(empleado);
            response.put("message", "empleado ha sido creado con éxito ");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message", "Error");
            response.put("err", "Hubo un error al crear el empleado");
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @PutMapping("empleado")
    public ResponseEntity<Map<String, String>> editarEmpleado(@RequestParam Long Id, @RequestBody Empleado empleadoNuevo){
        Map<String, String> response = new HashMap<>();
        try{
            Empleado empleado = empleadoService.buscarEmpleadoPorId(Id);
            empleado.setNombre(empleadoNuevo.getNombre());
            empleado.setApellido(empleadoNuevo.getApellido());
            empleado.setTelefono(empleadoNuevo.getTelefono());
            empleado.setDireccion(empleadoNuevo.getDireccion());
            empleado.setDpi(empleadoNuevo.getDpi());
            empleadoService.guardarEmpleado(empleado);
            response.put("message", "El empleado se ha Modificado con exito");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message", "Error");
            response.put("err", "Hubo un error al Modificar el empleado");
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @DeleteMapping("/libro")
    public ResponseEntity<Map<String, String>> eliminarEmpleado(@RequestParam Long id){
        Map<String, String> response = new HashMap<>();
        try{
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("message", "El empleado se ha eliminado correctamente");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message", "Error");
            response.put("err", "Hubo un error al eliminar el empleado");
            return ResponseEntity.badRequest().body(response);
 
        }
    }
}