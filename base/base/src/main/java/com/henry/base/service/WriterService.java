package com.henry.base.service;

import com.henry.base.model.Writer;
import com.henry.base.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    // get all the writers across autowired
    public List<Writer> getWriters() {
        return writerRepository.findAll();
    }

    // get a writer by id
    public Writer getWriter(Integer id){
        return writerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    // add a writer
    public Writer addWriter(Writer writer){
        return writerRepository.save(writer);
    }

    // delete a writer by id
    public void deleteWriterById(Integer id){
        writerRepository.deleteById(id);
    }

    // edit a writer
    public Writer editWriter(Writer writer, Integer id){
        Writer myWriter = writerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        myWriter.setDni(writer.getDni());
        myWriter.setName(writer.getName());
        myWriter.setSurname(writer.getSurname());

        return writerRepository.save(myWriter);
    }

}
