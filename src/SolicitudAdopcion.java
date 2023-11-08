public class SolicitudAdopcion {
    private Adoptante adoptante;
    private Animal animal;
    private String estado;

    public SolicitudAdopcion(Adoptante adoptante, Animal animal) {
        this.adoptante = adoptante;
        this.animal = animal;
        this.estado = "pendiente"; // Inicialmente, la solicitud esta pendiente
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
