package unideb.sztamas.projekt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin
@Service
public class MovieController {



    @Autowired
    private MovieDAO dao;


    @GetMapping("/movies/get")
    @CrossOrigin
    List<Movie> findAll() {
        return dao.findAll();
    }

    @GetMapping("/movie/get")
    @CrossOrigin
    public Movie getMovie(@RequestParam long id){
        System.out.println("here you go a movie");

        return dao.findById(id).get();
    }
    @PostMapping("/movie/save")
    @CrossOrigin
    public Movie SaveMovie(@RequestBody Movie movie){
        System.out.println("you uploaded a movie");
        return dao.save(movie);
    }
    @PutMapping("/movie/update/{id}")
    @CrossOrigin
    public Movie UpdateMovie(@RequestBody Movie movie,@PathVariable long id){
        System.out.println("you updated a movie");
        return dao.findById(id)
                .map(x -> {
                    x.setTitle(movie.getTitle());
                    x.setId(movie.getId());
                    x.setDirector(movie.getDirector());
                    x.setYear(movie.getYear());
                    return dao.save(x);
                })
                .orElseGet(() -> {
                    movie.setId(id);
                    return dao.save(movie);
                });
    }

    @GetMapping("/movie/delete/{id}")
    @CrossOrigin
    public void DeleteMovie(@PathVariable long id){
        System.out.println("you deleted a movie");
         dao.deleteById(id);
    }

}
