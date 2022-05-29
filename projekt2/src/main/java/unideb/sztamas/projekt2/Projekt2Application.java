package unideb.sztamas.projekt2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Projekt2Application {

	@SpringBootApplication
	public class RestServiceCorsApplication {

		public static void main(String[] args) {
			SpringApplication.run(RestServiceCorsApplication.class, args);
		}


		@Bean
		CommandLineRunner initDatabase(MovieDAO dao) {
			return args -> {
				dao.save(new Movie("Citizen Kane", "Orson Welles", 1941));
				dao.save(new Movie("Metropolis", "Fritz Lang", 1921));
				dao.save(new Movie("City lights", "Charlie Chaplin", 1932));
				dao.save(new Movie("The General", "Buster Keaton", 1923));
				dao.save(new Movie("For a handful of dollars", "Sergio Leone", 1961));
				dao.save(new Movie("The Dark Knight", "Christoper Nolan", 2008));
				dao.save(new Movie("Django Unchained", "Quentin Tarantino", 2012));
			};
		}
	}
}
