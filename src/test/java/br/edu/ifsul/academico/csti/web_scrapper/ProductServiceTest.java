package br.edu.ifsul.academico.csti.web_scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {
    ProductService productService = new ProductService();

    @Test
    public void testExtractionWitchValidHtml() {
        String html = "<html><body>" +
                "<h1 class='product-name'>Produto Teste</h1>" +
                "<div class='price-box__saleInCents'>R$ 99,99</div>" +
                "<div class='feature__main-content'>Descrição do produto.</div>" +
                "<img class='carousel-item-figure__image' src='imagem.jpg'/>" +
                "</body></html>";
        Document document = Jsoup.parse(html);
        ProductModel product = productService.extractProduct(document);

        assertNotNull(product);
        assertEquals("Produto Teste", product.getTitle());
        assertEquals("R$ 99,99", product.getPrice());
        assertEquals("Descrição do produto.", product.getDescription());
        assertEquals("imagem.jpg", product.getImageUrl());
    }

    @Test
    public void testInvalidSelectors() {
        String html = "<html><body><p>Test</p></body></html>";
        Document document = Jsoup.parse(html);
        ProductModel product = productService.extractProduct(document);

        assertNull(product);
    }

    @Test
    public void testExtractionWitchInvalidHtml() {
        String url = "http://url-fake-para-teste.com";
        ProductModel product = productService.extractProduct(Jsoup.parse(url));
        assertNull(product);
    }
}
