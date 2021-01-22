package io.github.vagnereix.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication {

	/* testando conxão com o bd
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository){
		return args -> {
			Cliente cliente = Cliente.builder().cpf("12345678901").nome("Vagner").build();
			repository.save(cliente);
		};
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
