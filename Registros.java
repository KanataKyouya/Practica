import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Registros {

    public ArrayList<ESTUDIANTE_INGENIERIA> Importar_Estudiantes_Ingenieria() {

        String rutaArchivo = "Estudiantes_Ingenieria.txt";

        ArrayList<ESTUDIANTE_INGENIERIA> Lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String line;

            ESTUDIANTE_INGENIERIA Estudiante = null;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("Cedula: ")) {

                    if (Estudiante != null) {

                        Lista.add(Estudiante);

                    }
                    
                    Estudiante = new ESTUDIANTE_INGENIERIA();
                    Estudiante.setCedula(line.substring(8));

                }
                
                else if (line.startsWith("Nombre: ")) {

                    if (Estudiante != null) {

                        Estudiante.setNombre(line.substring(8));

                    }

                }
                
                else if (line.startsWith("Apellido: ")) {

                    if (Estudiante != null) {

                        Estudiante.setApellido(line.substring(10));

                    }

                }
                
                else if (line.startsWith("Telefono: ")) {

                    if (Estudiante != null) {

                        Estudiante.setTelefono(line.substring(10));

                    }

                }

                else if (line.startsWith("Semestre Actual: ")) {

                    if (Estudiante != null) {

                        Estudiante.setSemestre_Actual(Integer.parseInt(line.substring(17)));

                    }

                }
                
                else if (line.startsWith("Promedio Acomulado: ")) {

                    if (Estudiante != null) {

                        Estudiante.setPromedio_Acomulado(Float.parseFloat(line.substring(20)));

                    }

                }

                else if (line.startsWith("Serial: ")) {

                    if (Estudiante != null) {

                        Estudiante.setSerial(line.substring(8));

                    }

                }

            }

            if (Estudiante != null) {

                Lista.add(Estudiante);
                
            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();

        }

        return Lista;

    }

    public ArrayList<ESTUDIANTE_DISENO> Importar_Estudiantes_Diseño() {

        String rutaArchivo = "Estudiantes_Diseño.txt";

        ArrayList<ESTUDIANTE_DISENO> Lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String line;

            ESTUDIANTE_DISENO Estudiante = null;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("Cedula: ")) {

                    if (Estudiante != null) {

                        Lista.add(Estudiante);

                    }
                    
                    Estudiante = new ESTUDIANTE_DISENO();
                    Estudiante.setCedula(line.substring(8));

                }
                
                else if (line.startsWith("Nombre: ")) {

                    if (Estudiante != null) {

                        Estudiante.setNombre(line.substring(8));

                    }

                }
                
                else if (line.startsWith("Apellido: ")) {

                    if (Estudiante != null) {

                        Estudiante.setApellido(line.substring(10));

                    }

                }
                
                else if (line.startsWith("Telefono: ")) {

                    if (Estudiante != null) {

                        Estudiante.setTelefono(line.substring(10));

                    }

                }

                else if (line.startsWith("Modalidad: ")) {

                    if (Estudiante != null) {

                        Estudiante.setModalidad(line.substring(11));

                    }

                }
                
                else if (line.startsWith("Cantidad de Asignaturas: ")) {

                    if (Estudiante != null) {

                        Estudiante.setCantidad_Asignaturas(Integer.parseInt(line.substring(25)));

                    }

                }

                else if (line.startsWith("Serial: ")) {

                    if (Estudiante != null) {

                        Estudiante.setSerial(line.substring(8));

                    }

                }

            }

            if (Estudiante != null) {

                Lista.add(Estudiante);
                
            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();

        }

        return Lista;

    }

    public ArrayList<COMPUTADOR_PORTATIL> Importar_Computador_Portatil() {

        String rutaArchivo = "TABLETA_GRAFICA.txt";

        ArrayList<COMPUTADOR_PORTATIL> Lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String line;

            COMPUTADOR_PORTATIL Computador = null;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("Serial: ")) {

                    if (Computador != null) {

                        Lista.add(Computador);

                    }
                    
                    Computador = new COMPUTADOR_PORTATIL();
                    Computador.setSerial(line.substring(8));

                }
                
                else if (line.startsWith("Marca: ")) {

                    if (Computador != null) {

                        Computador.setMarca(line.substring(7));

                    }

                }
                
                else if (line.startsWith("Tama\u00f1o: ")) {

                    if (Computador != null) {

                        Computador.setTamaño(Float.parseFloat(line.substring(7)));

                    }

                }

                else if (line.startsWith("Precio: ")) {

                    if (Computador != null) {

                        Computador.setPrecio(Float.parseFloat(line.substring(8)));

                    }

                }

                else if (line.startsWith("Sistema Operativo: ")) {

                    if (Computador != null) {

                        Computador.setSistema_Operativo(line.substring(19));

                    }

                }

                else if (line.startsWith("Procesador: ")) {

                    if (Computador != null) {

                        Computador.setProcesador(line.substring(12));

                    }

                }

            }

            if (Computador != null) {

                Lista.add(Computador);

            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();

        }

        return Lista;

    }

    public ArrayList<TABLETA_GRAFICA> Importar_Tableta_Grafica() {

        String rutaArchivo = "Tableta_Grafica.txt";

        ArrayList<TABLETA_GRAFICA> Lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String line;

            TABLETA_GRAFICA Tableta = null;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("Serial: ")) {

                    if (Tableta != null) {

                        Lista.add(Tableta);

                    }
                    
                    Tableta = new TABLETA_GRAFICA();
                    Tableta.setSerial(line.substring(8));

                }
                
                else if (line.startsWith("Marca: ")) {

                    if (Tableta != null) {

                        Tableta.setMarca(line.substring(7));

                    }

                }
                
                else if (line.startsWith("Tamaño: ")) {

                    if (Tableta != null) {

                        Tableta.setTamaño(Float.parseFloat(line.substring(7)));

                    }

                }

                else if (line.startsWith("Precio: ")) {

                    if (Tableta != null) {

                        Tableta.setPrecio(Float.parseFloat(line.substring(8)));

                    }

                }

                
                else if (line.startsWith("Almacenamiento: ")) {

                    if (Tableta != null) {

                        Tableta.setAlmacenamiento(line.substring(16));

                    }

                }

                else if (line.startsWith("Peso: ")) {

                    if (Tableta != null) {

                        Tableta.setPeso(Float.parseFloat(line.substring(6)));

                    }

                }
                
                

            }

            if (Tableta != null) {

                Lista.add(Tableta);
                
            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();

        }

        return Lista;

    }

    public void Exportar_Estudiante_Ingenieria(ArrayList<ESTUDIANTE_INGENIERIA> Lista) {

        try (FileWriter escriba = new FileWriter("Estudiantes_Ingenieria.txt")) {

            for (ESTUDIANTE_INGENIERIA item : Lista) {

                escriba.write("Cedula: " + item.getCedula() + "\n");
                escriba.write("Nombre: " + item.getNombre() + "\n");
                escriba.write("Apellido: " + item.getApellido() + "\n");
                escriba.write("Telefono: " + item.getTelefono() + "\n");
                escriba.write("Semestre Actual: " + item.getSemestre_Actual() + "\n");
                escriba.write("Promedio Acomulado: " + item.getPromedio_Acomulado() + "\n");
                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("---------------------------------------\n");

            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();
            
        }

    }
    
    public void Exportar_Estudiante_Diseño(ArrayList<ESTUDIANTE_DISENO> Lista) {

        try (FileWriter escriba = new FileWriter("Estudiantes_Diseño.txt")) {

            for (ESTUDIANTE_DISENO item : Lista) {

                escriba.write("Cedula: " + item.getCedula() + "\n");
                escriba.write("Nombre: " + item.getNombre() + "\n");
                escriba.write("Apellido: " + item.getApellido() + "\n");
                escriba.write("Telefono: " + item.getTelefono() + "\n");
                escriba.write("Modalidad: " + item.getModalidad() + "\n");
                escriba.write("Cantidad de Asignaturas: " + item.getCantidad_Asignaturas() + "\n");
                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("---------------------------------------\n");

            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();
            
        }

    }

    public void Exportar_Computador(ArrayList<COMPUTADOR_PORTATIL> Lista) {

        try (FileWriter escriba = new FileWriter("TABLETA_GRAFICA.txt")) {

            for (COMPUTADOR_PORTATIL item : Lista) {

                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("Marca: " + item.getMarca() + "\n");
                escriba.write("Tamaño: " + item.getTamaño() + "\n");
                escriba.write("Precio: " + item.getPrecio() + "\n");
                escriba.write("Sistema Operativo: " + item.getSistema_Operativo() + "\n");
                escriba.write("Procesador: " + item.getProcesador() + "\n");
                escriba.write("---------------------------------------\n");

            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();
            
        }

    }

    public void Exportar_Tableta(ArrayList<TABLETA_GRAFICA> Lista) {

        try (FileWriter escriba = new FileWriter("Tableta_Grafica.txt")) {

            for (TABLETA_GRAFICA item : Lista) {

                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("Marca: " + item.getMarca() + "\n");
                escriba.write("Tamaño: " + item.getTamaño() + "\n");
                escriba.write("Precio: " + item.getPrecio() + "\n");
                escriba.write("Almacenamiento: " + item.getAlmacenamiento() + "\n");
                escriba.write("Peso: " + item.getPeso() + "\n");
                escriba.write("---------------------------------------\n");

            }

        } 
        
        catch (IOException e) {

            e.printStackTrace();

        }

    }

}
