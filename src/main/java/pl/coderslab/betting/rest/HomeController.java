package pl.coderslab.betting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.betting.entity.*;
import pl.coderslab.betting.repository.LeagueRepository;
import pl.coderslab.betting.repository.SportRepository;
import pl.coderslab.betting.repository.TeamRepository;
import pl.coderslab.betting.repository.UserRepository;
import pl.coderslab.betting.service.CountryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private CountryService countryService;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/get-countries")
    public String getCountries() {

        String url = "http://localhost:8080/api/fake-countries";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Country[]> responseCountries = (restTemplate.getForEntity(url,Country[].class));

        Country[] countries = responseCountries.getBody();

        for (Country country: countries) {
            logger.info("countries {}", country);
            countryService.saveCountry(country);
        }

        return "Result saved successfully";
    }

    @GetMapping("/get-teams")
    public String getTeams() {

        String url = "http://localhost:8080/api/fake-teams";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Team[]> responseGames = restTemplate.getForEntity(url, Team[].class);

        Team[] teams = responseGames.getBody();

        for (Team team: teams) {

            Random rand = new Random();
            int random = rand.nextInt(10);

            logger.info("teams {}", teams);
            team.setLeague(leagueRepository.findAll().get(random));
            teamRepository.save(team);
        }

        return "Result given";
    }

    @GetMapping("/get-leagues")
    public String getLeagues() {

        String url = "http://localhost:8080/api/fake-leagues";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<League[]> responseLeague = restTemplate.getForEntity(url, League[].class);

        League[] leagues = responseLeague.getBody();



        for (League league: leagues) {
            Random rand = new Random();
            int random = rand.nextInt(10);

            logger.info("leagues {}", league);
            league.setCountry(countryService.findAllCountries().get(random));
            league.setSport(sportRepository.findAll().get(random));
            leagueRepository.save(league);
        }

        return "Result given";
    }

    @GetMapping("/get-users")
    public String getUsers() {

        String url = "http://localhost:8080/api/fake-users";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User[]> responseUsers = restTemplate.getForEntity(url, User[].class);

        User[] users = responseUsers.getBody();

        for (User user: users) {
            logger.info("users {}", users);
            userRepository.save(user);
        }

        return "Result given";
    }

    @GetMapping("/get-sports")
    public String getSports() {

        String url = "http://localhost:8080/api/fake-sports";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Sport[]> responseSports = restTemplate.getForEntity(url, Sport[].class);

        Sport[] sports = responseSports.getBody();

        for (Sport sport: sports) {
            Random rand = new Random();
            int random = rand.nextInt(10);

            logger.info("sports {}", sports);
            sportRepository.save(sport);
        }

        return "Result given";
    }

}
