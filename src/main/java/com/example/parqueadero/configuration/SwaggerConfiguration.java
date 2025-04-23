package com.example.parqueadero.configuration;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customopenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API del parcial")
                        .version("1.0")
                        .description("Documentación de la APi para gestionar Informacion  de equipos de futbol y partidos")
                        .contact(new Contact()
                                .name("API parcialFutbol")
                                .email("julianherrera0206@gmail.com@gmail.com")))
        .tags(List.of(
                new Tag().name("Jugadores").description("Operaciones relacionadas con jugadores"),
                new Tag().name("Entrenadores").description("Operaciones sobre entrenadores"),
                new Tag().name("Partidos").description("Operaciones sobre partidos"),
                new Tag().name("Estadísticas").description("Consultas estadísticas del sistema")
        ));
    }
}
