package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaRepository {
	public void insertar(FacturaElectronica facturaElectronica);
	public FacturaElectronica buscar(Integer id);
    public void actualizar(FacturaElectronica facturaElectronica);
    public void eliminar(Integer id);
}
