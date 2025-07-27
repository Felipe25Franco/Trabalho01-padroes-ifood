import java.util.ArrayList;
import java.util.List;

public class LancheComposto implements Lanche{

    private List<Lanche> lanches = new ArrayList<>();

    public void adicionar(Lanche lanche) {
        lanches.add(lanche);
    }


    public float getPreco() {
        float total = 0f;
        for (Lanche lanche : lanches) {
            total += lanche.getPreco();
        }
        return total;
    }

    public String getDescricao() {
        StringBuilder descricao = new StringBuilder("Combo: ");
        for (int i = 0; i < lanches.size(); i++) {
            descricao.append(lanches.get(i).getDescricao());
            if (i < lanches.size() - 1) {
                descricao.append(", ");
            }
        }
        return descricao.toString();
    }
}
