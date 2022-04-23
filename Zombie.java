public class Zombie {

    private String nombre;
    private double salud;
    private int añoNacimiento;
    private String tipoSangre;

    public Zombie(String nombre) {
        this.nombre = nombre;
    }

    public Zombie(String nombre, double salud, int año, String sangre){
        this.nombre = nombre;
        this.salud = salud;
        this.añoNacimiento = año;
        this.tipoSangre = sangre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public double setSalud(double salud){
        this.salud = salud;
        return salud;
    }

    public void setFechaNacimiento(int fecha){
        this.añoNacimiento = fecha;
    }

    public void setTipoSangre(String sangre){
        this.tipoSangre = sangre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getFechaNacimiento(){
        return this.añoNacimiento;
    }

    public double getSalud(){
        return this.salud;
    }

    public String getTipoSangre(){
        return this.tipoSangre;

    }

    public String toString(){
        return  "(Nombre: " + this.nombre + " | Salud: " + this.salud + " | Año: " + this.añoNacimiento + " | Tipo de Sangre: " + this.tipoSangre + ")" ;
    }

    public static void guardarInformaciónZombies(String nombre1, double salud1, int fecha1, String tipoSangre1) { //case 1
        Zombie zombie1 = new Zombie(nombre1,salud1, fecha1, tipoSangre1);
        Principal.zombies.add(zombie1);
    }

    public static int verCantidadZombies() { // case 3
        int contador = 0;
        for(int i = 0; i < Principal.zombies.size(); i ++) {
            if (Principal.zombies.get(i) != null)
                contador++;
        }
        return contador;

    }

    public static void lanzarBomba() {// case 6
        for(int i = 0; i < Principal.zombies.size(); i++) {
            Principal.zombies.get(i).setSalud(Principal.zombies.get(i).getSalud() / 2);

        }
    }

    public static String verFraseAleatoria() { // case 11
        String[] frasesAleatorias = new String[] {"'Soy un Zombie'", "'Quiero cerebros'", "'Nadie quiere abrazar a un zombie'", "'Brains'", "'Rick es el mejor sheriff de The Walking Dead'", "'Solo sobreviven los más fuertes e inteligentes'", "'Te ha mordido un zombie'", "'Los zombies nos invaden'"};
        java.util.Random random = new java.util.Random();
        int elementoRandom = random.nextInt(frasesAleatorias.length);
        return frasesAleatorias[elementoRandom];
    }
}