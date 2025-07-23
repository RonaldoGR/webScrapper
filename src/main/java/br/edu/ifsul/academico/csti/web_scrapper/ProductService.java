package br.edu.ifsul.academico.csti.web_scrapper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductModel extractProductFromUrl(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return extractProduct(document);
        } catch (Exception e) {
            System.err.println("Erro ao conectar na URL: " + e);
            return null;
        }
    }

    public ProductModel extractProduct(Document document) {
        Element title = document.selectFirst("h1.product-name");
        Element price = document.selectFirst("div.price-box__saleInCents");
        Element description = document.selectFirst("div.feature__main-content");
        Element img = document.selectFirst("img.carousel-item-figure__image");

        return new ProductModel(title, price, description, img);
    }
}
