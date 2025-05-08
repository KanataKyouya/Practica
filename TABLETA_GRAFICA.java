public class TABLETA_GRAFICA {

    private String Serial;
    private String Marca;
    private float Tamaño;
    private float Precio;
    private String Almacenamiento;
    private float Peso;

    public TABLETA_GRAFICA() {

    }

    public TABLETA_GRAFICA(String serial, String marca, float tamaño, float precio, String almacenamiento, float peso) {

        Serial = serial;
        Marca = marca;
        Tamaño = tamaño;
        Precio = precio;
        Almacenamiento = almacenamiento;
        Peso = peso;

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

    public String getAlmacenamiento() {
        return Almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        Almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        Peso = peso;
    }

}
