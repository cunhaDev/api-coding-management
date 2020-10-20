package sistema.api.desenvolvimento.api.gerencimento.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.api.desenvolvimento.api.gerencimento.dto.request.PersonDTO;
import sistema.api.desenvolvimento.api.gerencimento.dto.response.MessageResponseDTO;
import sistema.api.desenvolvimento.api.gerencimento.entity.Person;
import sistema.api.desenvolvimento.api.gerencimento.mapper.PersonMapper;
import sistema.api.desenvolvimento.api.gerencimento.repositorio.PersonRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepositorio personRepositorio;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepositorio personRepositorio) {
        this.personRepositorio = personRepositorio;
    }


    public MessageResponseDTO createPerson (PersonDTO personDTO) {
          Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepositorio.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("created person with ID " + savedPerson.getId())
                .build();
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepositorio.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO findById(Long id) {
        Optional<Person> optionalPerson = personRepositorio.findById(id);
    if (optionalPerson.isEmpty()) {
        throw new PersonNotFoundException(id);
    }
        return personMapper.toDTO(optionalPerson.get());
    }
}
