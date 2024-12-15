package com.rdaltio.bffagendadortarefas.business;


import com.rdaltio.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.rdaltio.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rdaltio.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.rdaltio.bffagendadortarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dateFinal,
                                                                    String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dateFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefaPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(String id, StatusNotificacaoEnum status, String token) {
        return tarefasClient.alteraStatusNotificacao(id, status, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token){
        return tarefasClient.updateTarefas(dto, id, token);
    }
}
