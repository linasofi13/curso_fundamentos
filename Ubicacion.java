import java.util.ArrayList;
public class Ubicacion{

    private String nombre;
    float distancia;
    private int zombies;

    public Ubicacion(String nombre, float distancia, int zombies){
        this.nombre = nombre;
        this.distancia = distancia;
        this.zombies = zombies;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public void setZombies(int zombies) {
        this.zombies = zombies;
    }

    public String getNombre(){
        return this.nombre;
    }

    public float getDistancia(){
        return this.distancia;
    }

    public String toString(){
        return  "(Nombre: " + this.nombre + " | Distancia: " + this.distancia + " | Cantidad de Zombies: " + this.zombies ;
    }

    public int getZombies(){
        return this.zombies;
    }

    public static void guardarInformaciónUbicaciones(String nombre2, float distancia2, int cantidad2) { //case 7
        Ubicacion ubicacion1 = new Ubicacion(nombre2, distancia2, cantidad2);
        Principal.ubicaciones.add(ubicacion1);
    }

    public static void verUbicacionMasSegura() { // case 9
        Ubicacion valorMenor = Principal.ubicaciones.get(0);
        int min = Principal.ubicaciones.get(0).zombies;
        for (int i = 0; i < Principal.ubicaciones.size(); i++) {
            if (Principal.ubicaciones.get(i).zombies < min) {
                min = Principal.ubicaciones.get(i).zombies;
                valorMenor = Principal.ubicaciones.get(i);
            }

        }
        System.out.println("La ubicación mas segura es: "+ valorMenor.nombre);
    }

}
