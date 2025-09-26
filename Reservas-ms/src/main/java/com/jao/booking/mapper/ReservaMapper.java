package com.jao.booking.mapper;
import com.jao.booking.dto.ReservaDTO;
import com.jao.booking.entity.ReservaEntity;
//import com.jao.booking.entity.EstadoReserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {
	/*
    public ReservaDTO toDTO(ReservaEntity entity) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(entity.getId());
        dto.setUsuarioId(entity.getUsuarioId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setEstado(entity.getEstado().name());
        dto.setTotal(entity.getTotal());
        dto.setVueloId(entity.getVueloId());
        dto.setHotelId(entity.getHotelId());
        dto.setVehiculoId(entity.getVehiculoId());
        dto.setActividadId(entity.getActividadId());
        dto.setPagoId(entity.getPagoId());
        return dto;
    }
    
	/*
	 * public ReservaEntity toEntity(ReservaDTO dto) { ReservaEntity entity = new
	 * ReservaEntity(); entity.setId(dto.getId()); // Ojo: normalmente solo para
	 * updates entity.setUsuarioId(dto.getUsuarioId());
	 * entity.setFechaCreacion(dto.getFechaCreacion()); // Para estado convertimos
	 * String a Enum if(dto.getEstado() != null) {
	 * entity.setEstado(Enum.valueOf(ReservaEntity.EstadoReserva, dto.getEstado()));
	 * } entity.setTotal(dto.getTotal()); entity.setVueloId(dto.getVueloId());
	 * entity.setHotelId(dto.getHotelId());
	 * entity.setVehiculoId(dto.getVehiculoId());
	 * entity.setActividadId(dto.getActividadId());
	 * entity.setPagoId(dto.getPagoId()); return entity; }
	 */

}
