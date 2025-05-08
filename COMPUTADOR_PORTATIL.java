public class COMPUTADOR_PORTATIL {

    private String Serial;
    private String Marca;
    private float Tamaño;
    private float Precio;
    private String Sistema_Operativo;
    private String Procesador;

    public COMPUTADOR_PORTATIL() {

    }

    public COMPUTADOR_PORTATIL(String serial, String marca, float tamaño, float precio, String sistema_operativo, String procesador) {

        Serial = serial;
        Marca = marca;
        Tamaño = tamaño;
        Precio = precio;
        Sistema_Operativo = sistema_operativo;
        Procesador = procesador;

    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public float getTamaño() {
        return Tamaño;
    }

    public void setTamaño(float tamaño) {
        Tamaño = tamaño;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getSistema_Operativo() {
        return Sistema_Operativo;
    }

    public void setSistema_Operativo(String sistema_Operativo) {
        Sistema_Operativo = sistema_Operativo;
    }

    public String getProcesador() {
        return Procesador;
    }

    public void setProcesador(String procesador) {
        Procesador = procesador;
    }

}
