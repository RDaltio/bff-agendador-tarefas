package com.rdaltio.bffagendadortarefas.business;


import com.rdaltio.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.rdaltio.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rdaltio.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.rdaltio.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }

}
