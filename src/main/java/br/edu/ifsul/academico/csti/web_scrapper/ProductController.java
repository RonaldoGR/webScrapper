package br.edu.ifsul.academico.csti.web_scrapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

   @GetMapping("/product")
    public ProductModel getProduct(@RequestParam String url) {
        try {
            System.out.println(productService.extractProductFromUrl(url));
            return productService.extractProductFromUrl(url);
        } catch (Exception e) {
            System.err.println("Erro ao extrair dados da URL: " + e);
            return null;
        }
   }
}
