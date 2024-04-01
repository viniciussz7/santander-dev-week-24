package me.dio.sdw2024.application;

import me.dio.sdw2024.domain.exception.ChampionNotFoundException;
import me.dio.sdw2024.domain.model.Champion;
import me.dio.sdw2024.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);
        //TODO: Evoluir a logica de negocio para considerar a integracao com IAs generativas.

        return championContext;
    }
}
