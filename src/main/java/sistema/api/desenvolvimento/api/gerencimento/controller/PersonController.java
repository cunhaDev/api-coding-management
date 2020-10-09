package sistema.api.desenvolvimento.api.gerencimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema.api.desenvolvimento.api.gerencimento.dto.MessageResponseDTO;
import sistema.api.desenvolvimento.api.gerencimento.entity.Person;
import sistema.api.desenvolvimento.api.gerencimento.repositorio.PersonRepositorio;

@RestController
@RequestMapping("/api/v1/people")

public  class  PersonController {

    private PersonRepositorio personRepositorio;

    @Autowired
    public PersonController(PersonRepositorio personRepositorio) {
        this.personRepositorio = personRepositorio;
    }

    @PostMapping
    public MessageResponseDTO createPerson (@RequestBody Person person) {
        Person savedPerson = personRepositorio.save(person);
        return MessageResponseDTO
                .builder()
                .message("created person with ID " + savedPerson.getId())
                .build();
    }
}

