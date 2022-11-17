package com.candidate.controller;

import com.candidate.dto.ResourceDTO;
import com.candidate.entity.Resource;
import com.candidate.service.Impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/v1")
public class ResourceController {

    @Autowired
    private ResourceServiceImpl service;

    @PostMapping("/create_resource")
    public String createResource(@RequestBody ResourceDTO resource){
        return service.createResource(resource);
    }

    @PutMapping("/update_resource")
    public String updateResource(@RequestBody ResourceDTO resource) {
        return service.updateResource(resource);
    }

    @DeleteMapping("/delete_resource/{id}")
    public String deleteResource(@PathVariable("id") Long id){
        return service.deleteResource(id);
    }

    @DeleteMapping("/delete_resource_all")
    public String deleteResourceAll(){
        return service.deleteResourceAll();
    }

    @GetMapping("/get_resource/{id}")
    public Optional<Resource> getResource(@PathVariable("id") Long id){
        return service.getResource(id);
    }

    @GetMapping("/get_resource_all")
    public List<Resource> getResourceList(){
        return service.getResourceList();
    }
}
