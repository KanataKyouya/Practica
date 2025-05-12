import java.util.ArrayList;

public class Proceso {
    
    Registros reg = new Registros();
    clsGenerales cg = new clsGenerales();

    public void Menu() {
        // prueba xd
        

        ArrayList<ESTUDIANTE_INGENIERIA> Estudiantes_Ingenieria = reg.Importar_Estudiantes_Ingenieria();
        ArrayList<ESTUDIANTE_DISENO> Estudiantes_Diseño = reg.Importar_Estudiantes_Diseño();
        ArrayList<COMPUTADOR_PORTATIL> Computador = reg.Importar_Computador_Portatil();
        ArrayList<TABLETA_GRAFICA> Tableta = reg.Importar_Tableta_Grafica();

        ArrayList<COMPUTADOR_PORTATIL> Lista = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {

            COMPUTADOR_PORTATIL computador = new COMPUTADOR_PORTATIL();

            computador.setSerial(cg.leerCadena("Ingrese el serial:"));
            computador.setMarca(cg.leerCadena("Ingrese la marca:"));
            computador.setTamaño(cg.leerRealPosMy0_f("Ingrese el tamaño:"));
            computador.setPrecio(cg.leerRealPosMy0_f("Ingrese el precio:"));
            computador.setSistema_Operativo(cg.leerCadena("Ingrese el sistema operativo:"));
            computador.setProcesador(cg.leerCadena("Ingrese el procesador:"));

            Lista.add(computador);
            cg.Mensaje("Computador Portátil agregado.");
            
            String agregar = cg.leerCadena2("Agregar mas?:");

            if (agregar.equals("No")) {

                continuar = false;

            }

        }
        
        MostrarLista(Lista);
        

        

        System.out.println("Programa finalizado");

        reg.Exportar_Estudiante_Ingenieria(Estudiantes_Ingenieria);
        reg.Exportar_Estudiante_Diseño(Estudiantes_Diseño);
        reg.Exportar_Computador(Computador);
        reg.Exportar_Tableta(Tableta);

    }

    public void MostrarLista(ArrayList<COMPUTADOR_PORTATIL> cola) {

        String TextoCola = "Cola de Objpersona: ";

        for (COMPUTADOR_PORTATIL r : cola) {

            TextoCola += "\nNombre: " + r.getSerial() +
                        "\nCedula: " + r.getMarca() +
                        "\nEdad: " + r.getTamaño() +
                        "\nAuxilio: " + r.getPrecio() +
                        "\nDesplazado: " + r.getSistema_Operativo() +
                        "\nEstrato: " + r.getProcesador() + "\n";

        }

        cg.Mensaje(TextoCola);

    }

}
