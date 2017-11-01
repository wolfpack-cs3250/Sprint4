package com.banner.bannerApplication;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.Rooms;
import com.banner.bannerApplication.repositories.BuildingRepository;
import com.banner.bannerApplication.repositories.ProfessorRepository;
import com.banner.bannerApplication.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BannerApplication.class, args);
	}



	@Bean
    ApplicationRunner init(ProfessorRepository professorRepository) {
	    return (evt) -> Arrays.asList(
	            "TBD".split(","))
                .forEach(
                        a -> {
                            Professor defaultProfessor = new Professor();
                            defaultProfessor.setFirstName(a);
                            defaultProfessor.setLastName(" ");
                            professorRepository.save(defaultProfessor);
                        });
	}
    @Bean
    ApplicationRunner init2(BuildingRepository buildingRepository, RoomsRepository roomsRepository) {
        return (evt) -> Arrays.asList(
                "TBD".split(","))
                .forEach(
                        a -> {
                            Buildings defaultBuilding = new Buildings();
                            defaultBuilding.setBuildingName("TBD");
                            defaultBuilding.setAcronym("TBD");
                            defaultBuilding.setAddress(" ");

                            Rooms defaultRoom = new Rooms();
                            defaultRoom.setBuildings(defaultBuilding);
                            defaultRoom.setRoomNumber(" ");
                            defaultRoom.setRoomSize("0");

                            buildingRepository.save(defaultBuilding);
                            roomsRepository.save(defaultRoom);
                        });
    }

}
