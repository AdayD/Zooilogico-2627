package Zoo.Mamifero;

import Zoo.Animal;

import java.util.Random;

public class Mamifero extends Animal {
    private String tipoPelaje;
    private double temperaturaCorporal;
    private boolean esAcuatico;

    private static final String[] tiposPelajePosibles = {"rayado", "largo", "corto"};


    public Mamifero() {
        super();
        Random random = new Random();
        this.temperaturaCorporal = 30.0f + (50 - 0.5f) * random.nextFloat(); // Peso entre 0.5 y 10.0
        this.tipoPelaje = tiposPelajePosibles[random.nextInt(tiposPelajePosibles.length)];
    }
    public Mamifero(String nombre, int edad, float peso, String tipoPelaje, double temperaturaCorporal, boolean esAcuatico) {
        super(nombre, edad, peso);
        this.tipoPelaje = tipoPelaje;
        this.temperaturaCorporal = temperaturaCorporal;
        this.esAcuatico= esAcuatico;
    }

    public void amamantar(){System.out.println(getNombre() + " esta alimentando crias con leche.");}

    public void cuidarCrias(){System.out.println(getNombre() + " esta protegiendo sus crias");}

    public void regularTemperatura(){System.out.println(getNombre() + " esta regulando su temperatura");}


    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::amamantar,
                this::cuidarCrias,
                this::regularTemperatura
        };

        try {
            for (int i = 0; i < 3; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
