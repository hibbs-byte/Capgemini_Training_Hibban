package com.capgi.service.impl;

import com.capgi.entity.Panda;
import com.capgi.repository.PandaRepository;
import com.capgi.service.PandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PandaServiceImpl implements PandaService {

    private final PandaRepository pandaRepository;


    @Override
    public void save(Panda panda) {
        pandaRepository.save(panda);
    }

    @Override
    public void updatePanda(Integer id, Panda panda) {
        Optional<Panda> exist= pandaRepository.findById(id);
        if(exist.isPresent()){
            Panda panda1=exist.get();
            panda1.setName(panda.getName());
            panda1.setWeight(panda.getWeight());
            pandaRepository.save(panda1);
        }
    }

    @Override
    public List<Panda> findAll() {
        return pandaRepository.findAll();
    }

    @Override
    public void deleteBYId(Integer id) {

      Panda panda=  pandaRepository.getReferenceById(id);
        System.out.println(panda);
        pandaRepository.delete(panda);

    }

    @Override
    public Panda findById(Integer id) {
        Optional<Panda> panda=pandaRepository.findById(id);
        if(panda.isEmpty()){
            System.out.println("No panda");
        }
        return panda.get();
    }

    @Override
    public Object findByIdObjectType(Integer id) {
       Optional<Panda> panda= pandaRepository.findById(id);
       if (panda.isEmpty()){
           return "Panda not found for the Id :"+id;
       }

        return panda.get();
    }

}
