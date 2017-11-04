package uy.com.hackoverflow.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import uy.com.hackoverflow.models.Location;
import uy.com.hackoverflow.models.Place;
import uy.com.hackoverflow.models.User;
import uy.com.hackoverflow.models.Workshop;
import uy.com.hackoverflow.repositories.LocationRepository;
import uy.com.hackoverflow.repositories.PlaceRepository;
import uy.com.hackoverflow.repositories.UserRepository;
import uy.com.hackoverflow.repositories.WorkshopRepository;

import java.util.logging.Logger;

/**
 * Created by emiliano on  25/10/17.
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PlaceRepository placeRepository;

    private Logger log = Logger.getLogger(String.valueOf(DataLoader.class));

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("LOADING USERS...");
        loadUsers();
        log.info("LOADING WORKSHOPS...");
        loadWorkshops();
    }

    private void loadUsers(){
        User u = new User();
        u.setNickname("hackoverflow");
        u.setEmail("hackoverflow@gmail.com");
        u.setUsername("Tito Desborde del Flujo");
        u.setDni("5123456");
        u.setPwd("1");
        u.setInstructor(true);
        u.setStudent(true);
        userRepository.save(u);
        log.info("SAVING USER: " + u.getId());

        User u2 = new User();
        u2.setNickname("instructor");
        u2.setEmail("instructor@gmail.com");
        u2.setUsername("Instructor Fernandez");
        u2.setDni("5123457");
        u2.setPwd("1");
        u2.setInstructor(true);
        u2.setStudent(false);
        userRepository.save(u2);
        log.info("SAVING USER: " + u.getId());

        User u3 = new User();
        u3.setNickname("estudiante");
        u3.setEmail("estudiante@gmail.com");
        u3.setUsername("Estudiante Gonzalez");
        u3.setDni("5123457");
        u3.setPwd("1");
        u3.setInstructor(false);
        u3.setStudent(true);
        userRepository.save(u3);
        log.info("SAVING USER: " + u.getId());
    }

    private void loadWorkshops(){
        // Places
        Location l = new Location();
        l.setCity("Montevideo");
        l.setState("Montevideo");
        l.setAddressLine("Rambla Charles De Gaulle, 11300 Montevideo");
        l.setLatitude(-34.910330);
        l.setLongitude(-56.138528);
        locationRepository.save(l);
        Location sl = locationRepository.findFirstById(l.getId());

        Place p = new Place();
        p.setName("Kibon AVANZA");
        p.setDescription("KIBON Avanza es el mejor lugar para realizar cualquier tipo de evento social, celebración, casamientos, conferencias o lanzamiento.\n" +
                "\n" +
                "Ofrecemos un servicio integral. Nuestro equipo de profesionales elabora la propuesta de acuerdo a las necesidades de cada cliente.\n" +
                "\n" +
                "Aseguramos la mejor vista de la ciudad tanto en el día como en la noche.\n" +
                "\n" +
                "Nuestra arquitectura está pensada para adaptar el salón para eventos más íntimos de 50 a 400 personas sin perder calidad, estilo y la maravillosa vista única de Montevideo.\n" +
                "\n" +
                "Nuestras dimensiones permiten realizar actividades para 900 personas en un banquete como a 1500 para un cocktail.");
        p.setCapacity(900);
        p.setPrice(0F);
        placeRepository.save(p);
        p.setLocation(sl);
        placeRepository.save(p);

        Workshop w = new Workshop();
        w.setName("Taller de programación en Python");
        w.setDescription("Although Python is an easy to learn and powerful programming language as it is known in common parlance, there is nevertheless need of a good introduction and tutorial on the Python language. \n" +
                "\n" +
                "Why yet another documentation and tutorial on Python? Aren't there enough websites with tutorials and books dealing with Python? Isn't there already everything said about this great programming language? \n" +
                "\n" +
                "These were the questions which came to our mind, when we started this website in June 2010. Yes, there are lots of tutorials and introductions, but we wanted to present a different approach, with other - more interesting - examples, better explanatory diagrams and so on. We had a lot to build on, above all the longstanding experience of Bernd Klein as a computer scientist and Python lecturer. Actually, this online course is based on the material from the classroom training courses of Bodenseo and his book on Python. "
        );
        w.setDate("2017-11-04T18:06:50-03:00");
        w.setFree(true);
        w.setPrice(0F);
        w.setPlace(p);
        workshopRepository.save(w);
//
//
//        Workshop w2 = new Workshop();
//        w2.setName("Taller de programación en Java");
//        w2.setDescription("Este curso está orientado principalmente a personas interesadas en conocer y profundizar sobre el lenguaje de la programación en Java para la creación y manipulación de objetos. Es necesario poseer un conocimiento previo de los conceptos básicos de programación, como el manejo de variables, las instrucciones de asignación, condicionales e iterativas y el concepto de algoritmo y función. De igual forma, el curso cuenta con un espacio de auto-evaluación sobre estos conocimientos previos y le ofrece material de ayuda que le permitirá nivelarse y participar en el curso.");
//        w2.setDate("2017-15-04T18:06:50-03:00");
//        w2.setFree(false);
//        w2.setPrice(200F);
//        w2.setPlace(p);
//        workshopRepository.save(w2);

    }
}
