public class ESTUDIANTE_DISENO {

    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Modalidad;
    private int Cantidad_Asignaturas;
    private String Serial;

    public ESTUDIANTE_DISENO() {

    }
    
    public ESTUDIANTE_DISENO(String cedula, String nombre, String apellido, String telefono, String modalidad, int cantidad_asignaturas, String serial) {

        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Modalidad = modalidad;
        Cantidad_Asignaturas = cantidad_asignaturas;
        Serial = serial;

    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getModalidad() {
        return Modalidad;
    }

    public void setModalidad(String modalidad) {
        Modalidad = modalidad;
    }

    public int getCantidad_Asignaturas() {
        return Cantidad_Asignaturas;
    }

    public void setCantidad_Asignaturas(int cantidad_Asignaturas) {
        Cantidad_Asignaturas = cantidad_Asignaturas;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

}
