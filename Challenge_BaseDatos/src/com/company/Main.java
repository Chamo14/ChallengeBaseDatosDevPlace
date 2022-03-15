package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int cantidad;
        Scanner teclado =new Scanner(System.in);
        Empleado[] empleados;
        System.out.println("Bienvenido a nuestra base de empleados");
        System.out.println("Ingrese numeros empleados a cargar");
        cantidad=teclado.nextInt();
        empleados= new Empleado[cantidad];
        cargarEmpleados(cantidad,empleados);//metodo que carga en un array los empleados deseados
       // imprimirEmpleados(cantidad,empleados); //prueba de impresion de empleados
        mostrarSeleccionados(cantidad,empleados);//metodo que solo mostrara los empleados que cumplan con los requisitos
        teclado.close();

    }
//Se hace el ingreso de datos por teclado de cada empleado
    public static void cargarEmpleados(int cont , Empleado[] arrayEmpleado){
        int i=0;

        String nombre="", apellido="",municipio="",puesto="",email ="";
        int telefono=0,antiguedad=0;
        float salario=0;
        Scanner teclado = new Scanner(System.in);
        while (i<cont) {
            System.out.println("Ingrese nombre ");
            nombre= teclado.next();
            System.out.println("Ingrese apellido");
            apellido= teclado.next();
            System.out.println("Ingrese telefono");
            telefono=teclado.nextInt();
            System.out.println("Ingrese email");
            email= teclado.next();
            System.out.println("Ingrese salario");
            salario= teclado.nextFloat();
            System.out.println("Ingrese antiguedad");
            antiguedad=teclado.nextInt();
            System.out.println("Ingrese puesto");
            puesto= teclado.next();
            System.out.println("Ingrese municipio a que pertenece");
            municipio=teclado.next();
            Empleado empleado = new Empleado(nombre, apellido, telefono, email, salario, antiguedad, puesto, municipio);
//Se instancia el objeto para luego ser agregado al array de empleados
            arrayEmpleado[i] = empleado;
            i++;

        }
        teclado.close();
    }
//funcion auxiliar para comprobar las impresiones de los empleados en un array
    public static void imprimirEmpleados(int cont,Empleado[] arrayEmpleado){
        int i=0;
        while (i<cont){
            imprimirEmpleado(arrayEmpleado[i]);
            i++;
        }
    }
//funcion que imprime un empleado
    public static void imprimirEmpleado(Empleado empleado){
        System.out.println("Empleado-------");
        System.out.println("Nombre : "+empleado.getNombre());
        System.out.println("Apellido : "+empleado.getApellido());
        System.out.println("Telefono : "+empleado.getTelefono());
        System.out.println("Email : "+empleado.getEmail());
        System.out.println("Salario : "+empleado.getSalario());
        System.out.println("Antiguedad : "+empleado.getAntiguedad());
        System.out.println("Puesto : "+empleado.getPuesto());
        System.out.println("Municipio : "+empleado.getMunicipio());
    }
//Se recorrera el array de empleados y se comprobaran los requisitos , si los cumple , llamara a la funcion de impresion de ese empleado que cumpla esos requisitos
    public static void mostrarSeleccionados(int cont,Empleado[] arrayEmpleado) {
        int i = 0;
        System.out.println("Empleados con sueldo mayor a 70000$ y antiguedades entre 10 a 15 años");
        while (i < cont) {
            System.out.println("+++++++++++++++++");
            if (arrayEmpleado[i].getSalario() > 70000 && (arrayEmpleado[i].getAntiguedad() >= 10 || arrayEmpleado[i].getAntiguedad() <= 15))
                imprimirEmpleado(arrayEmpleado[i]);
            i++;
        }
    }
}
