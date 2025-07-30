public class AvaliacaoAdapter extends AvaliacaoNota {

    private IAvaliacao avaliacaoEstrela;

    public AvaliacaoAdapter(IAvaliacao avaliacaoEstrela) {
        this.avaliacaoEstrela = avaliacaoEstrela;
    }

    // Converte nota (0–10) para estrelas (0–5)
    public int recuperarAvaliacao() {
        float nota = this.getNota();
        int estrelas;

        if (nota >= 9.0f)
            estrelas = 5;
        else if (nota >= 8.0f)
            estrelas = 4;
        else if (nota >= 7.0f)
            estrelas = 3;
        else if (nota >= 5.0f)
            estrelas = 2;
        else if (nota >= 3.0f)
            estrelas = 1;
        else
            estrelas = 0;

        avaliacaoEstrela.setAvaliacao(estrelas);
        return estrelas;
    }

    // Converte estrelas para nota aproximada
    public void salvarAvaliacao() {
        int estrelas = avaliacaoEstrela.getAvaliacao();

        switch (estrelas) {
            case 5:
                this.setNota(9.5f);
                break;
            case 4:
                this.setNota(8.5f);
                break;
            case 3:
                this.setNota(7.5f);
                break;
            case 2:
                this.setNota(6.0f);
                break;
            case 1:
                this.setNota(4.0f);
                break;
            default:
                this.setNota(2.0f);
        }
    }
}

