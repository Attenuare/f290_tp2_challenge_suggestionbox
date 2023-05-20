package br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.api.v1.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.entities.Category;
import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private final CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @PostMapping(value = "/new", consumes={"*/*"})
    public ResponseEntity<Void> save(@RequestBody Category category) {
        service.salvar(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAll();
        return ResponseEntity.ok(categories);
    }
}
