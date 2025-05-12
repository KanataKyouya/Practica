import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Proceso {
    
    Registros reg = new Registros();
    clsGenerales cg = new clsGenerales();

    public void Menu() {
        
        ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria = reg.Importar_Estudiantes_Ingenieria();
        ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño = reg.Importar_Estudiantes_Diseño();
        ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores = reg.Importar_Computador_Portatil();
        ArrayList<TABLETA_GRAFICA> Lista_Tabletas = reg.Importar_Tableta_Grafica();

        boolean continuar = true;

        do {

            int opt = Validar_Opcion_Menu_General();

            switch (opt) {

                case 1:
    
                    Menu_Interno(Lista_Computadores, Lista_Estudiantes_Ingenieria);
                    
                    break;
    
                case 2:

                    boolean esTableta = true;
                    Menu_Interno(Lista_Tabletas, Lista_Estudiantes_Diseño, esTableta);
    
                    break;
            
                case 3: 
    
                    Imprimir_Inventario(Lista_Computadores, Lista_Tabletas);
    
                    break;
    
                case 4:
                    
                    cg.Mensaje("Programa finalizado");
                    continuar = false;

                    break;
                    
            }
        
        }

        while(continuar == true);
        
        reg.Exportar_Estudiante_Ingenieria(Lista_Estudiantes_Ingenieria);
        reg.Exportar_Estudiante_Diseño(Lista_Estudiantes_Diseño);
        reg.Exportar_Computador(Lista_Computadores);
        reg.Exportar_Tableta(Lista_Tabletas);

    }

    public int Validar_Opcion_Menu_General() {

        try {

            int numero = Integer.parseInt(JOptionPane.showInputDialog("Sistema de prestamos\n" +
                                                                        "1) Estudiante Ingenieria\n" +
                                                                        "2) Estudiante Diseño\n" +
                                                                        "3) Imprimir inventario total\n" +
                                                                        "4) Salir del programa"));
    
            if (numero < 0 || numero > 4) {

                cg.Mensaje("Por favor, ingrese una opcion valida");

                return Validar_Opcion_Menu_General();

            }
    
            return numero;
    
        }
        
        catch (Exception e) {

            cg.Mensaje("Error, tipo de dato no válido. Por favor, ingrese número valido");

            return Validar_Opcion_Menu_General();

        }

    }

    public int Validar_Opcion_Menu_1_5(String Texto) {

        try {

            int numero = Integer.parseInt(JOptionPane.showInputDialog(Texto));
    
            if (numero < 0 || numero > 5) {

                cg.Mensaje("Por favor, ingrese una opcion valida");

                return Validar_Opcion_Menu_1_5(Texto);

            }
    
            return numero;
    
        }
        
        catch (Exception e) {

            cg.Mensaje("Error, tipo de dato no válido. Por favor, ingrese número valido");

            return Validar_Opcion_Menu_1_5(Texto);

        }

    }

    private int Validar_1_2(String Texto) {

        try {

            int opt = Integer.parseInt(JOptionPane.showInputDialog(Texto));
    
            if (opt < 0 || opt > 2) {

                cg.Mensaje("Por favor, ingrese una opcion valida");

                return Validar_1_2(Texto);

            }

            return opt;
    
        }
        
        catch (Exception e) {

            cg.Mensaje("Error, tipo de dato no válido. Por favor, ingrese número valido");

            return Validar_1_2(Texto);

        }

    }

    private void Menu_Interno(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {
        
        boolean continuar = true;
        String txt = "Buscar por:\n 1) Cedula\n2)Serial";

        do {

            int opt = Validar_Opcion_Menu_1_5("Estudiante de ingenieria\n" +
                                                "1) Registrar prestamo de equipo\n" +
                                                "2) Modificar prestamo de equipo\n" +
                                                "3) Devolucion de equipo\n" +
                                                "4) Buscar equipo\n" +
                                                "5) Volver al menu principal");

            switch (opt) {

                case 1:

                    Lista_Estudiantes_Ingenieria = Registrar_Prestamo(Lista_Computadores, Lista_Estudiantes_Ingenieria);
                    
                    break;

                case 2:

                    if (Validar_1_2(txt) == 1 ) {
                    
                        String Cedula = cg.leerCadena3("Ingrese la cedula:");
                        Modificar_Prestamo(Cedula, Lista_Computadores, Lista_Estudiantes_Ingenieria);

                    }

                    else {

                        String Serial = cg.leerCadena3("Ingrese el serial:");
                        Modificar_Prestamo(Lista_Computadores, Serial, Lista_Estudiantes_Ingenieria);  

                    }

                    break;
            
                case 3: 

                    if (Validar_1_2(txt) == 1 ) {
                            
                        String Cedula = cg.leerCadena3("Ingrese la cedula:");
                        Lista_Estudiantes_Ingenieria = Devolver_Prestamo(Cedula, Lista_Computadores, Lista_Estudiantes_Ingenieria);

                    }

                    else {

                        String Serial = cg.leerCadena3("Ingrese el serial:");
                        Devolver_Prestamo(Lista_Computadores, Serial, Lista_Estudiantes_Ingenieria);  

                    }

                    break;

                case 4:

                    if (Validar_1_2(txt) == 1 ) {
                        
                        String Cedula = cg.leerCadena3("Ingrese la cedula:");
                        Buscar_Equipo(Cedula, Lista_Estudiantes_Ingenieria);

                    }

                    else {

                        String Serial = cg.leerCadena3("Ingrese el serial:");
                        Buscar_Equipo(Lista_Estudiantes_Ingenieria, Serial);  

                    }

                    break;

                case 5:

                    cg.Mensaje("Volviendo al menu principal");
                    continuar = false; 

                    break;

            }
        
        }

        while(continuar == true);

    }

    private ArrayList<ESTUDIANTE_INGENIERIA> Registrar_Prestamo(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {

        ESTUDIANTE_INGENIERIA estudiante = new ESTUDIANTE_INGENIERIA();
        String Cedula = cg.leerCadena3("Ingrese la cedula del estudiante: "), Serial;

        if (ValidarExistencia_Estudiante(Lista_Estudiantes_Ingenieria, Cedula)) {
            
            cg.Mensaje("Ya hay un prestamo registrado con esta cedula");
            return Lista_Estudiantes_Ingenieria;

        }

        estudiante.setCedula(Cedula);
        estudiante.setNombre(cg.leerCadena4("Ingrese el nombre: "));
        estudiante.setApellido(cg.leerCadena4("Ingrese el apellido: "));
        estudiante.setTelefono(cg.leerCadena3("Ingrese el telefono: "));
        estudiante.setSemestre_Actual(cg.leerEnteroPosMy0("Ingrese el semestre actual: "));
        estudiante.setPromedio_Acomulado(cg.leerRealPos_f("Ingrese el promedio acomulado: "));

        do {

            Serial = cg.leerCadena3("Ingrese el serial: ");
            
            if (ValidarExistencia(Serial, Lista_Computadores)) {

                if (ValidarExistencia(Lista_Estudiantes_Ingenieria, Serial)) {

                    cg.Mensaje("El computador de este serial ya esta en prestamo, ingrese otro");

                }

            }

            else {

                cg.Mensaje("No existe computador por ese serial");

            }

        }

        while(!ValidarExistencia(Serial, Lista_Computadores) || ValidarExistencia(Lista_Estudiantes_Ingenieria, Serial));

        estudiante.setSerial(Serial);

        Lista_Estudiantes_Ingenieria.add(estudiante);
        cg.Mensaje("Computador Portátil agregado.");
    
        return Lista_Estudiantes_Ingenieria;

    }

    private boolean ValidarExistencia_Estudiante(ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria, String Cedula) {

        for (ESTUDIANTE_INGENIERIA estudiante : Lista_Estudiantes_Ingenieria) {

            if (estudiante.getCedula().equals(Cedula)) {

                return true;

            }

        }

        return false;        

    }

    private boolean ValidarExistencia(String Serial, ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores) {

        for (COMPUTADOR_PORTATIL computador : Lista_Computadores) {

            if (computador.getSerial().equals(Serial)) {

                return true;

            }

        }

        return false;        

    }

    private boolean ValidarExistencia(ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria, String Cedula) {

        for (ESTUDIANTE_INGENIERIA estudiante : Lista_Estudiantes_Ingenieria) {

            if (estudiante.getCedula().equals(Cedula)) {

                return true;

            }

        }

        return false;        

    }

    private ArrayList<ESTUDIANTE_INGENIERIA> Modificar_Prestamo(String cedula, ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {

        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Ingenieria.size(); i++) {
            
            ESTUDIANTE_INGENIERIA estudiante = Lista_Estudiantes_Ingenieria.get(i);

            if (estudiante.getCedula().equals(cedula)) {

                encontrado = true;
                
                estudiante.setNombre(cg.leerCadena4("Ingrese el nuevo nombre del prestamista(Antes " + estudiante.getNombre() + "):"));
                estudiante.setApellido(cg.leerCadena4("Ingrese el nuevo apellido del prestamista(Antes " + estudiante.getApellido() + "):"));
                estudiante.setTelefono(cg.leerCadena3("Ingrese el nuevo telefono del prestamista(Antes " + estudiante.getTelefono() + "):"));
                estudiante.setSemestre_Actual(cg.leerEnteroPos("Ingrese el nuevo semestre actual del prestamista(Antes " + estudiante.getSemestre_Actual() + "):"));
                estudiante.setPromedio_Acomulado(cg.leerReal_f("Ingrese el nuevo promedio acomulado del prestamista(Antes " + estudiante.getPromedio_Acomulado() + "):"));

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Ingenieria;

        

    }

    private ArrayList<ESTUDIANTE_INGENIERIA> Modificar_Prestamo(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, String serial, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {

        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Ingenieria.size(); i++) {
            
            ESTUDIANTE_INGENIERIA estudiante = Lista_Estudiantes_Ingenieria.get(i);

            if (estudiante.getCedula().equals(serial)) {

                encontrado = true;
                
                estudiante.setNombre(cg.leerCadena4("Ingrese el nuevo nombre del prestamista(Antes " + estudiante.getNombre() + "):"));
                estudiante.setApellido(cg.leerCadena4("Ingrese el nuevo apellido del prestamista(Antes " + estudiante.getApellido() + "):"));
                estudiante.setTelefono(cg.leerCadena3("Ingrese el nuevo telefono del prestamista(Antes " + estudiante.getTelefono() + "):"));
                estudiante.setSemestre_Actual(cg.leerEnteroPos("Ingrese el nuevo semestre actual del prestamista(Antes " + estudiante.getSemestre_Actual() + "):"));
                estudiante.setPromedio_Acomulado(cg.leerReal_f("Ingrese el nuevo promedio acomulado del prestamista(Antes " + estudiante.getPromedio_Acomulado() + "):"));

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Ingenieria;


    }

    private ArrayList<ESTUDIANTE_INGENIERIA> Devolver_Prestamo(String cedula, ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {
        
        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Ingenieria.size(); i++) {
            
            ESTUDIANTE_INGENIERIA estudiante = Lista_Estudiantes_Ingenieria.get(i);

            if (estudiante.getCedula().equals(cedula)) {

                encontrado = true;
                Lista_Estudiantes_Ingenieria.remove(i);

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Ingenieria;

    }

    private ArrayList<ESTUDIANTE_INGENIERIA> Devolver_Prestamo(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, String serial, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {
        
        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Ingenieria.size(); i++) {
            
            ESTUDIANTE_INGENIERIA estudiante = Lista_Estudiantes_Ingenieria.get(i);

            if (estudiante.getSerial().equals(serial)) {

                encontrado = true;
                Lista_Estudiantes_Ingenieria.remove(i);

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Ingenieria;

    }

    private void Buscar_Equipo(ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria, String Serial) {

        boolean encontrado = false;

        for (ESTUDIANTE_INGENIERIA estudiante : Lista_Estudiantes_Ingenieria) {

            if (estudiante.getSerial().equals(Serial)) {

                encontrado = true;

                cg.Mensaje("\nCedula: " + estudiante.getCedula() +
                        "\nNombre: " + estudiante.getNombre() +
                        "\nApellido: " + estudiante.getApellido() +
                        "\nTelefono: " + estudiante.getTelefono() +
                        "\nSemestre Actual: " + estudiante.getSemestre_Actual() +
                        "\nPromedio Acomulado: " + estudiante.getPromedio_Acomulado() +
                        "\nSerial: " + estudiante.getSerial() + "\n");

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }

    }

    private void Buscar_Equipo(String Cedula, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {

        boolean encontrado = false;

        for (ESTUDIANTE_INGENIERIA estudiante : Lista_Estudiantes_Ingenieria) {

            if (estudiante.getCedula().equals(Cedula)) {

                encontrado = true;

                cg.Mensaje("\nCedula: " + estudiante.getCedula() +
                        "\nNombre: " + estudiante.getNombre() +
                        "\nApellido: " + estudiante.getApellido() +
                        "\nTelefono: " + estudiante.getTelefono() +
                        "\nSemestre Actual: " + estudiante.getSemestre_Actual() +
                        "\nPromedio Acomulado: " + estudiante.getPromedio_Acomulado() +
                        "\nSerial: " + estudiante.getSerial() + "\n");

            }

        }

        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con esta cedula");

        }      

    }

    private void Menu_Interno(ArrayList<TABLETA_GRAFICA> Lista_Tabletas, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {
    
        boolean continuar = true;
    
        String txt = "Buscar por:\n 1) Cedula\n2)Serial";

        do {

            int opt = Validar_Opcion_Menu_1_5("Estudiante de diseño\n" +
                                                "1) Registrar prestamo de equipo\n" +
                                                "2) Modificar prestamo de equipo\n" +
                                                "3) Devolucion de equipo\n" +
                                                "4) Buscar equipo\n" +
                                                "5) Volver al menu principal");

            switch (opt) {

                case 1:

                    Lista_Estudiantes_Diseño = Registrar_Prestamo(Lista_Tabletas, Lista_Estudiantes_Diseño, esTableta);
                    
                    break;

                case 2:

                    if (Validar_1_2(txt) == 1 ) {
                    
                        String Cedula = cg.leerCadena3("Ingrese la cedula:");
                        Modificar_Prestamo(Cedula, Lista_Tabletas, Lista_Estudiantes_Diseño, esTableta);

                    }

                    else {

                        String Serial = cg.leerCadena3("Ingrese el serial:");
                        Modificar_Prestamo(Lista_Tabletas, Serial, Lista_Estudiantes_Diseño, esTableta);  

                    }

                    break;
            
                case 3: 

                    if (Validar_1_2(txt) == 1 ) {
                            
                        String Cedula = cg.leerCadena3("Ingrese la cedula:");
                        Lista_Estudiantes_Diseño = Devolver_Prestamo(Cedula, Lista_Tabletas, Lista_Estudiantes_Diseño, esTableta);

                    }

                    else {

                        String Serial = cg.leerCadena3("Ingrese el serial:");
                        Devolver_Prestamo(Lista_Tabletas, Serial, Lista_Estudiantes_Diseño, esTableta);  

                    }

                    break;

                case 4:

                    if (Validar_1_2(txt) == 1 ) {
                        
                        String Cedula = cg.leerCadena3("Ingrese la cedula:");
                        Buscar_Equipo(Cedula, Lista_Estudiantes_Diseño, esTableta);

                    }

                    else {

                        String Serial = cg.leerCadena3("Ingrese el serial:");
                        Buscar_Equipo(Lista_Estudiantes_Diseño, Serial, esTableta);  

                    }

                    break;

                case 5:

                    cg.Mensaje("Volviendo al menu principal");
                    continuar = false; 

                    break;

            }
            
        }
    
        while(continuar == true);
    
    }
    
    private ArrayList<ESTUDIANTE_DISENO> Registrar_Prestamo(ArrayList<TABLETA_GRAFICA> Lista_Tabletas, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {

        ESTUDIANTE_DISENO estudiante = new ESTUDIANTE_DISENO();
        String Cedula = cg.leerCadena3("Ingrese la cedula del estudiante: "), Serial;

        if (ValidarExistencia_Estudiante(Lista_Estudiantes_Diseño, Cedula, esTableta)) {
            
            cg.Mensaje("Ya hay un prestamo registrado con esta cedula");
            return Lista_Estudiantes_Diseño;

        }

        estudiante.setCedula(Cedula);
        estudiante.setNombre(cg.leerCadena4("Ingrese el nombre: "));
        estudiante.setApellido(cg.leerCadena4("Ingrese el apellido: "));
        estudiante.setTelefono(cg.leerCadena3("Ingrese el telefono: "));
        
        int opt = Validar_1_2("Ingrese la nueva modalidad del prestamista(Antes " + estudiante.getModalidad() + "):");
        String Modalidad = (opt == 1) ? "Virtual": "Presencial";

        estudiante.setModalidad(cg.leerCadena3(Modalidad));
        estudiante.setCantidad_Asignaturas(cg.leerEnteroPos("Ingrese la cantidad de asignaturas: "));

        do {

            Serial = cg.leerCadena3("Ingrese el serial: ");
            
            if (ValidarExistencia(Serial, Lista_Tabletas, esTableta)) {

                if (ValidarExistencia(Lista_Estudiantes_Diseño, Serial, esTableta)) {

                    cg.Mensaje("El computador de este serial ya esta en prestamo, ingrese otro");

                }

            }

            else {

                cg.Mensaje("No existe computador por ese serial");

            }

        }

        while(!ValidarExistencia(Serial, Lista_Tabletas, esTableta) || ValidarExistencia(Lista_Estudiantes_Diseño, Serial, esTableta));

        estudiante.setSerial(Serial);

        Lista_Estudiantes_Diseño.add(estudiante);
        cg.Mensaje("Computador Portátil agregado.");
    
        return Lista_Estudiantes_Diseño;

    }

    private boolean ValidarExistencia_Estudiante(ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, String Cedula, boolean esTableta) {

        for (ESTUDIANTE_DISENO estudiante : Lista_Estudiantes_Diseño) {

            if (estudiante.getCedula().equals(Cedula)) {

                return true;

            }

        }

        return false;        

    }

    private boolean ValidarExistencia(String Serial, ArrayList<TABLETA_GRAFICA> Lista_Tabletas, boolean esTableta) {

        for (TABLETA_GRAFICA computador : Lista_Tabletas) {

            if (computador.getSerial().equals(Serial)) {

                return true;

            }

        }

        return false;        

    }

    private boolean ValidarExistencia(ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, String Cedula, boolean esTableta) {

        for (ESTUDIANTE_DISENO estudiante : Lista_Estudiantes_Diseño) {

            if (estudiante.getCedula().equals(Cedula)) {

                return true;

            }

        }

        return false;        

    }

    private ArrayList<ESTUDIANTE_DISENO> Modificar_Prestamo(String cedula, ArrayList<TABLETA_GRAFICA> Lista_Tabletas, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {

        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Diseño.size(); i++) {
            
            ESTUDIANTE_DISENO estudiante = Lista_Estudiantes_Diseño.get(i);

            if (estudiante.getCedula().equals(cedula)) {

                encontrado = true;
                
                estudiante.setNombre(cg.leerCadena4("Ingrese el nuevo nombre del prestamista(Antes " + estudiante.getNombre() + "):"));
                estudiante.setApellido(cg.leerCadena4("Ingrese el nuevo apellido del prestamista(Antes " + estudiante.getApellido() + "):"));
                estudiante.setTelefono(cg.leerCadena3("Ingrese el nuevo telefono del prestamista(Antes " + estudiante.getTelefono() + "):"));

                int opt = Validar_1_2("Ingrese la nueva modalidad del prestamista(Antes " + estudiante.getModalidad() + "):");
                String Modalidad = (opt == 1) ? "Virtual": "Presencial";

                estudiante.setModalidad(cg.leerCadena3(Modalidad));
                estudiante.setCantidad_Asignaturas(cg.leerEnteroPos("Ingrese la nueva cantidad de asignaturas del prestamista(Antes " + estudiante.getCantidad_Asignaturas() + "):"));

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Diseño;

        

    }

    private ArrayList<ESTUDIANTE_DISENO> Modificar_Prestamo(ArrayList<TABLETA_GRAFICA> Lista_Tabletas, String serial, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {

        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Diseño.size(); i++) {
            
            ESTUDIANTE_DISENO estudiante = Lista_Estudiantes_Diseño.get(i);

            if (estudiante.getCedula().equals(serial)) {

                encontrado = true;
                
                estudiante.setNombre(cg.leerCadena4("Ingrese el nuevo nombre del prestamista(Antes " + estudiante.getNombre() + "):"));
                estudiante.setApellido(cg.leerCadena4("Ingrese el nuevo apellido del prestamista(Antes " + estudiante.getApellido() + "):"));
                estudiante.setTelefono(cg.leerCadena3("Ingrese el nuevo telefono del prestamista(Antes " + estudiante.getTelefono() + "):"));
                
                int opt = Validar_1_2("Ingrese la nueva modalidad del prestamista(Antes " + estudiante.getModalidad() + "):");
                String Modalidad = (opt == 1) ? "Virtual": "Presencial";

                estudiante.setModalidad(cg.leerCadena3(Modalidad));
                estudiante.setCantidad_Asignaturas(cg.leerEnteroPos("Ingrese la nueva cantidad de asignaturas del prestamista(Antes " + estudiante.getCantidad_Asignaturas() + "):"));

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Diseño;


    }

    private ArrayList<ESTUDIANTE_DISENO> Devolver_Prestamo(String cedula, ArrayList<TABLETA_GRAFICA> Lista_Tabletas, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {
        
        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Diseño.size(); i++) {
            
            ESTUDIANTE_DISENO estudiante = Lista_Estudiantes_Diseño.get(i);

            if (estudiante.getCedula().equals(cedula)) {

                encontrado = true;
                Lista_Estudiantes_Diseño.remove(i);

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Diseño;

    }

    private ArrayList<ESTUDIANTE_DISENO> Devolver_Prestamo(ArrayList<TABLETA_GRAFICA> Lista_Tabletas, String serial, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {
        
        boolean encontrado = false;

        for (int i = 0; i < Lista_Estudiantes_Diseño.size(); i++) {
            
            ESTUDIANTE_DISENO estudiante = Lista_Estudiantes_Diseño.get(i);

            if (estudiante.getSerial().equals(serial)) {

                encontrado = true;
                Lista_Estudiantes_Diseño.remove(i);

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Estudiantes_Diseño;

    }

    private void Buscar_Equipo(ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, String Serial, boolean esTableta) {

        boolean encontrado = false;

        for (ESTUDIANTE_DISENO estudiante : Lista_Estudiantes_Diseño) {

            if (estudiante.getSerial().equals(Serial)) {

                encontrado = true;

                cg.Mensaje("\nCedula: " + estudiante.getCedula() +
                        "\nNombre: " + estudiante.getNombre() +
                        "\nApellido: " + estudiante.getApellido() +
                        "\nTelefono: " + estudiante.getTelefono() +
                        "\nModalidad: " + estudiante.getModalidad() +
                        "\nCantidad de Asignaturas: " + estudiante.getCantidad_Asignaturas() +
                        "\nSerial: " + estudiante.getSerial() + "\n");

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }

    }

    private void Buscar_Equipo(String Cedula, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {

        boolean encontrado = false;

        for (ESTUDIANTE_DISENO estudiante : Lista_Estudiantes_Diseño) {

            if (estudiante.getCedula().equals(Cedula)) {

                encontrado = true;

                cg.Mensaje("\nCedula: " + estudiante.getCedula() +
                        "\nNombre: " + estudiante.getNombre() +
                        "\nApellido: " + estudiante.getApellido() +
                        "\nTelefono: " + estudiante.getTelefono() +
                        "\nModalidad: " + estudiante.getModalidad() +
                        "\nCantidad de Asignaturas: " + estudiante.getCantidad_Asignaturas() +
                        "\nSerial: " + estudiante.getSerial() + "\n");

            }

        }

        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con esta cedula");

        }      

    }

    private void Imprimir_Inventario(ArrayList<COMPUTADOR_PORTATIL> computador, ArrayList<TABLETA_GRAFICA> tableta) {

        cg.MensajeLargo(Mostrar_Lista_Computadores(computador) + Mostrar_Lista_Tableta(tableta));

    }

    public String Mostrar_Lista_Computadores(ArrayList<COMPUTADOR_PORTATIL> computador) {

        String TextoComputador = "Inventario Computadores Portatiles: ";

        for (COMPUTADOR_PORTATIL r : computador) {

            TextoComputador += "\nSerial: " + r.getSerial() +
                        "\nMarca: " + r.getMarca() +
                        "\nTamaño: " + r.getTamaño() +
                        "\nPrecio: " + r.getPrecio() +
                        "\nSistema Operativo: " + r.getSistema_Operativo() +
                        "\nProcesador: " + r.getProcesador() + "\n";

        }

        return TextoComputador;

    }

    public String Mostrar_Lista_Tableta(ArrayList<TABLETA_GRAFICA> tableta) {

        String TextoTableta = "\nInventario Tabletas Graficas: ";

        for (TABLETA_GRAFICA r : tableta) {

            TextoTableta += "\nSerial: " + r.getSerial() +
                        "\nMarca: " + r.getMarca() +
                        "\nTamaño: " + r.getTamaño() +
                        "\nPrecio: " + r.getPrecio() +
                        "\nAlmacenamiento: " + r.getAlmacenamiento() +
                        "\nPeso: " + r.getPeso() + "\n";

        }

        return TextoTableta;

    }

}
