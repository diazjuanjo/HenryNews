package com.henry.base.controller;

import com.henry.base.converter.WriterToWriterDTOConverter;
import com.henry.base.model.Writer;
import com.henry.base.model.dto.WriterDTO;
import com.henry.base.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private WriterService writerService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private WriterToWriterDTOConverter writerToWriterDTOConverter;

    @GetMapping
    @Operation(summary = "Get all writers")
    public List<Writer> getWriters(){
        return writerService.getWriters();
    }

    @GetMapping("/writerDTO")
    @Operation(summary = "Get all writers DTO")
    public List<WriterDTO> getAllWritersDTO(){
        return conversionService.convert(writerService.getWriters(), List.class);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get writer by id")
    public Writer getWriter(@PathVariable Integer id){
        return writerService.getWriter(id);
    }

    @GetMapping("writerDTO/{id}")
    @Operation(summary = "Get writer DTO by id")
    public WriterDTO getWriterDTOById(@PathVariable Integer id){
        return conversionService.convert(writerService.getWriter(id), WriterDTO.class);
    }

    @PostMapping
    @Operation(summary = "Add a new writer")
    public String addWriter(@RequestBody Writer writer) {
        Writer newWriter = writerService.addWriter(writer);
        return ("Writer created: " + newWriter);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a writer")
    public String editWriter(@RequestBody Writer writer, @PathVariable Integer id){
        Writer editedWriter = writerService.editWriter(writer, id);
        return ("Writer edited: " + editedWriter);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete writer by id")
    public String deleteWrite(@PathVariable Integer id){
        writerService.deleteWriterById(id);
        return ("Writer deleted by id: " + id);
    }

}
