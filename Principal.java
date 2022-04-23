import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
public class Principal  {

    public static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    public static ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();

    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        boolean sistema = true;
        while(sistema) {
            System.out.println("Bienvenido a a la comunidad Alexandria.");
            System.out.println("Ingrese un número del 0 al 12.");
            System.out.println("Ingrese 0 para finalizar el programa.");
            System.out.println(
                    "Ingrese 1 para digitar nombre, salud, fecha de nacimiento y tipo de sangre de un zombie.");
            System.out.println(
                    "Ingrese 2 para ver información la información de los zombies almacenados hasta el momento.");
            System.out.println("Ingrese 3 para ver a los zombies creados hasta el momento.");
            System.out.println("Ingrese 4 para ver a zombies con sangre O+ o AB.");
            System.out.println("Ingrese 5 para ver a zombies nacidos después del 2000.");
            System.out.println("Ingrese 6 para lanzar una bomba en toda la ciudad.");
            System.out.println(
                    "Ingrese 7 para digitar nombre, distancia a Alexandria y cantidad de zombies de una ubicación.");
            System.out.println("Ingrese 8 para ver las ubicaciones almacenadas hasta el momento.");
            System.out.println("Ingrese 9 para ver la ubicación más segura de la ciudad.");
            System.out.println("Ingrese 10 para ver todas las ubicaciones ordenadas por distancia a Alexandria.");
            System.out.println("Ingrese 11 para ver una frase aleatoria.");
            System.out.println("Ingrese 12 para crear un zombie mutante que ataque a los otros zombies.");
            int numero = scan.nextInt();
            switch(numero) {
                case 0:
                    System.out.println("Programa finalizado.");
                    sistema = false;
                    break;
                case 1:
                    System.out.println("Ingrese el nombre del zombie:");
                    String nombre1 = scan.next();
                    System.out.println("Ingrese salud del zombie:");
                    double salud1 = scan.nextDouble();
                    System.out.println("Ingrese el año de nacimiento del zombie:");
                    int fecha1 = scan.nextInt();
                    System.out.println("Ingrese el tipo de sangre del zombie:");
                    String tipoSangre1 = scan.next();
                    Zombie.guardarInformaciónZombies(nombre1, salud1, fecha1, tipoSangre1);
                    System.out.println("Zombie creado con éxito");
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal");
                    int menú = scan.nextInt();
                    break;
                case 2:
                    if(zombies.size() == 0) {
                        System.out.println("No hay ningún zombie almacenado hasta el momento.");
                        System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                        int menú1 = scan.nextInt();
                    }else{
                        Iterator<Zombie> arregloIterado = zombies.iterator();
                        while(arregloIterado.hasNext())
                        {
                            Zombie imprimir = arregloIterado.next();
                            System.out.println(imprimir);
                        }
                        System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                        int menú1 = scan.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("La cantidad de zombies es: " + Zombie.verCantidadZombies());
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú3 = scan.nextInt();
                    break;
                case 4:
                    for(int i=0; i< zombies.size(); i++){
                        if((zombies.get(i).getTipoSangre().equalsIgnoreCase("AB+") || zombies.get(i).getTipoSangre().equalsIgnoreCase("O+"))){
                            System.out.println(zombies.get(i));
                        }
                    }
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú4 = scan.nextInt();
                    break;
                case 5:
                    for(int i = 0; i < zombies.size(); i++) {
                        if(zombies.get(i).getFechaNacimiento() >= 2000) {
                            System.out.println(zombies.get(i));
                        }
                    }
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú5 = scan.nextInt();
                    break;
                case 6:
                    System.out.println("Usted ha lanzado una bomba que ha reducido la mitad de la vida de todos los zombies.");
                    System.out.println("Menos mal son bombas que solo afectan a los zombies.");
                    Zombie.lanzarBomba();
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú6 = scan.nextInt();
                    break;
                case 7:
                    System.out.println("Ingrese el nombre de la ubicación:");
                    String nombre2 = scan.next();
                    System.out.println("Ingrese la distancia en metros de la ubicación a Alexandria:");
                    float distancia2 = scan.nextFloat();
                    System.out.println("Ingrese la cantidad de zombies en la ubicación:");
                    int cantidad2 = scan.nextInt();
                    Ubicacion.guardarInformaciónUbicaciones(nombre2, distancia2, cantidad2);
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú7 = scan.nextInt();
                    break;
                case 8:
                    if(ubicaciones.size() == 0) {
                        System.out.println("No hay ninguna ubicación almacenada hasta el momento.");
                        System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                        int menú8 = scan.nextInt();
                    }else{
                        Iterator<Ubicacion> arregloIterado2 = ubicaciones.iterator();
                        while(arregloIterado2.hasNext())
                        {
                            Ubicacion imprimir = arregloIterado2.next();
                            System.out.println(imprimir);
                        }
                    }System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú1 = scan.nextInt();
                    break;
                case 9:
                    Principal.verUbicacionMasSegura();
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú9 = scan.nextInt();
                    break;
                case 10:
                    Principal.verUbicacionesOrdenadas(ubicaciones);
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú10 = scan.nextInt();
                    break;
                case 11:
                    System.out.println(Zombie.verFraseAleatoria());
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú11 = scan.nextInt();
                    break;
                case 12:
                    System.out.println("Solo los zombies no centennials se vuelven súper zombies.");
                    Principal.crearSuperZombie();
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú12 = scan.nextInt();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Pulse cualquier número del teclado para volver al menú principal.");
                    int menú13 = scan.nextInt();
                    break;
            }
        }
    }public static void verUbicacionMasSegura() { // case 9
        Ubicacion valorMenor = Principal.ubicaciones.get(0);
        int min = Principal.ubicaciones.get(0).getZombies();
        for (int i = 0; i < Principal.ubicaciones.size(); i++) {
            if (Principal.ubicaciones.get(i).getZombies() < min) {
                min = Principal.ubicaciones.get(i).getZombies();
                valorMenor = Principal.ubicaciones.get(i);
            }
        }
        System.out.println("La ubicación mas segura es: "+ valorMenor.getNombre());
    }
    public static void verUbicacionesOrdenadas(ArrayList<Ubicacion>ubicaciones){ //case 10
        int distanciaMenor;
        float temp;
        for (int i = 0; i < ubicaciones.size() - 1; i++) {
            distanciaMenor = i;
            for (int j = i + 1; j < ubicaciones.size(); j++) {
                if (ubicaciones.get(j).getDistancia() < ubicaciones.get(distanciaMenor).getDistancia()){
                    distanciaMenor = j;
                }
            }
            temp = ubicaciones.get(i).getDistancia();
            ubicaciones.get(i).setDistancia(ubicaciones.get(distanciaMenor).getDistancia());
            ubicaciones.get(distanciaMenor).setDistancia(temp);
        }
        for(int i = 0; i<ubicaciones.size(); i++) {
            System.out.println(ubicaciones.get(i));
        }

    }public static void crearSuperZombie(){ //case 12
        double superSalud;
        double aumento = 6;
        for(int i = 0; i < Principal.zombies.size(); i++){
            if(Principal.zombies.get(i).getFechaNacimiento() < 2000){
                superSalud = (Principal.zombies.get(i).getSalud()* aumento);
                System.out.println(Principal.zombies.get(i).getNombre()+" se ha convertido en Super Zombie " + "Aumenta su salud: "+Principal.zombies.get(i).setSalud(superSalud));
                Principal.zombies.get(i).setSalud(Principal.zombies.get(i).getSalud() / 3);
            }
        }
    }
}
