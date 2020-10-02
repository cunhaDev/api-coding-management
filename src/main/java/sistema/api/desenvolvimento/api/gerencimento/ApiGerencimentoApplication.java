package sistema.api.desenvolvimento.api.gerencimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
@SpringBootApplication
public class ApiGerencimentoApplication {

    @GetMapping
    public String getBook(){
        return "API Test!";
    }
	public static void main(String[] args) {
		SpringApplication.run(ApiGerencimentoApplication.class, args);
	}

}
