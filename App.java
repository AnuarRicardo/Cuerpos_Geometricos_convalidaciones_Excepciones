import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = mostarmenu();
            try {
                evaluaropcion(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número entero");
                lector.nextLine();
            }
        } while (opcion != 17);
    }
    public static int mostarmenu() {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("1) calcular prisma");
        System.out.println("2) calcular cilindro");
        System.out.println("3) calcular piramide");
        System.out.println("4) calcular cono");
        System.out.println("5) calcular esfera");
        System.out.println("6) calcular Tronco cono");
        System.out.println("7) calcular Tronco piramide");
        System.out.println("8) calcular (Huso esferico/Cuña esferica)");
        System.out.println("9) calcular zona esferica");
        System.out.println("10) calcular casquete esferico");
        System.out.println("11) calcular Tetradeo");
        System.out.println("12) calcular Hexaedro");
        System.out.println("13) calcular Octaedro");
        System.out.println("14) calcular Dodecaedro");
        System.out.println("15) calcular Isoedro");
        System.out.println("16) calcular ortoedro");
        System.out.println("17) salir del programa");
        System.out.print("Seleccione una opción: ");
        int opc = -1;
        try {
            opc = lector.nextInt();
        } catch (InputMismatchException e) {
            lector.nextLine();
        }
        return opc;
    }
    public static void evaluaropcion(int opc) {
        switch (opc) {
                case 1:
                prisma();
                break;
                case 2:
                cilindro();
                break;
                case 3:
                piramide();
                break;
                case 4:
                cono();
                break;
                case 5:
                esfera();
                break;
                case 6:
                troncoCono();
                break;
                case 7:
                TroncoPiramide();
                break;
                case 8:
                husoesferico();
                break;
                case 9:
                zonaEsferica();
                case 10:
                casqueteEsferico();
                case 11:
                tetradeo();
                break;
                case 12:
                Hexaedro();
                break;
                case 13:
                Octaedro();
                break;
                case 14:
                Dodecaedro();
                break;
                case 15:
                Isoedro();
                break;
                case 16:
                Ortoedro();
                case 17:
                salirdelprograma();
                break;
            default:
                System.out.println("************************************************************************");
                System.out.println("Opción no válida, Por favor elija una de las opciones que se le presenta");
                System.out.println("*************************************************************************");
        }
    }
    public static void prisma() {
        try {
            int cantidadLados;
            double longitud, altura, areaLateral, areaTotal, volumen;
            double perimetroBase, areaBase, apotema;
            int intentos = 0;
            do {
                if (intentos > 0) {
                    System.out.println("No puede ser cero ni negativo");
                }
                System.out.print("Digite la cantidad de lados: ");
                cantidadLados = lector.nextInt();
                intentos++;
                if (intentos >= 3) {
                    System.out.println("Se han agotado los intentos");
                    return;
                }
            } while (cantidadLados <= 0);
            intentos = 0;
            do {
                if (intentos > 0) {
                    System.out.println( "No puede ser cero ni negativo");
                }
                System.out.print("Digite la altura: ");
                altura = lector.nextDouble();
                intentos++;
                if (intentos >= 3) {
                    System.out.println("Se han agotado los intentos");
                    return;
                }
            } while (altura <= 0);
            intentos = 0;
            do {
                if (intentos > 0) {
                    System.out.println("No puede ser cero ni negativo");
                }
                System.out.print("Digite la longitud: ");
                longitud = lector.nextDouble();
                intentos++;
                if (intentos >= 3) {
                    System.out.println("Se han agotado los intentos.");
                    return;
                }
            } while (longitud <= 0);
            perimetroBase = cantidadLados * longitud;
            areaLateral = perimetroBase * altura;
            double alfa = (Math.PI / 180) * (360 / cantidadLados);
            apotema = longitud / (2 * Math.tan((alfa) / 2));
            areaBase = (perimetroBase * apotema) / 2;
            areaTotal = areaLateral + 2 * areaBase;
            volumen = areaBase * altura;
            System.out.println("Area lateral: " + areaLateral + " unidades cuadradas.");
            System.out.println("Area total: " + areaTotal + " unidades cuadradas.");
            System.out.println("Volumen: " + volumen + " unidades cúbicas.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
    public static void cilindro() {
        try {
            double altura = 0.0;
            double radio = 0.0;
            double areaLateral, areaTotal, volumen, perimetroBase, base;
            int intentos = 0;
            while (intentos < 3) {
                System.out.print("Digite el radio: ");
                radio = lector.nextDouble();
                if (radio > 0) {
                    break;
                }
                System.out.println("No puede ser cero ni negativo");
                intentos++;
            }
            if (intentos >= 3) {
                System.out.println("Se han agotado los intentos");
                return;
            }
            intentos = 0;
            while (intentos < 3) {
                System.out.print("Digite la altura: ");
                altura = lector.nextDouble();
                if (altura > 0) {
                    break;
                }
                System.out.println("no puede ser cero ni negativo");
                intentos++;
            }
            if (intentos >= 3) {
                System.out.println("Se han agotado los intentos");
                return;
            }
            perimetroBase = 2 * Math.PI * radio;
            areaLateral = perimetroBase * altura;
            base = Math.PI * (radio * radio);
            areaTotal = areaLateral + 2 * base;
            volumen = base * altura;
            System.out.println("Area lateral: " + areaLateral + " unidades cuadradas.");
            System.out.println("Area total: " + areaTotal + " unidades cuadradas.");
            System.out.println("Volumen: " + volumen + " unidades cúbicas.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
    public static void piramide() {
        try {
            int cantidadLados = 0;
            double altura = 0;
            double apotemaB = 0;
            double perimetroBase= 0;
            double apotemapiramide= 0;
            double longitud=0;
            double arealateral, areatotal, volumen;
            double areabasemayor;
            int intentos = 0;
            while (intentos < 3) {
                System.out.print("Digite la cantidad de lados: ");
                cantidadLados = lector.nextInt();
                if (cantidadLados > 0) {
                    break;
                }
                System.out.println("no puede ser cero ni negativo");
                intentos++;
            }
            if (intentos >= 3) {
                System.out.println("Se han agotado los intentos");
                return;
            }
            intentos = 0;
            while (intentos < 3) {
                System.out.print("Digite la altura: ");
                altura = lector.nextDouble();
                if (altura > 0) {
                    break;
                }
                System.out.println("no puede ser cero ni negativo");
                intentos++;
            }
            if (intentos >= 3) {
                System.out.println("Se han agotado los intentos");
                return;
            }
            double alfa = (Math.PI / 180) * (360 / cantidadLados);
            perimetroBase = cantidadLados * longitud;
            apotemaB = longitud / (2 * Math.tan(alfa / 2));
            apotemapiramide = altura + apotemaB;
            arealateral = perimetroBase * apotemapiramide;
            areabasemayor = (perimetroBase * apotemaB) / 2;
            areatotal = arealateral + areabasemayor;
            volumen = (areabasemayor * altura) / 3;
            System.out.println("Area lateral: " + arealateral + " unidades cuadradas.");
            System.out.println("Area total: " + areatotal + " unidades cuadradas.");
            System.out.println("Volumen: " + volumen + " unidades cúbicas.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
    public static void cono() {
    try {
        int cantidadLados = 0;
        double altura = 0;
        double perimetroBase=0;
        double generatriz=0;
        double areabase=0;
        double longitud=0;
        double radio=0;
        double arealateral, areatotal, volumen;
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite la cantidad de lados: ");
            cantidadLados = lector.nextInt();
            if (cantidadLados > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite la altura: ");
            altura = lector.nextDouble();
            if (altura > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;

        while (intentos < 3) {
            System.out.print("Digite el radio: ");
            radio = lector.nextDouble();
            if (radio > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        perimetroBase = cantidadLados * longitud;
        generatriz = altura + radio;
        arealateral = (perimetroBase * generatriz) / 2;
        areabase = Math.PI * Math.pow(radio, 2);
        areatotal = arealateral + areabase;
        volumen = (areabase * altura) / 3;
        System.out.println("Area lateral: " + arealateral + " unidades cuadradas.");
        System.out.println("Area total: " + areatotal + " unidades cuadradas.");
        System.out.println("Volumen: " + volumen + " unidades cúbicas.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
    public static void esfera() {
    try{
        double radio = 0.0;
        double area, volumen;
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite el radio: ");
            radio = lector.nextDouble();
            if (radio > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        area = 4 * Math.PI * Math.pow(radio, 2);
        volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
        System.out.println("Área: " + area + " unidades cuadradas.");
        System.out.println("Volumen: " + volumen + " unidades cúbicas.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
    public static void zonaEsferica() {
        double radio = 0, radiomayor = 0;
        int altura = 0;
        double volumen, area;
        int intentos = 0;
    try{
        while (intentos < 3) {
            System.out.println("Digite el radio: ");
            radio = lector.nextDouble();
            if (radio > 0) {
                break;
            } else {
                System.out.println("No puede ser cero ni negativo");
            }
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.println("Digite el radio mayor: ");
            radiomayor = lector.nextDouble();
            if (radiomayor > 0) {
                break;
            } else {
                System.out.println("No puede ser cero ni negativo");
            }
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.println("Digite la altura: ");
            altura = lector.nextInt();
            if (altura > 0) {
                break;
            } else {
                System.out.println("No puede ser cero ni negativo");
            }
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        area = 2 * Math.PI * radiomayor * altura;
        volumen = (Math.PI * altura) * (altura * altura + 3 * radio * radio + 3 * radio * radio) / 6;
        System.out.println("Área: " + area + " unidades cúbicas");
        System.out.println("Volumen: " + volumen + " unidades cúbicas");
    } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
public static void casqueteEsferico() {

    double radiomayor = 0, altura = 0, area, volumen;
    int intentos = 0;

    while (intentos < 3) {
        try {
            System.out.println("Digite la altura: ");
            altura = lector.nextDouble();
            if (altura > 0) {
                break;
            } else {
                System.out.println("No puede ser cero ni negativa");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        }
        intentos++;
    }

    if (intentos >= 3) {
        System.out.println("Se han agotado los intentos");
        lector.close();
        return;
    }
    intentos = 0;
    while (intentos < 3) {
        try {
            System.out.println("Digite el radio mayor: ");
            radiomayor = lector.nextDouble();

            if (radiomayor > 0) {
                break;
            } else {
                System.out.println("No puede ser cero ni negativo");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        }
        intentos++;
    }
    if (intentos >= 3) {
        System.out.println("Se han agotado los intentos");
        return;
    }
    area = 2 * Math.PI * radiomayor * altura;
    volumen = (Math.PI * Math.pow(altura, 2)) * (3 * radiomayor - altura) / 3;
    System.out.println("Área: " + area + " unidades cúbicas");
    System.out.println("Volumen: " + volumen + " unidades");
}
public static void troncoCono() {
    try {
        double radio = 0;
        double radiomayor = 0;
        double longitud = 0;
        double altura = 0;
        double volumen = 0;
        double generatriz, arealateral;
        double areabasemayor, areabasemenor;
        double areatotal, apotemabase;
        int cantidadlados = 0;
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite la cantidad de lados: ");
            cantidadlados = lector.nextInt();
            if (cantidadlados > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite la altura: ");
            altura = lector.nextDouble();
            if (altura > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite la longitud: ");
            longitud = lector.nextDouble();
            if (longitud > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite el radio: ");
            radio = lector.nextDouble();
            if (radio > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos.");
            return;
        }
        intentos = 0;
        while (intentos < 3) {
            System.out.print("Digite el Radio Mayor: ");
            radiomayor = lector.nextDouble();
            if (radiomayor > 0) {
                break;
            }
            System.out.println("No puede ser cero ni negativo");
            intentos++;
        }
        if (intentos >= 3) {
            System.out.println("Se han agotado los intentos");
            return;
        }
        double alfa = (Math.PI / 180) * (360 / cantidadlados);
        apotemabase = longitud / (2 * Math.tan(alfa / 2));
        generatriz = Math.sqrt(Math.pow(altura, 2) + Math.pow(radio - radiomayor, 2));
        arealateral = Math.PI * generatriz * (radiomayor + radio);
        areabasemayor = Math.PI * Math.pow(radiomayor, 2);
        areabasemenor = Math.PI * Math.pow(radio, 2);
        areatotal = arealateral + areabasemayor + areabasemenor;
        volumen = (1.0 / 3.0) * Math.PI * altura * (Math.pow(radiomayor, 2) + radiomayor * radio + Math.pow(radio, 2));
        System.out.println("Área lateral: " + arealateral + " unidades cuadradas.");
        System.out.println("Área total: " + areatotal + " unidades cuadradas.");
        System.out.println("Volumen: " + volumen + " unidades cúbicas.");
    } catch (InputMismatchException e) {
        System.out.println("Entrada no válida, Por favor ingrese un número válido.");
        lector.nextLine();
    } catch (ArithmeticException e) {
        System.out.println("Error aritmético: " + e.getMessage());
    } finally {
        lector.close();
    }
}
public static void TroncoPiramide() {
    try {
        int altura = 0;
        int cantidadlados = 0;
        double longitud = 0;
        double radio = 0;
        double radiomayor = 0;
        double apotemapiramide, arealateral, areatotal, volumen, apotemabase;
        double areabasemayor, areabasemenor, perimetrobasemayor, perimetrobasemenor;
        int intentos = 3;
        while (intentos > 0) {
            System.out.println("Digite la altura: ");
            altura = lector.nextInt();
            if (altura <= 0) {
                System.out.println("La altura no puede ser cero ni negativo");
                intentos--;
                continue;
            }
            System.out.println("Digite la longitud: ");
            longitud = lector.nextDouble();
            if (longitud <= 0) {
                System.out.println("La longitud no puede ser cero ni negativo");
                intentos--;
                continue;
            }
            System.out.println("Digite la cantidad de lados: ");
            cantidadlados = lector.nextInt();
            if (cantidadlados <= 0) {
                System.out.println("No puede ser cero ni negativo");
                intentos--;
                continue;
            }
            System.out.println("Digite la radio mayor: ");
            radiomayor = lector.nextDouble();
            if (radiomayor <= 0) {
                System.out.println("No puede ser cero ni negativo");
                intentos--;
                continue;
            }
            System.out.println("Digite el radio: ");
            radio = lector.nextDouble();
            if (radio <= 0) {
                System.out.println("No puede ser cero ni negativo");
                intentos--;
                continue;
            }
            break;
        }
        if (intentos == 0) {
            System.out.println("Se han agotado los intentos");
        } else {
            double alfa = (Math.PI / 180) * (360 / cantidadlados);
            apotemabase = longitud / (2 * Math.tan(alfa / 2));
            apotemapiramide = Math.pow(altura, 2) + (Math.pow(apotemabase, 2));
            perimetrobasemayor = cantidadlados * longitud;
            perimetrobasemenor = 2 * Math.PI * radio;
            arealateral = (perimetrobasemayor + perimetrobasemenor) / 2 * apotemapiramide;
            areabasemayor = Math.PI * Math.pow(radiomayor, 2);
            areabasemenor = Math.PI * Math.pow(radio, 2);
            areatotal = arealateral + areabasemayor + areabasemenor;
            volumen = (1 / 3.0) * altura * (areabasemayor + areabasemenor + Math.sqrt(areabasemayor * areabasemenor));
            System.out.println("Area lateral: " + arealateral + " unidades cuadradas.");
            System.out.println("Area total: " + areatotal + " unidades cuadradas.");
            System.out.println("Volumen: " + volumen + " unidades cúbicas.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Entrada no válida, Por favor ingrese un número válido.");
        lector.nextLine();
    } catch (ArithmeticException e) {
        System.out.println("Error aritmético: " + e.getMessage());
    }
}
    public static void husoesferico() {
        int intentosRestantes=0;
        if (intentosRestantes <= 0) {
            System.out.println("Se han agotado los intentos");
            return;
        }
    try{
        int radio;
        double area, volumen, numero;
        System.out.println("Digite el radio: ");
        radio = lector.nextInt();
        if (radio <= 0) {
            System.out.println("No puede ser cero ni negativo");
            return;
        }

        System.out.println("Digite el número de grados: ");
        numero = lector.nextInt();
        if (numero <= 0) {
            System.out.println("No puede ser cero ni negativo");
            return;
        }
        area = (4 * Math.PI * radio * radio * numero) / 360;
        volumen = (4.0 / 3) * (Math.PI * Math.pow(radio, 3) * numero) / 360;
        System.out.println("Área: " + area);
        System.out.println("Volumen: " + volumen);
    } catch (InputMismatchException e) {
            System.out.println("Entrada no válida, Por favor ingrese un número válido.");
            lector.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
    public static void tetradeo() {
        int intentosRestantes = 3;
        while (intentosRestantes > 0) {
            try {
                System.out.print("Digite la base: ");
                int areabase = lector.nextInt();
                if (areabase <= 0) {
                    System.out.println("La base no puede ser cero ni negativa");
                    intentosRestantes--;
                } else {
                    double area = Math.pow(areabase, 2) * Math.sqrt(3);
                    double volumen = (Math.sqrt(2)) / 12 * Math.pow(areabase, 3);
                    System.out.println("Área: " + area);
                    System.out.println("Volumen: " + volumen);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número válido.");
                lector.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());
            }
        }
        if (intentosRestantes == 0) {
            System.out.println("Se han agotado los intentos");
        }
    }
    public static void Hexaedro() {
        int intentosRestantes = 3;
        while (intentosRestantes > 0) {
            try {
                System.out.print("Digite la base: ");
                int areabase = lector.nextInt();
                if (areabase <= 0) {
                    System.out.println("La base no puede ser cero ni negativa");
                    intentosRestantes--;
                } else {
                    double area = 6 * Math.pow(areabase, 2);
                    double volumen = Math.pow(areabase, 3);
                    System.out.println("Área: " + area);
                    System.out.println("Volumen: " + volumen);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número válido.");
                lector.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());
            }
        }
        if (intentosRestantes == 0) {
            System.out.println("Se han agotado los intentos");
        }
    }
    public static void Octaedro() {
        int intentosRestantes = 3;
        while (intentosRestantes > 0) {
        try{
            System.out.print("Digite la base: ");
            int areabase = lector.nextInt();
            if (areabase <= 0) {
                System.out.println("La base no puede ser cero ni negativa");
                intentosRestantes--;
            } else {
                double area = 2 * Math.pow(areabase, 2) * Math.sqrt(3);
                double volumen = (Math.sqrt(2)) / 3 * Math.pow(areabase, 3);
                System.out.println("Área: " + area);
                System.out.println("Volumen: " + volumen);
                break;
            }
        } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número válido.");
                lector.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());
            }
        }
        if (intentosRestantes == 0) {
            System.out.println("Se han agotado los intentos");
        }
    }
    public static void Dodecaedro() {
        int intentosRestantes = 3;
        while (intentosRestantes > 0) {
        try{
            System.out.print("Digite la base: ");
            int areabase = lector.nextInt();
            if (areabase <= 0) {
                System.out.println("La base no puede ser cero ni negativa");
                intentosRestantes--;
            } else {
                double area = 3 * Math.pow(areabase, 2) * Math.sqrt(25 + 10) * Math.sqrt(5);
                double volumen = (1.0 / 4) * (15 + 7 * Math.sqrt(5)) * Math.pow(areabase, 3);
                System.out.println("Área: " + area);
                System.out.println("Volumen: " + volumen);
                break;
            }
        } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número válido.");
                lector.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());
            }
        }
        if (intentosRestantes == 0) {
            System.out.println("Se han agotado los intentos");
        }
    }
    public static void Isoedro() {
        int intentosRestantes = 3;
        while (intentosRestantes > 0) {
        try{
            System.out.print("Digite la base: ");
            int areabase = lector.nextInt();
            if (areabase <= 0) {
                System.out.println("La base no puede ser cero ni negativa");
                intentosRestantes--;
            } else {
                double area = 5 * Math.pow(areabase, 2) * Math.sqrt(3);
                double volumen = (5.0 / 12) * (3 + Math.sqrt(15)) * Math.pow(areabase, 3);
                System.out.println("Área: " + area);
                System.out.println("Volumen: " + volumen);
                break;
            }
        } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número válido.");
                lector.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());
            }
        }
        if (intentosRestantes == 0) {
            System.out.println("Se han agotado los intentos");
        }
    }
    public static void Ortoedro() {
        int intentosRestantes = 3;
        while (intentosRestantes > 0) {
            try {
                System.out.print("Digite la altura: ");
                double altura = lector.nextDouble();
                if (altura <= 0) {
                    System.out.println("No puede ser cero ni negativo");
                    intentosRestantes--;
                } else {
                    System.out.print("Digite la longitud: ");
                    double longitud = lector.nextDouble();
                    if (longitud <= 0) {
                        System.out.println("No puede ser cero ni negativo");
                        intentosRestantes--;
                    } else {
                        System.out.print("Digite la profundidad: ");
                        double profundidad = lector.nextDouble();
                        if (profundidad <= 0) {
                            System.out.println("No puede ser cero ni negativo");
                            intentosRestantes--;
                        } else {
                            double area = 2 * (altura * longitud + altura * profundidad + longitud * profundidad);
                            double diagonal = Math.sqrt(altura * altura + longitud * longitud + profundidad * profundidad);
                            double volumen = altura * longitud * profundidad;
                            System.out.println("Área: " + area);
                            System.out.println("Volumen: " + volumen);
                            System.out.println("Diagonal: " + diagonal);
                            break;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, Por favor ingrese un número válido");
                lector.nextLine();
            }
        }
        if (intentosRestantes == 0) {
            System.out.println("Se han agotado los intentos");
        }
    }
    public static void salirdelprograma() {
        System.out.println("¡Adiós!");
    }
}
