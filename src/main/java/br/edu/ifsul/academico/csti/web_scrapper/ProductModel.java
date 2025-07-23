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
    private Element title;
    private Element price;
    private Element description;
    private Element image;

    @Override
    public String toString() {
        return "\n+---------------------- Produto ----------------------+" +
                "\nTitulo: " + title.text() + '\'' +
                "\nPreço do produto: " + price.text() + '\'' +
                "\n+------------------------------------------------------ Descrição ------------------------------------------------------+\n" + description.text().replaceAll("\\.\\s*", ".\n") + '\'' +
                "\n+------------------------------------------------------------------------------------------------------------+" +
                "\nLink da imagem do produto: " + image.attr("src") + '\'';
    }
}
