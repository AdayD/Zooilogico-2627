package Zoo.Insecto;
import Zoo.Animal;

import java.util.Random;

public class Insecto extends Animal {

    // Atributos comunes
    private static final String [] COLORES = { "Rojo", "Verde", "Amarillo", "Marrón", "Negro", "Blanco", "Naranja",
            "Verde esmeralda", "Azul metálico" };
    private static final int NUMERO_PATAS = 6; // los insectos siempre tienen 3 pares de patas
    private int numeroPatas;
    private boolean tieneAlas;
    private String color;

    // Setters
    protected void setTieneAlas( boolean tieneAlas ) { this.tieneAlas = tieneAlas; }
    protected void setColor( String color ) { this.color = color; }

    // Getters
    protected int getNumeroPatas() { return this.numeroPatas; }
    protected boolean getTieneAlas() { return this.tieneAlas; }
    protected String getColor() { return this.color; }

    // Comportamientos comunes
    public void moverAntenas() {
        System.out.println( getNombre() + " mueve las antenas." );
    }
    public void buscarRefugio() {
        System.out.println( getNombre() + " busca refugio." );
    }
    public void detectarVibraciones() {
        System.out.println( getNombre() + " detecta vibraciones." );
    }

    // Constructor sin parámetros
    public Insecto() {
        super();
        Random r = new Random();
        this.numeroPatas = NUMERO_PATAS;
        this.tieneAlas = r.nextBoolean();
    }

    // Constructor con parámetros
    public Insecto( String nombre, int edad, float peso, /* int numeroPatas, */ boolean tieneAlas, String color ) {
        super( nombre, edad, peso );
        this.numeroPatas = NUMERO_PATAS;
        this.tieneAlas = tieneAlas;
        this.color = color;
    }

    // Ver animal
    @Override
    public void verAnimal() {
        Random random = new Random();
        // Lista de acciones posibles
        Runnable[] acciones = {
                this::moverAntenas,
                this::buscarRefugio,
                this::detectarVibraciones,
                this::comer,
                this::dormir,
                this::moverse
        };

        try {
            for ( int i = 0; i < 3; i++ ) { // Ejecuta 3 acciones aleatorias
                int indiceAccion = random.nextInt( acciones.length );
                acciones[ indiceAccion ].run(); // Ejecuta la acción seleccionada

                int tiempoEspera = random.nextInt( 2000 ) + 1000; // Espera entre 1 y 2 segundos
                Thread.sleep( tiempoEspera );
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}
