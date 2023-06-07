Funcion registrarDoctor(id, Nombre, Especialidad, i)
    Escribir "Ingrese datos del doctor ", i
    Escribir ""
    Escribir "Ingrese el id del doctor"
    Leer id[i]
    Escribir "Ingrese el nombre del doctor"
    Leer Nombre[i]
    Escribir "Ingrese la especialidad del doctor"
    Leer Especialidad[i]
    Escribir "Registro de doctor exitoso"
    Escribir ""
FinFuncion

Funcion registrarPaciente(id, Nombre, i)
    Escribir "Ingrese datos del paciente ", i
    Escribir ""
    Escribir "Ingrese el id del paciente"
    Leer id[i]
    Escribir "Ingrese el nombre del paciente"
    Leer Nombre[i]
    Escribir "Registro de paciente exitoso"
    Escribir ""
FinFuncion

Funcion crearCita(idCita, Fecha, Hora, Motivo, idDoctor, idPaciente, i)
    Escribir "Ingrese datos de la cita ", i
    Escribir ""
    Escribir "Ingrese el identificador de la cita"
    Leer idCita[i]
    Escribir "Ingrese la fecha de la cita"
    Leer Fecha[i]
    Escribir "Ingrese la hora de la cita"
    Leer Hora[i]
    Escribir "Ingrese el motivo de la cita"
    Leer Motivo[i]
    Escribir "Ingrese el ID del doctor relacionado con la cita"
    Leer idDoctor[i]
    Escribir "Ingrese el ID del paciente relacionado con la cita"
    Leer idPaciente[i]
    Escribir "Cita creada exitosamente"
    Escribir ""
FinFuncion

Funcion mostrarUsuario(idDoctores, NombreDoctores, EspecialidadDoctores, idPacientes, NombrePacientes, idCitas, FechaCitas, HoraCitas, MotivoCitas, idDoctorCitas, idPacienteCitas, numDoctores, numPacientes, numCitas)
    Repetir
        Escribir "Elige el tipo de registros a mostrar:"
        Escribir "1. Registro de Pacientes"
        Escribir "2. Registro de Doctores"
        Escribir "3. Citas"
        Escribir "4. Volver"
        Leer opSubmenu
        
        Segun opSubmenu Hacer
            1:
                Escribir "---- Registro de Pacientes ----"
                Si (numPacientes > 0) Entonces
                    Para f = 1 Hasta numPacientes Con Paso 1 Hacer
                        Escribir "ID: ", idPacientes[f]
                        Escribir "Nombre: ", NombrePacientes[f]
                        Escribir "-------------------------------"
                    Fin Para
                SiNo
                    Escribir "No hay pacientes registrados"
                Fin Si
                Escribir ""
            2:
                Escribir "---- Registro de Doctores ----"
                Si (numDoctores > 0) Entonces
                    Para f = 1 Hasta numDoctores Con Paso 1 Hacer
                        Escribir "ID: ", idDoctores[f]
                        Escribir "Nombre: ", NombreDoctores[f]
                        Escribir "Especialidad: ", EspecialidadDoctores[f]
                        Escribir "-------------------------------"
                    Fin Para
                SiNo
                    Escribir "No hay doctores registrados"
                Fin Si
                Escribir ""
            3:
                Escribir "---- Citas ----"
                Si (numCitas > 0) Entonces
                    Para f = 1 Hasta numCitas Con Paso 1 Hacer
                        Escribir "ID Cita: ", idCitas[f]
                        Escribir "Fecha: ", FechaCitas[f]
                        Escribir "Hora: ", HoraCitas[f]
                        Escribir "Motivo: ", MotivoCitas[f]
                        Escribir "ID Doctor: ", idDoctorCitas[f]
                        Escribir "ID Paciente: ", idPacienteCitas[f]
                        Escribir "-------------------------------"
                    Fin Para
                SiNo
                    Escribir "No hay citas registradas"
                Fin Si
                Escribir ""
            4:
                Escribir ""
            De Otro Modo:
                Escribir "Opción inválida"
                Escribir ""
        Fin Segun
    Hasta Que opSubmenu = 4
FinFuncion


Algoritmo RegistroDeUsuarios
    Definir idDoctores, NombreDoctores, EspecialidadDoctores como Cadena
    Definir idPacientes, NombrePacientes como Cadena
    Definir idCitas, FechaCitas, HoraCitas, MotivoCitas, idDoctorCitas, idPacienteCitas como Cadena
    Definir numDoctores, numPacientes, numCitas como Entero
    numDoctores = 0
    numPacientes = 0
    numCitas = 0
    
    Escribir "---Registro de usuarios y citas----"
    Escribir ""
    Dimension idDoctores[100]
    Dimension NombreDoctores[100]
    Dimension EspecialidadDoctores[100]
    Dimension idPacientes[100]
    Dimension NombrePacientes[100]
    Dimension idCitas[100]
    Dimension FechaCitas[100]
    Dimension HoraCitas[100]
    Dimension MotivoCitas[100]
    Dimension idDoctorCitas[100]
    Dimension idPacienteCitas[100]
	
    Escribir "Ingrese el nombre de usuario:"
    Leer usuario
    Escribir "Ingrese la contraseña:"
    Leer contrasena
	
    Si (usuario = "admin") y (contrasena = "admin") Entonces
        Repetir
            Escribir "Elige la opción que deseas realizar"
            Escribir ""
            Escribir "1. Registrar"
            Escribir "2. Mostrar"
            Escribir "3. Crear cita"
            Escribir "4. Salir"
            Escribir ""
            Leer op
			
            Segun op Hacer
                1:
                    Escribir "Elige el tipo de usuario a registrar"
                    Escribir "1. Doctor"
                    Escribir "2. Paciente"
                    Leer opSubmenu
					
                    Segun opSubmenu Hacer
                        1:
                            numDoctores = numDoctores + 1
                            registrarDoctor(idDoctores, NombreDoctores, EspecialidadDoctores, numDoctores)
                        2:
                            numPacientes = numPacientes + 1
                            registrarPaciente(idPacientes, NombrePacientes, numPacientes)
                    Fin Segun
                2:
                    mostrarUsuario(idDoctores, NombreDoctores, EspecialidadDoctores, idPacientes, NombrePacientes, idCitas, FechaCitas, HoraCitas, MotivoCitas, idDoctorCitas, idPacienteCitas, numDoctores, numPacientes, numCitas)
                3:
                    numCitas = numCitas + 1
                    crearCita(idCitas, FechaCitas, HoraCitas, MotivoCitas, idDoctorCitas, idPacienteCitas, numCitas)
                4:
                    Escribir "Hasta pronto"
                De Otro Modo:
                    Escribir "Opción inválida"
            Fin Segun
        Hasta Que (op = 4)
    SiNo
        Escribir "Acceso denegado. Usuario o contraseña incorrectos."
    Fin Si
Fin Algoritmo