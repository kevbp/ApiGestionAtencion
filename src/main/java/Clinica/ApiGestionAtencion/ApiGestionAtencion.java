package Clinica.ApiGestionAtencion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiGestionAtencion")
public class ApiGestionAtencion {

    @Autowired
    private ServicioGestionAtencion serv;

    @PostMapping("/procesarYGrabar")
    public SalidaAtencion procesarYGrabar(@RequestBody Entrada ent) {
        return serv.grabar(ent);
    }

    @GetMapping("/buscar/{idAte}")
    public SalidaAtencion buscar(@PathVariable Long idAte) {
        return serv.buscar(idAte);
    }
}
