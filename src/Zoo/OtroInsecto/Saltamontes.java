/*
    ZOOILÓGICO: INSECTO: SALTAMONTES

    Por Servando Pestano San Segundo
    DAM-S-1-B

*/

package Zoo.OtroInsecto;
import java.util.Random;

public class Saltamontes extends OtroInsecto {

    // Atributos propios
    private static final String[] ESPECIES = { "común", "de pradera", "palo", "narigudo", "hoja",
        "de camuflaje", "de color llamativo", "de color de advertencia", "en fase gregaria (langosta)" };
    private String ordenYEspecie;

    // Setters

    // Getters

    // Constructor sin parámetros
    public Saltamontes() {

        super();
        Random r = new Random();
        setColor( COLORES[ r.nextInt( COLORES.length ) ] );
        setTieneAlas( r.nextBoolean() );
        ordenYEspecie = "saltamontes " + ESPECIES[ r.nextInt( ESPECIES.length ) ];

    }

    // Constructor con parámetros
    public Saltamontes( String nombre, int edad, float peso, boolean tieneAlas, String color ) {

        super( nombre, edad, peso, tieneAlas, color );
        Random r = new Random();
        ordenYEspecie = "saltamontes " + ESPECIES[ r.nextInt( ESPECIES.length ) ];
    }

    // Comportamiento propio: Saltar
    public void saltar() {

        // ini. info del salto
        String infoSalto = "";

        // composición de la info del salto
        int longitudSalto; // en centímetros
        String[] destinoSalto = {
                "hacia el borde del estanque",
                "a la rama del sauce",
                "sobre el nenúfar",
                "por encima del riachuelo",
                "entre la alfalfa",
                "entre las flores",
                "hacia el descampado"
        };
        String[] motivoSalto = {
                "escapando de la rana",
                "buscando hojas tiernas",
                "escondiéndose del cernícalo",
                "escabulléndose de la araña lobo",
                "huyendo de la mantis",
                "buscando agua",
                "buscando frutos secos"
        };

        // aleatorio de longitud, destino y motivo del salto
        Random r = new Random();
        longitudSalto  = r.nextInt( 100 ) + 15;
        int des = r.nextInt( destinoSalto.length );
        int mot = r.nextInt( motivoSalto.length );

        // construyo-muestro info salto
        infoSalto = "%s, el %s, saltó %d centímetros %s %s.\n";
        System.out.printf( infoSalto, this.getNombre(), ordenYEspecie,
                            longitudSalto, destinoSalto[ des ], motivoSalto[ mot ] );
    }

    // Comportamiento propio: Producir sonidos
    public void producirSonidos() {

        // info. sonido
        String infoSonido = "";

        // motivo del sonido
        boolean huboEstridulacion;
        String [] motivoNoSonido = { "cercanía de una mantis",
                                    "cercanía de una araña lobo",
                                    "cercanía de una chinche asesina",
                                    "incendio",
                                    "ser de noche" };
        String [] motivoSonido = { "cortejo y reproducción",
                                    "proclamación",
                                    "rivalidad",
                                    "estrés",
                                    "alerta"
        };

        // ¿hubo sonido?
        Random r = new Random();
        if ( true == ( huboEstridulacion = r.nextBoolean() ) )
            infoSonido = motivoSonido[ r.nextInt( motivoNoSonido.length ) ];
        else
            infoSonido = motivoNoSonido[ r.nextInt( motivoSonido.length ) ];
        // muestro info
        System.out.printf( ( huboEstridulacion ? "E" : "No hay e") + "stridulación de %s, el %s, por %s.\n",
                                this.getNombre(), ordenYEspecie, infoSonido );
    }

    // Comportamiento diferenciado: Comer
    @Override
    public void comer() {

        String[] queCome = { "pasto", "trébol", "alfalfa", "trigo", "maíz", "cebada", // Hierbas y gramíneas
                "hojas tiernas", "tallos", "brotes", "flores", // Partes de plantas
                "semillas", "cereales", "frutos secos", "fruta", "verdura", // Otros vegetales
                "insectos" // Ocasionalmente
        };
        Random r = new Random();
        String infoComida = "%s, el %s, está comiendo " + queCome[ r.nextInt( queCome.length ) ] + ".\n";
        System.out.printf( infoComida, this.getNombre(), ordenYEspecie );
    }

    // Comportamiento diferenciado: Moverse
    @Override
    public void moverse() {

        String[] porDonde = { "entre los campos de cultivos", "entre praderas y pastizales",
                "en zonas áridas y desérticas", "en bosques y selvas", "en un jardín urbano" };
        Random r = new Random();
        String infoMovimiento = "%s, el %s, se está moviendo " + porDonde[ r.nextInt( porDonde.length ) ] + ".\n";
        System.out.printf( infoMovimiento, this.getNombre(), ordenYEspecie );
    }

    // Comportamiento diferenciado: Dormir
    @Override
    public void dormir() {
        System.out.printf( "%s, el %s, está entrando en estado de letargo o torpor.\n",
                this.getNombre(), ordenYEspecie );
    }

    // Ver animal
    @Override
    public void verAnimal() {

        Random random = new Random();
        Runnable[] acciones = {
                // comunes
                this::moverAntenas,
                this::buscarRefugio,
                this::detectarVibraciones,
                // diferenciadas
                this::dormir,
                this::moverse,
                this::comer,
                // propias
                this::saltar,
                this::producirSonidos
        };

        try {
            for ( int i = 0; i < 3; i++ ) {
                int indiceAccion = random.nextInt( acciones.length );
                acciones[ indiceAccion ].run();

                int tiempoEspera = random.nextInt(2000 ) + 1000;
                Thread.sleep( tiempoEspera );
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
