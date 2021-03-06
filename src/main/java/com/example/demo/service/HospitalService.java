package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.HospitalRequestDTO;
import com.example.demo.dto.HospitalResponseDTO;
public interface HospitalService {
	public void guardarHospital(HospitalRequestDTO p);
	public void eliminarHospital(Integer id);
	public void editarhospital(HospitalRequestDTO p);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO hospitalById(Integer id);
}
