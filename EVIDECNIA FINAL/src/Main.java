import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Registro de usuarios y citas----");
        System.out.println();
        System.out.println("Ingrese el nombre de usuario:");
        scanner.nextLine();
        System.out.println("Ingrese la contraseña:");

        int intentos = 0;
        boolean contrasenaCorrecta = false;

        while (intentos < 3 && !contrasenaCorrecta) {
            String contrasena = scanner.nextLine();
            if (contrasena.equals("admin")) {
                contrasenaCorrecta = true;
            } else {
                intentos++;
                System.out.println("Contraseña incorrecta. Intento " + intentos + "/3. \nIngrese la contraseña:");
            }
        }

        if (contrasenaCorrecta) {
            int numDoctores = 0;
            int numPacientes = 0;
            int numCitas = 0;

            String[] idDoctores = new String[100];
            String[] NombreDoctores = new String[100];
            String[] EspecialidadDoctores = new String[100];
            String[] idPacientes = new String[100];
            String[] NombrePacientes = new String[100];
            String[] idCitas = new String[100];
            String[] FechaCitas = new String[100];
            String[] HoraCitas = new String[100];
            String[] MotivoCitas = new String[100];
            String[] idDoctorCitas = new String[100];
            String[] idPacienteCitas = new String[100];

            // Ingrese el directorio donde se encuentra la carpeta db
            String directorio = "C:\\Users\\Brayan\\IdeaProjects\\RegistroDeUsuarios\\src\\db";
            File pacientesFile = new File(directorio, "pacientes.txt");
            File doctoresFile = new File(directorio, "doctores.txt");
            File citasFile = new File(directorio, "citas.txt");

            // Verificar si existen los archivos, si no existen, crear nuevos
            if (!pacientesFile.exists()) {
                boolean pacientesFileCreated = pacientesFile.createNewFile();
                if (pacientesFileCreated) {
                    System.out.println("Archivo pacientes.txt creado exitosamente.");
                }
            }

            if (!doctoresFile.exists()) {
                boolean doctoresFileCreated = doctoresFile.createNewFile();
                if (doctoresFileCreated) {
                    System.out.println("Archivo doctores.txt creado exitosamente.");
                }
            }

            if (!citasFile.exists()) {
                boolean citasFileCreated = citasFile.createNewFile();
                if (citasFileCreated) {
                    System.out.println("Archivo citas.txt creado exitosamente.");
                }
            }

            // Leer información de los archivos
            Scanner pacientesReader = new Scanner(pacientesFile);
            while (pacientesReader.hasNextLine()) {
                numPacientes++;
                idPacientes[numPacientes] = pacientesReader.nextLine();
                NombrePacientes[numPacientes] = pacientesReader.nextLine();
            }
            pacientesReader.close();

            Scanner doctoresReader = new Scanner(doctoresFile);
            while (doctoresReader.hasNextLine()) {
                numDoctores++;
                idDoctores[numDoctores] = doctoresReader.nextLine();
                NombreDoctores[numDoctores] = doctoresReader.nextLine();
                EspecialidadDoctores[numDoctores] = doctoresReader.nextLine();
            }
            doctoresReader.close();

            Scanner citasReader = new Scanner(citasFile);
            while (citasReader.hasNextLine()) {
                numCitas++;
                idCitas[numCitas] = citasReader.nextLine();
                FechaCitas[numCitas] = citasReader.nextLine();
                HoraCitas[numCitas] = citasReader.nextLine();
                MotivoCitas[numCitas] = citasReader.nextLine();
                idDoctorCitas[numCitas] = citasReader.nextLine();
                idPacienteCitas[numCitas] = citasReader.nextLine();
            }
            citasReader.close();

            int op;
            do {
                System.out.println("Elige la opción que deseas realizar");
                System.out.println();
                System.out.println("1. Registrar");
                System.out.println("2. Mostrar");
                System.out.println("3. Crear cita");
                System.out.println("4. Salir");
                System.out.println();
                op = scanner.nextInt();

                switch (op) {
                    case 1 -> {
                        System.out.println("Elige el tipo de usuario a registrar");
                        System.out.println("1. Doctor");
                        System.out.println("2. Paciente");
                        int opSubmenu = scanner.nextInt();
                        switch (opSubmenu) {
                            case 1 -> {
                                numDoctores++;
                                System.out.println("Ingrese datos del doctor " + numDoctores);
                                System.out.println();
                                System.out.println("Ingrese el id del doctor");
                                scanner.nextLine();
                                idDoctores[numDoctores] = scanner.nextLine();
                                System.out.println("Ingrese el nombre del doctor");
                                NombreDoctores[numDoctores] = scanner.nextLine();
                                System.out.println("Ingrese la especialidad del doctor");
                                EspecialidadDoctores[numDoctores] = scanner.nextLine();
                                System.out.println("Registro de doctor exitoso");
                                System.out.println();

                                // Guardar información en el archivo de doctores
                                FileWriter doctoresWriter = new FileWriter(doctoresFile, true);
                                BufferedWriter doctoresBufferedWriter = new BufferedWriter(doctoresWriter);

                                doctoresBufferedWriter.write("ID: " + (idDoctores[numDoctores]));
                                doctoresBufferedWriter.newLine();
                                doctoresBufferedWriter.write("Nombre: " + (NombreDoctores[numDoctores]));
                                doctoresBufferedWriter.newLine();
                                doctoresBufferedWriter.write("Especialidad: " + (EspecialidadDoctores[numDoctores]));
                                doctoresBufferedWriter.newLine();
                                doctoresBufferedWriter.write("----------------------------------");
                                doctoresBufferedWriter.newLine();
                                doctoresBufferedWriter.close();
                            }
                            case 2 -> {
                                numPacientes++;
                                System.out.println("Ingrese datos del paciente " + numPacientes);
                                System.out.println();
                                System.out.println("Ingrese el id del paciente");
                                scanner.nextLine();
                                idPacientes[numPacientes] = scanner.nextLine();
                                System.out.println("Ingrese el nombre del paciente");
                                NombrePacientes[numPacientes] = scanner.nextLine();
                                System.out.println("Registro de paciente exitoso");
                                System.out.println();

                                // Guardar información en el archivo de pacientes
                                FileWriter pacientesWriter = new FileWriter(pacientesFile, true);

                                BufferedWriter pacientesBufferedWriter = new BufferedWriter(pacientesWriter);
                                pacientesBufferedWriter.write("ID: " + (idPacientes[numPacientes]));
                                pacientesBufferedWriter.newLine();
                                pacientesBufferedWriter.write("Nombre: " + (NombrePacientes[numPacientes]));
                                pacientesBufferedWriter.newLine();
                                pacientesBufferedWriter.write("----------------------------------");
                                pacientesBufferedWriter.newLine();
                                pacientesBufferedWriter.close();

                            }
                            default -> System.out.println("Opción inválida");
                        }
                    }
                    case 2 -> {
                        int opSubmenuMostrar;
                        do {
                            System.out.println("Elige el tipo de registros a mostrar:");
                            System.out.println("1. Registro de Pacientes");
                            System.out.println("2. Registro de Doctores");
                            System.out.println("3. Citas");
                            System.out.println("4. Volver");
                            opSubmenuMostrar = scanner.nextInt();

                            switch (opSubmenuMostrar) {
                                case 1:
                                    System.out.println("Registros de Pacientes:");
                                    for (int i = 1; i <= numPacientes; i++) {
                                        System.out.println("ID: " + idPacientes[i]);
                                        System.out.println("Nombre: " + NombrePacientes[i]);
                                        System.out.println();
                                    }
                                    break;

                                case 2:
                                    System.out.println("Registros de Doctores:");
                                    for (int i = 1; i <= numDoctores; i++) {
                                        System.out.println("ID: " + idDoctores[i]);
                                        System.out.println("Nombre: " + NombreDoctores[i]);
                                        System.out.println("Especialidad: " + EspecialidadDoctores[i]);
                                        System.out.println();
                                    }
                                    break;

                                case 3:
                                    System.out.println("Registros de Citas:");
                                    for (int i = 1; i <= numCitas; i++) {
                                        System.out.println("ID: " + idCitas[i]);
                                        System.out.println("Fecha: " + FechaCitas[i]);
                                        System.out.println("Hora: " + HoraCitas[i]);
                                        System.out.println("Motivo: " + MotivoCitas[i]);
                                        System.out.println("ID Doctor: " + idDoctorCitas[i]);
                                        System.out.println("ID Paciente: " + idPacienteCitas[i]);
                                        System.out.println();
                                    }
                                    break;

                                case 4:
                                    break;

                                default:
                                    System.out.println("Opción inválida");
                                    break;
                            }
                        } while (opSubmenuMostrar != 4);
                    }
                    case 3 -> {
                        numCitas++;
                        System.out.println("Ingrese datos de la cita " + numCitas);
                        System.out.println();
                        System.out.println("Ingrese el id de la cita");
                        scanner.nextLine();
                        idCitas[numCitas] = scanner.nextLine();
                        System.out.println("Ingrese la fecha de la cita");
                        FechaCitas[numCitas] = scanner.nextLine();
                        System.out.println("Ingrese la hora de la cita");
                        HoraCitas[numCitas] = scanner.nextLine();
                        System.out.println("Ingrese el motivo de la cita");
                        MotivoCitas[numCitas] = scanner.nextLine();
                        System.out.println("Ingrese el id del doctor");
                        idDoctorCitas[numCitas] = scanner.nextLine();
                        System.out.println("Ingrese el id del paciente");
                        idPacienteCitas[numCitas] = scanner.nextLine();
                        System.out.println("Registro de cita exitoso");
                        System.out.println();

                        // Guardar información en el archivo de citas
                        FileWriter citasWriter = new FileWriter(citasFile, true);
                        BufferedWriter citasBufferedWriter = new BufferedWriter(citasWriter);

                        citasBufferedWriter.write("ID: " + idCitas[numCitas]);
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.write("Fecha: " + FechaCitas[numCitas]);
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.write("Hora: " + HoraCitas[numCitas]);
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.write("Motivo: " + MotivoCitas[numCitas]);
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.write("ID Doctor: " + idDoctorCitas[numCitas]);
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.write("ID Paciente: " + idPacienteCitas[numCitas]);
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.write("----------------------------------");
                        citasBufferedWriter.newLine();
                        citasBufferedWriter.close();
                    }
                    case 4 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción inválida");
                }
            } while (op != 4);
        } else {
            System.out.println("Has excedido el número máximo de intentos. Saliendo del programa...");
        }
    }
}