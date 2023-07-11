/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.util.ArrayList;
/**
 *
 * @author JUAN VILCHEZ
 */
class Voto {
    
    private Alumno alumno;
    private ArrayList<Alumno> votos;

    public Voto(){
    }
    
    public Voto(Alumno alumno, ArrayList<Alumno> votos) {
        this.alumno = alumno;
        this.votos = votos;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setVotos(ArrayList<Alumno> votos) {
        this.votos = votos;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public ArrayList<Alumno> getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        return "Voto{" + "alumno=" + alumno + ", votos=" + votos + '}';
    }
}
