package me.dio.sdw2024.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw2024.application.AskChampionUseCase;
import me.dio.sdw2024.application.ListChampionsUseCase;
import me.dio.sdw2024.domain.model.Champion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Champions", description = "Endpoints do dominio de campeoes do LOL.")
@RestController
@RequestMapping("/champions")
public record AskhampionRestController(AskChampionUseCase useCase) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {

        String answer = useCase.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest (String question) {}
    public record AskChampionResponse (String answer) {}
}
