package br.edu.ifsul.academico.csti.web_scrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.nodes.Element;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductModel {
    private String title;
    private String price;
    private String description;
    private String imageUrl;

    @Override
    public String toString() {
        return "\n+---------------------- Produto ----------------------+" +
                "\nTitulo: " + title +
                "\nPreço do produto: " + price +
                "\n+------------------------------------------------------ Descrição ------------------------------------------------------+\n" + description.replaceAll("\\.\\s*", ".\n") +
                "\n+------------------------------------------------------------------------------------------------------------+" +
                "\nLink da imagem do produto: " + imageUrl;
    }
}
