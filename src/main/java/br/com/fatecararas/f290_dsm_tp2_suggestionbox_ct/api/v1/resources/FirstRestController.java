package br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.api.v1.resources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.Suggestion;

@RestController
@RequestMapping("/")
public class FirstRestController {

    @GetMapping
    public ResponseEntity<?> helloApi() {
        System.out.println("Get: Passed throught the first controller!");
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> helloApiPost(@RequestBody Suggestion suggestion) {
        System.out.println("Post: Passed throught the first controller!");
        System.out.println("Response:\n");
        System.out.println(suggestion);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> helloApiDelete(@PathVariable Integer id) {
        System.out.println("Delete: Passed throught the first controller!");
        System.out.println("Response ID: " + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> helloApiPut(@PathVariable Integer id,
            @RequestBody Suggestion suggestion) {
        System.out.println("Put: Passed throught the first controller!");
        System.out.println("Response ID: " + id);
        System.out.println("Response ID: " + suggestion);

        if (suggestion.getId().equals(100)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Suggestion>> getAll() {
        List<Suggestion> all = Arrays.asList(
                new Suggestion(1, "Read a fictional book",
                        LocalDate.of(2023, 3, 2)),
                new Suggestion(2, "Drive around with a motocycle",
                        LocalDate.of(2023, 4, 2)),
                new Suggestion(3, "Writing a essay drinking a hot coffee",
                        LocalDate.of(2023, 5, 2)));

        return ResponseEntity.ok().body(all);
    }

}
