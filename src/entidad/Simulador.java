/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entidad;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


/**
 *
 * @author JUAN VILCHEZ
 */
public class Simulador {

    private Random random;

    public Simulador() {
        this.random = new Random();
    }
    
    public static void main(String[] args) {
        
        Simulador simulador = new Simulador();
        ArrayList<Alumno> alumnos = simulador.generarAlumnos(20);
        simulador.mostrarAlumnos(alumnos);
        System.out.println("---");
        
        ArrayList<Voto> votos = simulador.votacion(alumnos);      
        System.out.println("mostrar");
        //simulador.mostrarResultados(alumnos);
        simulador.mostrarResultadosVoto(votos);
        System.out.println("---");
        
        simulador.recuentoVotos(alumnos);
    }
    
    public ArrayList<String> generarNombresApellidos(int cantidad) {
        ArrayList<String> nombres = new ArrayList();                
        ArrayList<String> apellidos = new ArrayList();
        ArrayList<String> nombresApellidos = new ArrayList();

        for (int i = 0; i < cantidad; i++) {
            String nombre = "Nombre ".concat(Integer.toString(i));
            String apellido = "Apellido ".concat(Integer.toString(i));
            nombresApellidos.add(nombre + " " + apellido);
        }

        return nombresApellidos;
    }
    
    public ArrayList<String> generarDnis(int cantidad) {
        ArrayList<String> dnis = new ArrayList();
        int rangoDniInicio = 10000000;
        int rangoDniFin = 99999999;

        for (int i = 0; i < cantidad; i++) {
            String dni = Integer.toString(rangoDniInicio + random.nextInt(rangoDniFin - rangoDniInicio));
            dnis.add(dni);
        }

        return dnis;
    }
    
    public ArrayList<Alumno> generarAlumnos(int cantidad) {
        ArrayList<Alumno> alumnos = new ArrayList();
        ArrayList<String> nombresApellidos = generarNombresApellidos(cantidad);
        ArrayList<String> dnis = generarDnis(cantidad);

        for (int i = 0; i < cantidad; i++) {
            Alumno alumno = new Alumno(nombresApellidos.get(i), dnis.get(i));
            alumnos.add(alumno);
        }

        return alumnos;
    }
    
    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombre() + " - DNI: " + alumno.getDni());
        }
    }
    
    public ArrayList<Voto> votacion(ArrayList<Alumno> alumnos) {
        HashSet<Integer> indicesVotados = new HashSet();
        ArrayList<Voto> votos = new ArrayList();

        for (Alumno alumno : alumnos) {
            ArrayList<Alumno> votosAlumno = new ArrayList();
            while (votosAlumno.size() < 3) {
                int indiceVoto = random.nextInt(alumnos.size());
                
                if (indiceVoto != alumnos.indexOf(alumno) && !indicesVotados.contains(indiceVoto)) {
                    
                    Alumno alumnoVotado = alumnos.get(indiceVoto);
                    votosAlumno.add(alumnoVotado);
                    alumnoVotado.incrementarVoto();
                    indicesVotados.add(indiceVoto);
                    //System.out.println(votosAlumno.toString()+ alumnoVotado);
                }
                //System.out.println(indicesVotados.toString());
                indicesVotados.clear();
                //System.out.println(indicesVotados.toString());
            }

            Voto voto = new Voto(alumno, votosAlumno);
            votos.add(voto);
            alumno.incrementarVoto();
            //System.out.println(alumno.getNombre()+" "+votosAlumno.toString());
            
            
            //System.out.println(voto.getAlumno()+" / "+voto.getVotos());
            
        }
        
        return votos;
    }
    
    public void mostrarResultados(ArrayList<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombre() + " - Votos: " + alumno.getCantidadVotos());
            System.out.println("Votó a:");
            for (Alumno voto : alumnos) {
                System.out.println("- " + voto.getNombre());
            }
        }
    }
    
    public void mostrarResultadosVoto(ArrayList<Voto> votos) {
        for (Voto alumno : votos) {
            System.out.println("Nombre: " + alumno.getAlumno().getNombre() + " - Votos: " + alumno.getAlumno().getCantidadVotos());
            System.out.println("Votó a:");
            for (Alumno al  : alumno.getVotos()) {
                System.out.println("- " + al.getNombre());
            }
            System.out.println("");
        }
    }
    
    public void recuentoVotos(ArrayList<Alumno> alumnos) {
        Collections.sort(alumnos, Comparator.comparingInt(a -> a.getCantidadVotos()));
        Collections.reverse(alumnos);

        List<Alumno> facilitadores = alumnos.subList(0, 5);
        List<Alumno> facilitadoresSuplentes = alumnos.subList(5, 10);

        System.out.println("Facilitadores:");
        for (Alumno facilitador : facilitadores) {
            System.out.println("Nombre: " + facilitador.getNombre() + " - Votos: " + facilitador.getCantidadVotos());
        }

        System.out.println("Facilitadores Suplentes:");
        for (Alumno facilitadorSuplente : facilitadoresSuplentes) {
            System.out.println("Nombre: " + facilitadorSuplente.getNombre() + " - Votos: " + facilitadorSuplente.getCantidadVotos());
        }
    }
}
