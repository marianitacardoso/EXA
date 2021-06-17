package Datos;


public class vdocente {
    
    private int iddocente;
    private String nombre;
    private String apaterno;
    private String amaterno;        
    private String domicilio;
    private String telefono;
    private String correo;
    private String profesion;
    private String antiguedad;

    public vdocente(int iddocente, String nombre, String apaterno, String amaterno, String domicilio, String telefono, String correo, String profesion, String antiguedad) {
        this.iddocente = iddocente;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
        this.profesion = profesion;
        this.antiguedad = antiguedad;
    }

    public vdocente() {
    }

    
    
    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    
    
}
