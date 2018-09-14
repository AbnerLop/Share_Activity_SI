public class Persona {
    private float altura;
    private float peso;
    private float piesT;

    public Persona(float altura, float peso, float piesT) {
        this.altura = altura;
        this.peso = peso;
        this.piesT = piesT;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPiesT() {
        return piesT;
    }

    public void setPiesT(float piesT) {
        this.piesT = piesT;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "altura=" + altura +
                ", peso=" + peso +
                ", piesT=" + piesT +
                '}';
    }
}
