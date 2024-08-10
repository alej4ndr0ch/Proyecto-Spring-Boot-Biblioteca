package com.alejandrocuxun.webapp.biblioteca.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.alejandrocuxun.webapp.biblioteca.model.Prestamo;
import com.alejandrocuxun.webapp.biblioteca.repository.PrestamoRepository;
 
@Service
public class PrestamoService implements IPrestamoService{
    @Autowired
    PrestamoRepository prestamoRepository;
 
    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
 
    @Override
    public Prestamo guardarPrestamo(Prestamo categoria) {
        return prestamoRepository.save(categoria);
    }
 
    @Override
    public Prestamo buscarPrestamoPorId(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }
 
    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        prestamoRepository.delete(prestamo);
    }
}
 
