package sistema.api.desenvolvimento.api.gerencimento.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sistema.api.desenvolvimento.api.gerencimento.dto.MessageResponseDTO;
import sistema.api.desenvolvimento.api.gerencimento.entity.Person;
import sistema.api.desenvolvimento.api.gerencimento.repositorio.PersonRepositorio;

@Service
public class PersonService {

    private PersonRepositorio personRepositorio;

    @Autowired
    public PersonService(PersonRepositorio personRepositorio) {
        this.personRepositorio = personRepositorio;
    }


    public MessageResponseDTO createPerson (Person person) {
        Person savedPerson = personRepositorio.save(person);
        return MessageResponseDTO
                .builder()
                .message("created person with ID " + savedPerson.getId())
                .build();
    }
}
