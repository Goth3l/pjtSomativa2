package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pet;
import com.example.demo.services.PetSevice;

@RestController
@RequestMapping("/pets")
public class PetController {
	
	private final PetSevice petService;

	   @Autowired
	   public PetController(PetSevice petService) {
	       this.petService = petService;
	   }

	   @PostMapping("/criar")
	   public Pet criarPet(@RequestBody Pet pet) {
	       return petService.salvarPet(pet);
	   }

	   @GetMapping
	   public List<Pet> buscarTodos() {
	       return petService.buscarTodosPet();
	   }

	   @GetMapping("/{id}")
	   public Pet buscarPorId(@PathVariable Long id) {
	       return petService.buscarPetPorId(id);
	   }

	   @DeleteMapping("/{id}")
	   public void deletarPet(@PathVariable Long id) {
		   petService.excluirPet(id);
	   }

	   @PutMapping
	   public ResponseEntity<Pet> PetAtualizado(@PathVariable Long id, @RequestBody Pet pet) {
		   Pet petAtualizado = petService.atualizarPet(id, pet);
	       if (petAtualizado != null) {
	           return ResponseEntity.ok(petAtualizado);
	       } else {
	           return null;
	       }
	   }
}
