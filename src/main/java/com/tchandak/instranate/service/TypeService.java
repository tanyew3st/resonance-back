package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Type;
import com.tchandak.instranate.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Type> getAllTypes() {
        List<Type> type = new ArrayList<>();
        typeRepository.findAll()
                .forEach(type::add);
        return type;
    }

    public Type getTypeById(Integer id) {

        //return type.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return typeRepository.findOne(id);
    }

    public void addType(Type type) {
        typeRepository.save(type);
    }

    public void updateType(Integer id, Type type) {
        typeRepository.save(type);
    }

    public void deleteType(Integer id) {
        typeRepository.delete(id);
    }
}
