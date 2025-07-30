public class AvaliacaoNota {

    private float nota;

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
        this.nota = nota;
    }
}