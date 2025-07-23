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
        Element titleElem = document.selectFirst("h1.product-name");
        Element priceElem = document.selectFirst("div.price-box__saleInCents");
        Element descriptionElem = document.selectFirst("div.feature__main-content");
        Element imgElem = document.selectFirst("img.carousel-item-figure__image");

        if (titleElem == null && priceElem == null && descriptionElem == null && imgElem == null) {
            return null;
        }

        String title = titleElem != null ? titleElem.text() : "";
        String price = priceElem != null ? priceElem.text() : "";
        String description = descriptionElem != null ? descriptionElem.text() : "";
        String imageUrl = imgElem != null ? imgElem.attr("src") : "";
        return new ProductModel(title, price, description, imageUrl);
    }
}
