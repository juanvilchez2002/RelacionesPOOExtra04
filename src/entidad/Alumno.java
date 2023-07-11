
package entidad;

class Alumno {
    private String nombre;
    private String dni;
    private int cantidadVotos;

    public Alumno() {
    }

    
    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.cantidadVotos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void incrementarVoto() {
        cantidadVotos++;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", dni=" + dni + ", cantidadVotos=" + cantidadVotos + '}';
    }
    
}
