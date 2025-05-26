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

        boolean continuar = true, esTableta = true;

        do {

            int opt = Validar_Opcion_Menu_General();

            switch (opt) {

                case 1:
    
                    Lista_Estudiantes_Ingenieria = Menu_Interno(Lista_Computadores, Lista_Estudiantes_Ingenieria);
                    
                    break;
    
                case 2:

                    Lista_Estudiantes_Diseño = Menu_Interno(Lista_Tabletas, Lista_Estudiantes_Diseño, esTableta);
    
                    break;
            
                case 3: 
    
                    Imprimir_Inventario(Lista_Computadores, Lista_Tabletas);
    
                    break;
    
                case 4:

                    Lista_Computadores = Menu_Inventario(Lista_Computadores);

                    break;

                case 5:

                    Lista_Tabletas = Menu_Inventario(Lista_Tabletas, esTableta);

                    break;

                case 6:
                    
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

            int numero = Integer.parseInt(JOptionPane.showInputDialog("GESTIóN DE PRESTAMO DE EQUIPOS ELECTRÓNICOS SAN JUAN DE DIOS\n\n" +
                                                                        "1) Estudiante Ingenieria\n" +
                                                                        "2) Estudiante Diseño\n" +
                                                                        "3) Imprimir inventario total\n" +
                                                                        "4) Administrar computadores\n" +
                                                                        "5) Administrar tabletas\n" +
                                                                        "6) Salir del programa"));
    
            if (numero < 0 || numero > 6) {

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

    //Para validar menus con 5 opciones

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

    //Para validar menus con 2 opciones

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

    //Menu internos se refiere al menu de la opcion 1 o 2, que son para administrar prestamos de tabletas o de computadores
    //Aqui empiezan los de ingenieria

    private ArrayList<ESTUDIANTE_INGENIERIA> Menu_Interno(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, ArrayList<ESTUDIANTE_INGENIERIA> Lista_Estudiantes_Ingenieria) {
        
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

        return Lista_Estudiantes_Ingenieria;

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

                    cg.Mensaje("El computador de este serial ya esta en prestamo, ingrese otro serial");

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

            cg.Mensaje("No se halló un prestamo con esta cedula");

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

    //Aqui empiezan los de diseño

    private ArrayList<ESTUDIANTE_DISENO> Menu_Interno(ArrayList<TABLETA_GRAFICA> Lista_Tabletas, ArrayList<ESTUDIANTE_DISENO> Lista_Estudiantes_Diseño, boolean esTableta) {
    
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

        return Lista_Estudiantes_Diseño;
    
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

    // Acá empiezan el menu de los computadores

    private ArrayList<COMPUTADOR_PORTATIL> Menu_Inventario(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores) {
        
        boolean continuar = true;
        String Serial = "";

        do {

            int opt = Validar_Opcion_Menu_1_5("Estudiante de ingenieria\n" +
                                                "1) Registrar computador\n" +
                                                "2) Modificar computador\n" +
                                                "3) Eliminar computador\n" +
                                                "4) Buscar computador\n" +
                                                "5) Volver al menu principal");

            switch (opt) {

                case 1:

                    Lista_Computadores = Registrar_Equipo(Lista_Computadores);
                    
                    break;

                case 2:
                    
                    Serial = cg.leerCadena3("Ingrese la serial:");
                    Modificar_Equipo(Serial, Lista_Computadores);

                    break;
            
                case 3:

                    Serial = cg.leerCadena3("Ingrese el serial:");
                    Eliminar_Equipo(Serial, Lista_Computadores);

                    break;

                case 4:
                    
                    Serial = cg.leerCadena3("Ingrese el serial:");
                    Buscar_Equipo2(Lista_Computadores, Serial);  

                    break;

                case 5:

                    cg.Mensaje("Volviendo al menu principal");
                    continuar = false; 

                    break;

            }
        
        }

        while(continuar == true);

        return Lista_Computadores;

    }

    private ArrayList<COMPUTADOR_PORTATIL> Registrar_Equipo(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores) {

        COMPUTADOR_PORTATIL computador = new COMPUTADOR_PORTATIL();
        String Serial = cg.leerCadena3("Ingrese el serial: ");

        if (ValidarExistenciaEquipo(Lista_Computadores, Serial)) {
            
            cg.Mensaje("Ya hay un equipo registrado con este serial");
            return Lista_Computadores;

        }

        computador.setSerial(Serial);
        computador.setMarca(cg.leerCadena4("Ingrese ea marca: "));
        computador.setTamaño(cg.leerRealPosMy0_f("Ingrese el tamaño(Pulgadas): "));
        computador.setPrecio(cg.leerRealPosMy0_f("Ingrese el precio: "));
        computador.setSistema_Operativo(IngresoSistemaOperativo("Ingrese el sistema operativo: \n"));
        computador.setProcesador(IngresoProcesador("Ingrese el procesador: \n"));

        Lista_Computadores.add(computador);
        cg.Mensaje("Computador Portátil agregado.");
    
        return Lista_Computadores;

    }

    private boolean ValidarExistenciaEquipo(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, String Serial) {

        for (COMPUTADOR_PORTATIL computador : Lista_Computadores) {

            if (computador.getSerial().equals(Serial)) {

                return true;

            }

        }

        return false;        

    }

    private ArrayList<COMPUTADOR_PORTATIL> Modificar_Equipo(String Serial, ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores) {

        boolean encontrado = false;

        for (int i = 0; i < Lista_Computadores.size(); i++) {
            
            COMPUTADOR_PORTATIL computador = Lista_Computadores.get(i);

            if (computador.getSerial().equals(Serial)) {

                encontrado = true;
                
                computador.setSerial(Serial);
                computador.setMarca(cg.leerCadena4("Ingrese la marca(Antes " + computador.getMarca() + "): "));
                computador.setTamaño(cg.leerRealPosMy0_f("Ingrese el tamaño(Pulgadas, antes " + computador.getTamaño() + "): "));
                computador.setPrecio(cg.leerRealPosMy0_f("Ingrese el precio(Antes " + computador.getPrecio() + "):"));
                computador.setSistema_Operativo(IngresoSistemaOperativo("Ingrese el sistema operativo(Antes " + computador.getSistema_Operativo() + "): \n"));
                computador.setProcesador(IngresoProcesador("Ingrese el nuevo procesador(Antes " + computador.getProcesador() + ") "));

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_Computadores;

        

    }

    private ArrayList<COMPUTADOR_PORTATIL> Eliminar_Equipo(String Serial, ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores) {
        
        boolean encontrado = false;

        for (int i = 0; i < Lista_Computadores.size(); i++) {
            
            COMPUTADOR_PORTATIL computador = Lista_Computadores.get(i);

            if (computador.getSerial().equals(Serial)) {

                encontrado = true;
                Lista_Computadores.remove(i);

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un equipo con este serial");

        }   

        return Lista_Computadores;

    }

    private void Buscar_Equipo2(ArrayList<COMPUTADOR_PORTATIL> Lista_Computadores, String Serial) {

        boolean encontrado = false;

        for (COMPUTADOR_PORTATIL computador : Lista_Computadores) {

            if (computador.getSerial().equals(Serial)) {

                encontrado = true;

                cg.Mensaje("\nSerial: " + computador.getSerial() +
                        "\nMarca: " + computador.getMarca() +
                        "\nTamaño: " + computador.getTamaño() +
                        "\nPrecio: " + computador.getPrecio() +
                        "\nSistema operativo: " + computador.getSistema_Operativo() +
                        "\nProcesador: " + computador.getProcesador());

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un equipo con ese serial");

        }

    }

    private String IngresoSistemaOperativo(String Texto) {

        try {

            String opt = "";

            int numero = Integer.parseInt(JOptionPane.showInputDialog(Texto +
                                                                        "1) Windows 7\n" +
                                                                        "2) Windows 10\n" +
                                                                        "3) Windows 11"));
    
            if (numero < 0 || numero > 3) {

                cg.Mensaje("Por favor, ingrese una opcion valida");

                return IngresoSistemaOperativo(Texto);

            }
            
    
            switch (numero) {

                case 1:
                    
                    opt =  "Windows 7";

                    break;
            
                case 2:

                    opt =  "Windows 10";

                    break;

                 case 3:

                    opt =  "Windows 11";

                    break;

            }

            return opt;
    
        }
        
        catch (Exception e) {

            cg.Mensaje("Error, tipo de dato no válido. Por favor, ingrese número valido");

            return IngresoSistemaOperativo(Texto);

        }

    }

    private String IngresoProcesador(String Texto) {

        try {

            String opt = "";

            int numero = Integer.parseInt(JOptionPane.showInputDialog(Texto +
                                                                        "1) AMD Ryzen\n" +
                                                                        "2) Intel Core i5"));
    
            if (numero < 0 || numero > 2) {

                cg.Mensaje("Por favor, ingrese una opcion valida");

                return IngresoProcesador(Texto);

            }
    
            switch (numero) {

                case 1:
                    
                    opt = "AMD Ryzen";

                    break;
            
                case 2:

                    opt = "Intel Core i5";

                    break;

            }

            return opt;
    
        }
        
        catch (Exception e) {

            cg.Mensaje("Error, tipo de dato no válido. Por favor, ingrese número valido");

            return IngresoProcesador(Texto);

        }

    }

    // Acá empiezan el menu de las tabletas

    private ArrayList<TABLETA_GRAFICA> Menu_Inventario(ArrayList<TABLETA_GRAFICA> Lista_tabletas, boolean esTableta) {
        
        boolean continuar = true;
        String Serial = "";

        do {

            int opt = Validar_Opcion_Menu_1_5("Estudiante de ingenieria\n" +
                                                "1) Registrar tableta\n" +
                                                "2) Modificar tableta\n" +
                                                "3) Eliminar tableta\n" +
                                                "4) Buscar tableta\n" +
                                                "5) Volver al menu principal");

            switch (opt) {

                case 1:

                    Lista_tabletas = Registrar_Equipo(Lista_tabletas, esTableta);
                    
                    break;

                case 2:
                    
                    Serial = cg.leerCadena3("Ingrese el serial:");
                    Modificar_Equipo(Serial, Lista_tabletas, esTableta);

                    break;
            
                case 3:

                    Serial = cg.leerCadena3("Ingrese el serial:");
                    Eliminar_Equipo(Serial, Lista_tabletas, esTableta);

                    break;

                case 4:
                    
                    Serial = cg.leerCadena3("Ingrese el serial:");
                    Buscar_Equipo2(Lista_tabletas, Serial, esTableta);  

                    break;

                case 5:

                    cg.Mensaje("Volviendo al menu principal");
                    continuar = false; 

                    break;

            }
        
        }

        while(continuar == true);

        return Lista_tabletas;

    }

    private ArrayList<TABLETA_GRAFICA> Registrar_Equipo(ArrayList<TABLETA_GRAFICA> Lista_tabletas, boolean esTableta) {

        TABLETA_GRAFICA tableta = new TABLETA_GRAFICA();
        String Serial = cg.leerCadena3("Ingrese el serial: ");

        if (ValidarExistenciaEquipo(Lista_tabletas, Serial, esTableta)) {
            
            cg.Mensaje("Ya hay un equipo registrado con este serial");
            return Lista_tabletas;

        }

        tableta.setSerial(Serial);
        tableta.setMarca(cg.leerCadena4("Ingrese ea marca: "));
        tableta.setTamaño(cg.leerRealPosMy0_f("Ingrese el tamaño(Pulgadas): "));
        tableta.setPrecio(cg.leerRealPosMy0_f("Ingrese el precio: "));
        tableta.setAlmacenamiento(IngresoAlmacenamiento("Ingrese el almacenamiento: \n"));
        tableta.setPeso(cg.leerRealPosMy0_f("Ingrese el peso: \n"));

        Lista_tabletas.add(tableta);
        cg.Mensaje("tableta Portátil agregado.");
    
        return Lista_tabletas;

    }

    private boolean ValidarExistenciaEquipo(ArrayList<TABLETA_GRAFICA> Lista_tabletaes, String Serial, boolean esTableta) {

        for (TABLETA_GRAFICA tableta : Lista_tabletaes) {

            if (tableta.getSerial().equals(Serial)) {

                return true;

            }

        }

        return false;        

    }

    private ArrayList<TABLETA_GRAFICA> Modificar_Equipo(String Serial, ArrayList<TABLETA_GRAFICA> Lista_tabletas, boolean esTableta) {

        boolean encontrado = false;

        for (int i = 0; i < Lista_tabletas.size(); i++) {
            
            TABLETA_GRAFICA tableta = Lista_tabletas.get(i);

            if (tableta.getSerial().equals(Serial)) {

                encontrado = true;
                
                tableta.setSerial(Serial);
                tableta.setMarca(cg.leerCadena4("Ingrese la marca(Antes " + tableta.getMarca() + "): "));
                tableta.setTamaño(cg.leerRealPosMy0_f("Ingrese el tamaño(Pulgadas, antes " + tableta.getTamaño() + "): "));
                tableta.setPrecio(cg.leerRealPosMy0_f("Ingrese el precio(Antes " + tableta.getPrecio() + "):"));
                tableta.setAlmacenamiento(IngresoAlmacenamiento("Ingrese el nuevo almacenamiento(Antes " + tableta.getAlmacenamiento() + "): \n"));
                tableta.setPeso(cg.leerRealPosMy0_f("Ingrese el nuevo peso(Antes " + tableta.getPeso() + " kg) "));

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un prestamo con este serial");

        }   

        return Lista_tabletas;

        

    }

    private ArrayList<TABLETA_GRAFICA> Eliminar_Equipo(String Serial, ArrayList<TABLETA_GRAFICA> Lista_tabletas, boolean esTableta) {
        
        boolean encontrado = false;

        for (int i = 0; i < Lista_tabletas.size(); i++) {
            
            TABLETA_GRAFICA tableta = Lista_tabletas.get(i);

            if (tableta.getSerial().equals(Serial)) {

                encontrado = true;
                Lista_tabletas.remove(i);

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un equipo con este serial");

        }   

        return Lista_tabletas;

    }

    private void Buscar_Equipo2(ArrayList<TABLETA_GRAFICA> Lista_tabletaes, String Serial, boolean esTableta) {

        boolean encontrado = false;

        for (TABLETA_GRAFICA tableta : Lista_tabletaes) {

            if (tableta.getSerial().equals(Serial)) {

                encontrado = true;

                cg.Mensaje("\nSerial: " + tableta.getSerial() +
                        "\nMarca: " + tableta.getMarca() +
                        "\nTamaño: " + tableta.getTamaño() +
                        "\nPrecio: " + tableta.getPrecio() +
                        "\nAlmacenamiento: " + tableta.getAlmacenamiento() +
                        "\nPeso: " + tableta.getPeso());

            }

        }     
        
        if (encontrado == false) {

            cg.Mensaje("No se halló un equipo con ese serial");

        }

    }

    private String IngresoAlmacenamiento(String Texto) {

        try {

            String opt = "";

            int numero = Integer.parseInt(JOptionPane.showInputDialog(Texto +
                                                                        "1) 256 GB\n" +
                                                                        "2) 512 GB\n" +
                                                                        "3) 1 TB"));
    
            if (numero < 0 || numero > 3) {

                cg.Mensaje("Por favor, ingrese una opcion valida");

                return IngresoAlmacenamiento(Texto);

            }
    
            switch (numero) {

                case 1:
                    
                    opt = "256 GB";

                    break;
            
                case 2:

                    opt = "512 GB";

                    break;

                 case 3:

                    opt = "1 TB";

                    break;

            }

            return opt;
    
        }
        
        catch (Exception e) {

            cg.Mensaje("Error, tipo de dato no válido. Por favor, ingrese número valido");

            return IngresoAlmacenamiento(Texto);

        }

    }

}
