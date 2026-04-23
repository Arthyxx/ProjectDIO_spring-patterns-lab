package one.digitalinnovation.gof.service;


import one.digitalinnovation.gof.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    List<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir (Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
