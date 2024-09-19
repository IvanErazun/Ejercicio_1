package ar.edu.utn.frba.dds.ejercicio_01.motivaciones;

import javax.persistence.AttributeConverter;

public class MotivacionConverter implements AttributeConverter<Motivacion, String>{

	//Si se agrega un nuevo notificador, se debe agregar una nueva instancia en el if
	@Override
	public String convertToDatabaseColumn(Motivacion motivacion) {
		if (motivacion instanceof Mantener ||
			motivacion instanceof BajarDePeso ||
			motivacion instanceof Tonificar) {
			return motivacion.getClass().getSimpleName();
		}
		return null;
	}

	@Override
	public Motivacion convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return ServiceLocator.get(dbData);
	}
}
