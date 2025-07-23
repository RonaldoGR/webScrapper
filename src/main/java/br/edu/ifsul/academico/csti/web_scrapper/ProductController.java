package br.edu.ifsul.academico.csti.web_scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ProductController {
    public static void main(String[] args) {
        String url = "https://www.netshoes.com.br/p/bicicleta-aro-26-colli-gps-freio-vbrake-aco-carbono-21-marchas-preto-I78-0282-006";

        try {

            Document document = Jsoup.connect(url).get();
            Element title = document.selectFirst("h1.product-name");
            Element price = document.selectFirst("div.price-box__saleInCents");
            Element description = document.selectFirst("div.feature__main-content");
            Element img = document.selectFirst("img.carousel-item-figure__image");

            ProductModel product = new ProductModel(title, price, description, img);

            System.out.println("\n\n");
            System.out.println(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
