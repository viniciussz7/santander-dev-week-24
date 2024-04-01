package me.dio.sdw2024.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw2024.application.ListChampionsUseCase;
import me.dio.sdw2024.domain.model.Champion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Champions", description = "Endpoints do dominio de campeoes do LOL.")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @GetMapping
    public List<Champion> findAllChampions() { //ideal criar DTO
        return useCase.findAll();
    }
}
