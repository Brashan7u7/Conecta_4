public class jugador {

    private String nombre;
    private int ganadas, perdidas, ficha;
    private String f;

    public jugador() {
        this.nombre = nombre;
        this.ficha = ficha;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.f = f;

        if (ficha == 1) {
            f = "X";
        } else {
            f = "O";
        }

    }

    public void mostrarJugador() {
        System.out.println("El jugador: " + nombre +
                "\n\n Gano: " + ganadas +
                "\n Perdió: " + perdidas);
    }

    public String getNombre() {
        return nombre;
    }

    public int getGanadas() {
        return ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getFicha() {
        return ficha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

}
