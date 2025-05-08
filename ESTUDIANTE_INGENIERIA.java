public class ESTUDIANTE_INGENIERIA {
    
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private int Semestre_Actual;
    private float Promedio_Acomulado;
    private String Serial;

    public ESTUDIANTE_INGENIERIA() {

    }
    
    public ESTUDIANTE_INGENIERIA(String cedula, String nombre, String apellido, String telefono, int semestre_actual, float promedio_acomulado, String serial) {

        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Semestre_Actual = semestre_actual;
        Promedio_Acomulado = promedio_acomulado;
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

    public int getSemestre_Actual() {
        return Semestre_Actual;
    }

    public void setSemestre_Actual(int semestre_Actual) {
        Semestre_Actual = semestre_Actual;
    }

    public float getPromedio_Acomulado() {
        return Promedio_Acomulado;
    }

    public void setPromedio_Acomulado(float promedio_Acomulado) {
        Promedio_Acomulado = promedio_Acomulado;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

}
