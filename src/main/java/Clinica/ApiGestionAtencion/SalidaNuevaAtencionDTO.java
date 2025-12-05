/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionAtencion;

public class SalidaNuevaAtencionDTO {
    
    private SalidaCitaDTO cit;

    public SalidaNuevaAtencionDTO() {
    }

    public SalidaNuevaAtencionDTO(SalidaCitaDTO cit) {
        this.cit = cit;
    }

    public SalidaCitaDTO getCit() {
        return cit;
    }

    public void setCit(SalidaCitaDTO cit) {
        this.cit = cit;
    }
    
    
}
