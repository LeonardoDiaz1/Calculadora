import javax.swing.*;

/**
 * La clase Calculadora proporciona una interfaz gráfica simple para realizar diversas operaciones matemáticas.
 */

public class Calculadora{

    /**
     * Método principal para ejecutar la aplicación de la calculadora.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */

    public static void main(String[] args) {
        
        menuCalc();

    }

    /**
     * Muestra el menú principal de la calculadora y llama a las acciones correspondientes según la selección del usuario.
     */

    public static void menuCalc() {
        
        String menu = "Calculadora\n" + "1. Suma\n" + "2. Resta\n" + "3. Multiplicacion\n" + "4. Division\n" + "5. Residuo\n" 
            + "6. Calcular la formula del usuario\n"
            + "7. Numeros primos\n"
            + "8. Salir\n"
            + "\n Ingrese el numero correspondiente a la accion que ejecutara", opcion;
        opcion = JOptionPane.showInputDialog(null, menu);

        acciones(opcion);

    }

    /**
     * Solicita al usuario que ingrese el primer número.
     * @return El primer número ingresado por el usuario como cadena de texto.
     */

    public static String ingreseDatoUno() {

        String numero1 = "Ingrese el valor a";
        String num1 = JOptionPane.showInputDialog(numero1);

        return num1;

    }

    /**
     * Solicita al usuario que ingrese el segundo número.
     * @return El segundo número ingresado por el usuario como cadena de texto.
     */

    public static String ingreseDatoDos() {

        String numero2 = "Ingrese el valor b";
        String num2 = JOptionPane.showInputDialog(numero2);

        return num2;

    }

    /**
     * Solicita al usuario que ingrese el tercer número para la fórmula cuadrática.
     * @return El tercer número ingresado por el usuario como cadena de texto.
     */

    public static String ingreseDatoTres() {

        String numero3 = "Ingrese el valor c";
        String num3 = JOptionPane.showInputDialog(numero3);

        return num3;

    }

    /**
     * Muestra un mensaje de error cuando se ingresa un valor no válido.
     */

    public static void ValorInvalido() {
        JOptionPane.showMessageDialog(null, "Ingresaste un valor invalido");
    }

    /**
     * Realiza la operación de suma con los dos números dados.
     * @param num1 Primer número.
     * @param num2 Segundo número.
     */

    public static void Suma(String num1, String num2) {

        try{
            int resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
            JOptionPane.showMessageDialog(null, "El resultado de la suma es: "+ resultado);
        }
        catch(Exception ex){
            ValorInvalido();
        }
        finally{
            menuCalc();
        }

    }

    public static void Resta(String num1, String num2) {

        try{
            int resultado = Integer.parseInt(num1) - Integer.parseInt(num2);
            JOptionPane.showMessageDialog(null, "El resultado de la resta es: "+ resultado);
        }
        catch(Exception ex){
            ValorInvalido();
        }
        finally{
            menuCalc();
        }

    }

    public static void Multiplicacion(String num1, String num2) {

        try{
            int resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
            JOptionPane.showMessageDialog(null, "El resultado de la multiplicacion es: "+ resultado);
        }
        catch(Exception ex){
            ValorInvalido();
        }
        finally{
            menuCalc();
        }

    }

    public static void Division(String num1, String num2) {

        try{
            double resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
            JOptionPane.showMessageDialog(null, "El resultado de la division es: "+ resultado);
        }
        catch(Exception ex){
            ValorInvalido();
        }
        finally{
            menuCalc();
        }

    }

    public static void Residuo(String num1, String num2) {

        try{
            double resultado = Double.parseDouble(num1) % Double.parseDouble(num2);
            JOptionPane.showMessageDialog(null, "El resultado del residuo de la division es: "+ resultado);
        }
        catch(Exception ex){
            ValorInvalido();
        }
        finally{
            menuCalc();
        }

    }

    public static void cuadratica(Double a, Double b, Double c) {
        /*funcion cuadratica o formula del estudiante es: 
        menos b mas o menos la raiz cuadrada de: b al cuadro menos 4 por a o por c
        lo anterior dividido dos por a*/
        try{
            double temp,x1,x2;
            temp = b*b-4*a*c;
            if(temp>=0){
                if(2*a !=0){
                    x1 = (-b-Math.sqrt(temp))/(2*a);
                    x2 = (-b+Math.sqrt(temp))/(2*a);
                    JOptionPane.showMessageDialog(null, "Las raices son:\n" +"x1: "+x1+"\n" +"x2: "+x2);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error division por cero");
                }
            } 
            else{
                JOptionPane.showMessageDialog(null, "Error raiz negativa");
            }
        } 
        catch(Exception ex){
            ValorInvalido();
        }
        finally{
            menuCalc();
        }
        
    } 

    // Resto de los métodos de operaciones matemáticas siguen un patrón similar...

    /**
     * Verifica si un número dado es primo.
     * @param n Número a verificar.
     * @return Verdadero si el número es primo, falso de lo contrario.
     */

    public static boolean primos(int n){

        int dividores = 2, cont = 2;

        while (cont < n){
            if(n % cont == 0){
                dividores++;
                break;
            }
            cont++;
        }
        return(dividores==2);

    }

    public static void acciones(String opcion){

        String num1, num2;
        double a, b, c;

        switch(opcion){
            case "1":
                num1 = ingreseDatoUno();
                num2 = ingreseDatoDos();
                Suma(num1, num2);
            break;

            case "2":
                num1 = ingreseDatoUno();
                num2 = ingreseDatoDos();
                Resta(num1, num2);
            break;

            case "3":
                num1 = ingreseDatoUno();
                num2 = ingreseDatoDos();
                Multiplicacion(num1, num2);
            break;

            case "4":
                num1 = ingreseDatoUno();
                num2 = ingreseDatoDos();
                if(num2 == "0"){
                    JOptionPane.showMessageDialog(null, "No se puede dividir por cero");
                    menuCalc();
                }
                else{
                    Division(num1, num2);
                }
            break;

            case "5":
                num1 = ingreseDatoUno();
                num2 = ingreseDatoDos();
                if(num2 == "0"){
                    JOptionPane.showMessageDialog(null, "No se puede calcular el residuo de la division por cero");
                    menuCalc();
                }
                else{
                    Residuo(num1, num2);
                }
            break;

            case "6":
                try{
                    a = Double.parseDouble(ingreseDatoUno());
                    b = Double.parseDouble(ingreseDatoDos());
                    c = Double.parseDouble(ingreseDatoTres());
                    cuadratica(a, b, c);
                }catch(Exception ex){
                    ValorInvalido();
                    menuCalc();
                }
            break;

            case "7":
            num1 = ingreseDatoUno();
            num2 = ingreseDatoDos();
            String lista="";
            try{
                if(Integer.parseInt(num1) < Integer.parseInt(num2)){
                    for(int i=Integer.parseInt(num1); i<=Integer.parseInt(num2);i++){
                        if(primos(i)){
                            lista = lista+","+i;
                        }
                    }
                        JOptionPane.showMessageDialog(null, "Los numero primos entre a y b son "+ lista);
                        menuCalc();
                    } else{
                        for(int i = Integer.parseInt(num2); i<=Integer.parseInt(num1); i++){
                            if(primos(i)){
                                lista = lista+","+i;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Los primos entre a y b son "+ lista);
                        menuCalc();
                    }
                } catch(Exception ex){
                    ValorInvalido();
                    menuCalc();
                }
            break;

            case "8":
                System.exit(0);
            break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ingresado una opcion invalida");
            menuCalc();

        }
    }
}
