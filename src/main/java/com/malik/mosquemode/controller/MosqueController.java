package com.malik.mosquemode.controller;

import com.malik.mosquemode.entity.Mosque;
import com.malik.mosquemode.repository.MosqueRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/api/mosques")
public class MosqueController {

    private final MosqueRepository mosqueRepository;

    public MosqueController(MosqueRepository mosqueRepository) {
        this.mosqueRepository = mosqueRepository;
    }

    @GetMapping
    public List<Mosque> getAllMosques() {
        return mosqueRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mosque getMosqueById(@PathVariable Long id) {
        return mosqueRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Mosque not found"));
    }

    @PostMapping
    public Mosque createMosque(@RequestBody Mosque mosque) {
        return mosqueRepository.save(mosque);
    }

    @PutMapping("/{id}")
    public Mosque updateMosque(
            @PathVariable Long id,
            @RequestBody Mosque mosque
    ) {
        Mosque existingMosque =
                mosqueRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Mosque not found"));

        existingMosque.setName(mosque.getName());
        existingMosque.setLocation(mosque.getLocation());
        existingMosque.setLatitude(mosque.getLatitude());
        existingMosque.setLongitude(mosque.getLongitude());

        return mosqueRepository.save(existingMosque);
    }

    @DeleteMapping("/{id}")
    public void deleteMosque(@PathVariable Long id) {
        mosqueRepository.deleteById(id);
    }
}