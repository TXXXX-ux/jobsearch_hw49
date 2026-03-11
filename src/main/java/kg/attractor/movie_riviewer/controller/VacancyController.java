package kg.attractor.movie_riviewer.controller;

import kg.attractor.movie_riviewer.model.Vacancy;
import kg.attractor.movie_riviewer.repository.VacancyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class VacancyController {

    private final VacancyRepository vacancyRepository;

    public VacancyController(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;

        this.vacancyRepository.save(Vacancy.builder()
                .id(1)
                .name("Java Developer")
                .description("Нужен спец, который шарит в Spring")
                .salary(1500.0)
                .isActive(true)
                .createdDate(LocalDateTime.now())
                .build());
    }

    @GetMapping("/vacancies")
    public List<Vacancy> getVacancies() {
        return vacancyRepository.findAll();
    }
}