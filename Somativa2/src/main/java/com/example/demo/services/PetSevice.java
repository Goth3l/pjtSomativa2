package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pet;
import com.example.demo.repositories.PetRepository;

@Service
public class PetSevice {

	private PetRepository petRepository;

	@Autowired
	public PetSevice(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public Pet salvarPet(Pet pet) {
		return petRepository.save(pet);

	}

	public Pet buscarPetPorId(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	public List<Pet> buscarTodosPet() {
		return petRepository.findAll();
	}

	public void excluirPet(Long id) {
		petRepository.deleteById(id);
	}

	public Pet atualizarPet(Long id, Pet petAtualizado) {
		Optional<Pet> petExistente = petRepository.findById(id);
		if (petExistente.isPresent()) {
			Pet pet = petExistente.get();
			pet.setNome(petAtualizado.getNome());
			pet.setRaca(petAtualizado.getRaca());
			return petRepository.save(pet);
		}
		return petAtualizado;
	}
}