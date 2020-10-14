package sistema.api.desenvolvimento.api.gerencimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sistema.api.desenvolvimento.api.gerencimento.dto.request.PersonDTO;
import sistema.api.desenvolvimento.api.gerencimento.dto.response.MessageResponseDTO;
import sistema.api.desenvolvimento.api.gerencimento.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")

public  class  PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson (@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}

