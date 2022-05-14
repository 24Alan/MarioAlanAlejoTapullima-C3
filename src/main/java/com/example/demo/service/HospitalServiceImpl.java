package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.HospitalRequestDTO;
import com.example.demo.dto.HospitalResponseDTO;
import com.example.demo.model.Hospital;
import com.example.demo.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardarHospital(HospitalRequestDTO h) {
		// TODO Auto-generated method stub
		Hospital hospital = new Hospital();
		hospital.setIdHospital(h.getIdRequest());
		hospital.setNombreHospital(h.getNombreHospital());
		hospital.setDescripcionHospital(h.getDescripcionHospital());
		hospital.setDistritoHospital(h.getDistritoHospital());
		repository.save(hospital);

	}

	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarhospital(HospitalRequestDTO h) {
		// TODO Auto-generated method stub
		Hospital hospital = new Hospital();
		hospital.setIdHospital(h.getIdRequest());
		hospital.setNombreHospital(h.getNombreHospital());
		hospital.setDescripcionHospital(h.getDescripcionHospital());
		hospital.setDistritoHospital(h.getDistritoHospital());
		repository.saveAndFlush(hospital);

	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {
List<Hospital> hospital = repository.findAll();
		
		List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO hospitalDto = null;
		for (Hospital hospitales : hospital) {
			hospitalDto = new HospitalResponseDTO();
			hospitalDto.setIdResponse(hospitales.getIdHospital());
			hospitalDto.setNombreHospital(hospitales.getNombreHospital());
			hospitalDto.setDescripcionHospital(hospitales.getDescripcionHospital());
			hospitalDto.setDistritoHospital(hospitales.getDescripcionHospital());
			dto.add(hospitalDto);
		}
		
		return dto;
	}

	@Override
	public HospitalResponseDTO hospitalById(Integer id) {
		// TODO Auto-generated method stub
		Hospital hospitales = repository.findById(id).orElse(null);
		HospitalResponseDTO hospitalDto = new HospitalResponseDTO();
		
		hospitalDto = new HospitalResponseDTO();
		hospitalDto.setIdResponse(hospitales.getIdHospital());
		hospitalDto.setNombreHospital(hospitales.getNombreHospital());
		hospitalDto.setDescripcionHospital(hospitales.getDescripcionHospital());
		hospitalDto.setDistritoHospital(hospitales.getDescripcionHospital());
		
		return hospitalDto;
	}
	

}
