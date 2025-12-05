/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionAtencion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioGestionAtencion {

    @Autowired
    private RestTemplate resTem;

    public SalidaAtencion grabar(Entrada ent) {

        String urlNueAte = "http://ApiNuevaAtencion/apiNuevaAtencion/salida";
        SalidaNuevaAtencionDTO salAte = resTem.getForObject(urlNueAte, SalidaNuevaAtencionDTO.class);

        Long idCit = salAte.getCit().getId();

        String fec = ent.getFec();
        String hor = ent.getHor();
        String dgn = ent.getDgn();
        String trt = ent.getTrt();
        Long idMed = ent.getIdMed();

        Long idPac = salAte.getCit().getPac().getId();
        String urlHis = "http://ApiGestionHistoria/apiGestionHistoria/buscarPorPaciente/" + idPac;
        SalidaHistoriaDTO his = resTem.getForObject(urlHis, SalidaHistoriaDTO.class);
        Long idHis = his.getIdHis();

        String urlCit = "http://ApiGestionCita/apiGestionCita/buscar/" + idCit;
        SalidaCitaDTO cit = resTem.getForObject(urlCit, SalidaCitaDTO.class);
        idCit = cit.getId();

        String urlMed = "http://ApiMedico/medico/buscar/" + idMed;
        MedicoDTO med = resTem.getForObject(urlMed, MedicoDTO.class);
        idMed = med.getId();

        AtencionDTO ate = new AtencionDTO();
        ate.setFec(fec);
        ate.setHor(hor);
        ate.setIdHis(idHis);
        ate.setIdCit(idCit);
        ate.setDgn(dgn);
        ate.setTrt(trt);
        ate.setIdMed(idMed);

        String urlAte = "http://ApiAtencion/atencion/grabar";
        AtencionDTO ateReg = resTem.postForObject(urlAte, ate, AtencionDTO.class);

        return buscar(ateReg.getId());
    }

    public SalidaAtencion buscar(Long id) {
        String urlBusAte = "http://ApiAtencion/atencion/buscar/" + id;
        AtencionDTO ate = resTem.getForObject(urlBusAte, AtencionDTO.class);

        String urlBusHis = "http://ApiGestionHistoria/apiGestionHistoria/buscar/" + ate.getIdHis();
        String urlBusCit = "http://ApiGestionCita/apiGestionCita/buscar/" + ate.getIdCit();
        String urlBusMed = "http://ApiMedico/medico/buscar/" + ate.getIdMed();

        SalidaHistoriaDTO his = resTem.getForObject(urlBusHis, SalidaHistoriaDTO.class);
        SalidaCitaDTO cit = resTem.getForObject(urlBusCit, SalidaCitaDTO.class);
        MedicoDTO med = resTem.getForObject(urlBusMed, MedicoDTO.class);

        SalidaAtencion salAte = new SalidaAtencion();
        salAte.setIdAte(ate.getId());
        salAte.setFec(ate.getFec());
        salAte.setHor(ate.getHor());
        salAte.setHisPac(his);
        salAte.setCit(cit);
        salAte.setDgn(ate.getDgn());
        salAte.setTrt(ate.getTrt());
        salAte.setMed(med);

        return salAte;
    }
}
