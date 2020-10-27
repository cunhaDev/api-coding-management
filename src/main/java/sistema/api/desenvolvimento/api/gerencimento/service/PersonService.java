package sistema.api.desenvolvimento.api.gerencimento.service;


import org.springframework.stereotype.Service;
import sistema.api.desenvolvimento.api.gerencimento.dto.request.PersonDTO;
import sistema.api.desenvolvimento.api.gerencimento.dto.response.MessageResponseDTO;
import sistema.api.desenvolvimento.api.gerencimento.entity.Person;
import sistema.api.desenvolvimento.api.gerencimento.exception.PersonNotFoundException;
import sistema.api.desenvolvimento.api.gerencimento.mapper.PersonMapper;
import sistema.api.desenvolvimento.api.gerencimento.repositorio.PersonRepositorio;

import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.*;

@Service
public class PersonService {

    private PersonRepositorio personRepositorio;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepositorio.save(personToSave);
        return createMessageResponse(savedPerson.getId (), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepositorio.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepositorio.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepositorio.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepositorio.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }
}
