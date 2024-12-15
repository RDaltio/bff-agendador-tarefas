package com.rdaltio.bffagendadortarefas.infrastructure.client.config;

import com.rdaltio.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.rdaltio.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro, atributo já existente");
            case 403:
                return new ConflictException("Eroo, atributo não encontrado");
            case 401:
                return new ConflictException("Erro, usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
