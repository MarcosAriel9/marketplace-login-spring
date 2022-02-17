package mx.edu.utez.marketplace.subcategory.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return subcategoryService.findAll();
    }

    @GetMapping("/{subcategory}")
    public ResponseEntity<Message> getById(@PathVariable("subcategory") long id) {
        return subcategoryService.findById(id);
    }

    @GetMapping("/all/{category}")
    public ResponseEntity<Message> getByCategory(@PathVariable("category") long id) {
        return subcategoryService.findAllByCategory(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody SubcategoryDTO subcategoryDTO) {
        return subcategoryService.insert(new Subcategory(subcategoryDTO.getDescription(),
                subcategoryDTO.getStatus(), subcategoryDTO.getCategory()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody SubcategoryDTO subcategoryDTO) {
        return subcategoryService.insert(new Subcategory(subcategoryDTO.getId(), subcategoryDTO.getDescription(),
                subcategoryDTO.getStatus(), subcategoryDTO.getCategory()));
    }
}
