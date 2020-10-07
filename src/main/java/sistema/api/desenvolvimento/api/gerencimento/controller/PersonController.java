package sistema.api.desenvolvimento.api.gerencimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema.api.desenvolvimento.api.gerencimento.entity.Person;
import sistema.api.desenvolvimento.api.gerencimento.repositorio.PersonRepositorio;

@RestController
@RequestMapping("/ap/v1/person")

public  class  PersonController {

    private PersonRepositorio personRepositorio;

    @Autowired
    public PersonController(PersonRepositorio personRepositorio) {
        this.personRepositorio = personRepositorio;
    }

    @PostMapping
    public MessageReponseDTO createPerson (@RequestBody Person person) {
        Person savedPerson = personRepositorio.save(person);
        return MessageResponseDT0
                .builder()
                .message("criando person e ID" + savedPerson.getId())
                .build();
    }
}

