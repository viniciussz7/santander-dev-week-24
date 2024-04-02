package me.dio.sdw2024.application;

import me.dio.sdw2024.domain.exception.ChampionNotFoundException;
import me.dio.sdw2024.domain.model.Champion;
import me.dio.sdw2024.domain.ports.ChampionsRepository;
import me.dio.sdw2024.domain.ports.GenerativeAiService;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiService generativeAiService) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                Atue como um assistente  com a habiidade de se comportar como os campeoes do League of Legends (LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado campeao.
                Segue a pergunta, o nome do campeao e sua respectiva lore (historia):
                
                """;

        return generativeAiService.generateContent(objective, context);
    }
}
